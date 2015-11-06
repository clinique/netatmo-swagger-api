package io.swagger.client;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.oltu.oauth2.client.request.OAuthClientRequest.AuthenticationRequestBuilder;
import org.apache.oltu.oauth2.client.request.OAuthClientRequest.TokenRequestBuilder;

import retrofit.RestAdapter;
import retrofit.client.OkClient;
import retrofit.converter.ConversionException;
import retrofit.converter.Converter;
import retrofit.converter.GsonConverter;
import retrofit.mime.TypedByteArray;
import retrofit.mime.TypedInput;
import retrofit.mime.TypedOutput;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParseException;
import com.squareup.okhttp.Interceptor;
import com.squareup.okhttp.OkHttpClient;

import io.swagger.client.auth.HttpBasicAuth;
import io.swagger.client.auth.ApiKeyAuth;
import io.swagger.client.auth.OAuth;
import io.swagger.client.auth.OAuthFlow;


public class ApiClient {

    private Map<String, Interceptor> apiAuthorizations;
    private OkHttpClient okClient;
    private RestAdapter.Builder adapterBuilder;

    public ApiClient() {
        apiAuthorizations = new LinkedHashMap<String, Interceptor>();
        createDefaultAdapter();
    }
    
    public ApiClient(String[] authNames) {
        this();
        okClient = new OkHttpClient();
        adapterBuilder.setClient(new OkClient(okClient));
        for(String authName : authNames) {
            if (apiAuthorizations.containsKey(authName)) {
                throw new RuntimeException("auth name \"" + authName + "\" already in api authorizations");
            }
            Interceptor auth;
            if (authName == "code_oauth") { 
                auth = new OAuth(OAuthFlow.accessCode, "https://api.netatmo.net/oauth2/authorize", "https://api.netatmo.net/oauth2/token", "read_station, write_thermostat, read_thermostat");
            } else 
            if (authName == "password_oauth") { 
                auth = new OAuth(OAuthFlow.password, "", "https://api.netatmo.net/oauth2/token", "");
            } else {
                throw new RuntimeException("auth name \"" + authName + "\" not found in available auth names");
            }
            apiAuthorizations.put(authName, auth);
        }
        addAuthsToOkClient(okClient);
    }

    /**
     * Basic constructor for single auth name
     * @param authName
     */
    public ApiClient(String authName) {
        this(new String[]{authName});
    }

    /**
     * Helper constructor for single api key
     * @param authName
     * @param apiKey
     */
    public ApiClient(String authName, String apiKey) {
        this(authName);
        this.setApiKey(apiKey);
    }

    /**
     * Helper constructor for single basic auth or password oauth2
     * @param authName
     * @param username
     * @param password
     */
    public ApiClient(String authName, String username, String password) {
        this(authName);
        this.setCredentials(username,  password);
    }

    /**
     * Helper constructor for single password oauth2
     * @param authName
     * @param clientId
     * @param secret
     * @param username
     * @param password
     */
    public ApiClient(String authName, String clientId, String secret, String username, String password) {
        this(authName);
        this.getTokenEndPoint()
                .setClientId(clientId)
                .setClientSecret(secret)
                .setUsername(username)
                .setPassword(password);
    }
    
   public void createDefaultAdapter() {
        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ")
                .create();

        adapterBuilder = new RestAdapter
                .Builder()
                .setEndpoint("https://api.netatmo.net/api")
                .setConverter(new GsonConverterWrapper(gson));
    }

    public <S> S createService(Class<S> serviceClass) {
        return adapterBuilder.build().create(serviceClass);
        
    }

    /**
     * Helper method to configure the first api key found
     * @param apiKey
     */
    private void setApiKey(String apiKey) {
        for(Interceptor apiAuthorization : apiAuthorizations.values()) {
            if (apiAuthorization instanceof ApiKeyAuth) {
                ApiKeyAuth keyAuth = (ApiKeyAuth) apiAuthorization;
                keyAuth.setApiKey(apiKey);
                return;
            }
        }
    }

    /**
     * Helper method to configure the username/password for basic auth or password oauth
     * @param username
     * @param password
     */
    private void setCredentials(String username, String password) {
        for(Interceptor apiAuthorization : apiAuthorizations.values()) {
            if (apiAuthorization instanceof HttpBasicAuth) {
                HttpBasicAuth basicAuth = (HttpBasicAuth) apiAuthorization;
                basicAuth.setCredentials(username, password);
                return;
            }
            if (apiAuthorization instanceof OAuth) {
                OAuth oauth = (OAuth) apiAuthorization;
                oauth.getTokenRequestBuilder().setUsername(username).setPassword(password);
                return;
            }
        }
    }

