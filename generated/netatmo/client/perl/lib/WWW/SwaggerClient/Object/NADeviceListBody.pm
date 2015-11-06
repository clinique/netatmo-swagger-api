package WWW::SwaggerClient::Object::NADeviceListBody;

require 5.6.0;
use strict;
use warnings;
use utf8;
use JSON qw(decode_json);
use Data::Dumper;
use Module::Runtime qw(use_module);
use Log::Any qw($log);
use Date::Parse;
use DateTime;

use base "WWW::SwaggerClient::Object::BaseObject";

#
#
#
#NOTE: This class is auto generated by the swagger code generator program. Do not edit the class manually.
#

my $swagger_types = {
    'devices' => 'ARRAY[NADevice]',
    'modules' => 'ARRAY[NAModule]'
};

my $attribute_map = {
    'devices' => 'devices',
    'modules' => 'modules'
};

# new object
sub new { 
    my ($class, %args) = @_; 
    my $self = { 
        #
        'devices' => $args{'devices'}, 
        #
        'modules' => $args{'modules'}
    }; 

    return bless $self, $class; 
}  

# get swagger type of the attribute
sub get_swagger_types {
    return $swagger_types;
}

# get attribute mappping
sub get_attribute_map {
    return $attribute_map;
}

1;