package WWW::SwaggerClient::Object::NAThermProgram;

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
    'program_id' => 'string',
    'name' => 'string',
    'zones' => 'ARRAY[NAZone]',
    'timetable' => 'ARRAY[NATimeTableItem]',
    'selected' => 'boolean'
};

my $attribute_map = {
    'program_id' => 'program_id',
    'name' => 'name',
    'zones' => 'zones',
    'timetable' => 'timetable',
    'selected' => 'selected'
};

# new object
sub new { 
    my ($class, %args) = @_; 
    my $self = { 
        #
        'program_id' => $args{'program_id'}, 
        #
        'name' => $args{'name'}, 
        #
        'zones' => $args{'zones'}, 
        #
        'timetable' => $args{'timetable'}, 
        #
        'selected' => $args{'selected'}
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