    /**
     * Helper method to configure the token endpoint of the first oauth found in the apiAuthorizations (there should be only one)
     * @return
     */
    public TokenRequestBuilder getTokenEndPoint() {
        for(Interceptor apiAuthorization : apiAuthorizations.values()) {
            if (apiAuthorization instanceof OAuth) {
                OAuth oauth = (OAuth) apiAuthorization;
                return oauth.getTokenRequestBuilder();
            }
        }
        return null;
    }

    /**
     * Helper method to configure authorization endpoint of the first oauth found in the apiAuthorizations (there should be only one)
     * @return
     */
    public AuthenticationRequestBuilder getAuthorizationEndPoint() {
        for(Interceptor apiAuthorization : apiAuthorizations.values()) {
            if (apiAuthorization instanceof OAuth) {
                OAuth oauth = (OAuth) apiAuthorization;
                return oauth.getAuthenticationRequestBuilder();
            }
        }
        return null;
    }

    /**
     * Helper method to pre-set the oauth access token of the first oauth found in the apiAuthorizations (there should be only one)
     * @param accessToken
     */
    public void setAccessToken(String accessToken) {
        for(Interceptor apiAuthorization : apiAuthorizations.values()) {
            if (apiAuthorization instanceof OAuth) {
                OAuth oauth = (OAuth) apiAuthorization;
                oauth.setAccessToken(accessToken);
                return;
            }
        }
    }
    
    /**
     * Helper method to configure the oauth accessCode/implicit flow parameters
     * @param clientId
     * @param clientSecret
     * @param redirectURI
     */
    public void configureAuthorizationFlow(String clientId, String clientSecret, String redirectURI) {
        for(Interceptor apiAuthorization : apiAuthorizations.values()) {
            if (apiAuthorization instanceof OAuth) {
                OAuth oauth = (OAuth) apiAuthorization;
                oauth.getTokenRequestBuilder()
                        .setClientId(clientId)
                        .setClientSecret(clientSecret)
                        .setRedirectURI(redirectURI);
                oauth.getAuthenticationRequestBuilder()
                        .setClientId(clientId)
                        .setRedirectURI(redirectURI);
                return;
            }
        }
    }
    
    public Map<String, Interceptor> getApiAuthorizations() {
        return apiAuthorizations;
    }

    public void setApiAuthorizations(Map<String, Interceptor> apiAuthorizations) {
        this.apiAuthorizations = apiAuthorizations;
    }

    public RestAdapter.Builder getAdapterBuilder() {
        return adapterBuilder;
    }

    public void setAdapterBuilder(RestAdapter.Builder adapterBuilder) {
        this.adapterBuilder = adapterBuilder;
    }

    public OkHttpClient getOkClient() {
        return okClient;
    }
    
    public void addAuthsToOkClient(OkHttpClient okClient) {
        for(Interceptor apiAuthorization : apiAuthorizations.values()) {
            okClient.interceptors().add(apiAuthorization);
        }
    }

    /**
     * Clones the okClient given in parameter, adds the auth interceptors and uses it to configure the RestAdapter
     * @param okClient
     */
    public void configureFromOkclient(OkHttpClient okClient) {
        OkHttpClient clone = okClient.clone();
        addAuthsToOkClient(clone);
        adapterBuilder.setClient(new OkClient(clone));
    }
}

/**
 * This wrapper is to take care of this case:
 * when the deserialization fails due to JsonParseException and the
 * expected type is String, then just return the body string.
 */
class GsonConverterWrapper implements Converter {
    private GsonConverter converter;

    public GsonConverterWrapper(Gson gson) {
        converter = new GsonConverter(gson);
    }

    @Override public Object fromBody(TypedInput body, Type type) throws ConversionException {
        byte[] bodyBytes = readInBytes(body);
        TypedByteArray newBody = new TypedByteArray(body.mimeType(), bodyBytes);
        try {
            return converter.fromBody(newBody, type);
        } catch (ConversionException e) {
            if (e.getCause() instanceof JsonParseException && type.equals(String.class)) {
                return new String(bodyBytes);
            } else {
                throw e;
            }
        }
    }

    @Override public TypedOutput toBody(Object object) {
        return converter.toBody(object);
    }

    private byte[] readInBytes(TypedInput body) throws ConversionException {
        InputStream in = null;
        try {
            in = body.in();
            ByteArrayOutputStream os = new ByteArrayOutputStream();
            byte[] buffer = new byte[0xFFFF];
            for (int len; (len = in.read(buffer)) != -1;)
                os.write(buffer, 0, len);
            os.flush();
            return os.toByteArray();
        } catch (IOException e) {
            throw new ConversionException(e);
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException ignored) {
                }
            }
        }

    }
}