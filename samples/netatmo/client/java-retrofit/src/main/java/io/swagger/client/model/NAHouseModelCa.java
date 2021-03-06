package io.swagger.client.model;

import io.swagger.client.StringUtil;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

import io.swagger.annotations.*;



@ApiModel(description = "")
public class NAHouseModelCa implements Serializable {
  
  @SerializedName("te")
  private Double te = null;
  
  @SerializedName("ti")
  private Integer ti = null;
  
  @SerializedName("so")
  private String so = null;
  

  
  /**
   **/
  @ApiModelProperty(value = "")
  public Double getTe() {
    return te;
  }
  public void setTe(Double te) {
    this.te = te;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  public Integer getTi() {
    return ti;
  }
  public void setTi(Integer ti) {
    this.ti = ti;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  public String getSo() {
    return so;
  }
  public void setSo(String so) {
    this.so = so;
  }

  

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class NAHouseModelCa {\n");
    
    sb.append("    te: ").append(StringUtil.toIndentedString(te)).append("\n");
    sb.append("    ti: ").append(StringUtil.toIndentedString(ti)).append("\n");
    sb.append("    so: ").append(StringUtil.toIndentedString(so)).append("\n");
    sb.append("}");
    return sb.toString();
  }
}
