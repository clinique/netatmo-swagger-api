# coding: utf-8

"""
Copyright 2015 SmartBear Software

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.

    Ref: https://github.com/swagger-api/swagger-codegen
"""

from pprint import pformat
from six import iteritems


class NALinkStation(object):
    """
    NOTE: This class is auto generated by the swagger code generator program.
    Do not edit the class manually.
    """
    def __init__(self):
        """
        NALinkStation - a model defined in Swagger

        :param dict swaggerTypes: The key is attribute name
                                  and the value is attribute type.
        :param dict attributeMap: The key is attribute name
                                  and the value is json key in definition.
        """
        self.swagger_types = {
            'mac': 'str',
            'ext': 'str',
            'temperature': 'float'
        }

        self.attribute_map = {
            'mac': 'mac',
            'ext': 'ext',
            'temperature': 'Temperature'
        }

        self._mac = None
        self._ext = None
        self._temperature = None

    @property
    def mac(self):
        """
        Gets the mac of this NALinkStation.


        :return: The mac of this NALinkStation.
        :rtype: str
        """
        return self._mac

    @mac.setter
    def mac(self, mac):
        """
        Sets the mac of this NALinkStation.


        :param mac: The mac of this NALinkStation.
        :type: str
        """
        self._mac = mac

    @property
    def ext(self):
        """
        Gets the ext of this NALinkStation.


        :return: The ext of this NALinkStation.
        :rtype: str
        """
        return self._ext

    @ext.setter
    def ext(self, ext):
        """
        Sets the ext of this NALinkStation.


        :param ext: The ext of this NALinkStation.
        :type: str
        """
        self._ext = ext

    @property
    def temperature(self):
        """
        Gets the temperature of this NALinkStation.


        :return: The temperature of this NALinkStation.
        :rtype: float
        """
        return self._temperature

    @temperature.setter
    def temperature(self, temperature):
        """
        Sets the temperature of this NALinkStation.


        :param temperature: The temperature of this NALinkStation.
        :type: float
        """
        self._temperature = temperature

    def to_dict(self):
        """
        Returns the model properties as a dict
        """
        result = {}

        for attr, _ in iteritems(self.swagger_types):
            value = getattr(self, attr)
            if isinstance(value, list):
                result[attr] = list(map(
                    lambda x: x.to_dict() if hasattr(x, "to_dict") else x,
                    value
                ))
            elif hasattr(value, "to_dict"):
                result[attr] = value.to_dict()
            else:
                result[attr] = value

        return result

    def to_str(self):
        """
        Returns the string representation of the model
        """
        return pformat(self.to_dict())

    def __repr__(self):
        """
        For `print` and `pprint`
        """
        return self.to_str()
