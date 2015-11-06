<?php
/**
 * NAUserBody
 *
 * PHP version 5
 *
 * @category Class
 * @package  Swagger\Client
 * @author   http://github.com/swagger-api/swagger-codegen
 * @license  http://www.apache.org/licenses/LICENSE-2.0 Apache Licene v2
 * @link     https://github.com/swagger-api/swagger-codegen
 */
/**
 *  Copyright 2015 SmartBear Software
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
/**
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */

namespace Swagger\Client\Model;

use \ArrayAccess;
/**
 * NAUserBody Class Doc Comment
 *
 * @category    Class
 * @description 
 * @package     Swagger\Client
 * @author      http://github.com/swagger-api/swagger-codegen
 * @license     http://www.apache.org/licenses/LICENSE-2.0 Apache Licene v2
 * @link        https://github.com/swagger-api/swagger-codegen
 */
class NAUserBody implements ArrayAccess
{
    /**
      * Array of property to type mappings. Used for (de)serialization 
      * @var string[]
      */
    static $swaggerTypes = array(
        '_id' => 'string',
        'administrative' => '\Swagger\Client\Model\NAUserAdministrative',
        'date_creation' => '\Swagger\Client\Model\NADate',
        'devices' => 'string[]',
        'friend_devices' => 'string[]',
        'mail' => 'string',
        'timeline_not_read' => 'int',
        'timeline_size' => 'int'
    );
  
    /** 
      * Array of attributes where the key is the local name, and the value is the original name
      * @var string[] 
      */
    static $attributeMap = array(
        '_id' => '_id',
        'administrative' => 'administrative',
        'date_creation' => 'date_creation',
        'devices' => 'devices',
        'friend_devices' => 'friend_devices',
        'mail' => 'mail',
        'timeline_not_read' => 'timeline_not_read',
        'timeline_size' => 'timeline_size'
    );
  
    /**
      * Array of attributes to setter functions (for deserialization of responses)
      * @var string[]
      */
    static $setters = array(
        '_id' => 'setId',
        'administrative' => 'setAdministrative',
        'date_creation' => 'setDateCreation',
        'devices' => 'setDevices',
        'friend_devices' => 'setFriendDevices',
        'mail' => 'setMail',
        'timeline_not_read' => 'setTimelineNotRead',
        'timeline_size' => 'setTimelineSize'
    );
  
    /**
      * Array of attributes to getter functions (for serialization of requests)
      * @var string[]
      */
    static $getters = array(
        '_id' => 'getId',
        'administrative' => 'getAdministrative',
        'date_creation' => 'getDateCreation',
        'devices' => 'getDevices',
        'friend_devices' => 'getFriendDevices',
        'mail' => 'getMail',
        'timeline_not_read' => 'getTimelineNotRead',
        'timeline_size' => 'getTimelineSize'
    );
  
    
    /**
      * $_id 
      * @var string
      */
    protected $_id;
    
    /**
      * $administrative Contains administrative information related to the user
      * @var \Swagger\Client\Model\NAUserAdministrative
      */
    protected $administrative;
    
    /**
      * $date_creation 
      * @var \Swagger\Client\Model\NADate
      */
    protected $date_creation;
    
    /**
      * $devices An array of string containing the ids of the devices owned by the user
      * @var string[]
      */
    protected $devices;
    
    /**
      * $friend_devices An array of string containing the ids of the devices on which the user has a \"guest\" access
      * @var string[]
      */
    protected $friend_devices;
    
    /**
      * $mail 
      * @var string
      */
    protected $mail;
    
    /**
      * $timeline_not_read 
      * @var int
      */
    protected $timeline_not_read;
    
    /**
      * $timeline_size 
      * @var int
      */
    protected $timeline_size;
    

    /**
     * Constructor
     * @param mixed[] $data Associated array of property value initalizing the model
     */
    public function __construct(array $data = null)
    {
        if ($data != null) {
            $this->_id = $data["_id"];
            $this->administrative = $data["administrative"];
            $this->date_creation = $data["date_creation"];
            $this->devices = $data["devices"];
            $this->friend_devices = $data["friend_devices"];
            $this->mail = $data["mail"];
            $this->timeline_not_read = $data["timeline_not_read"];
            $this->timeline_size = $data["timeline_size"];
        }
    }
    
    /**
     * Gets _id
     * @return string
     */
    public function getId()
    {
        return $this->_id;
    }
  
    /**
     * Sets _id
     * @param string $_id 
     * @return $this
     */
    public function setId($_id)
    {
        
        $this->_id = $_id;
        return $this;
    }
    
    /**
     * Gets administrative
     * @return \Swagger\Client\Model\NAUserAdministrative
     */
    public function getAdministrative()
    {
        return $this->administrative;
    }
  
    /**
     * Sets administrative
     * @param \Swagger\Client\Model\NAUserAdministrative $administrative Contains administrative information related to the user
     * @return $this
     */
    public function setAdministrative($administrative)
    {
        
        $this->administrative = $administrative;
        return $this;
    }
    
    /**
     * Gets date_creation
     * @return \Swagger\Client\Model\NADate
     */
    public function getDateCreation()
    {
        return $this->date_creation;
    }
  
    /**
     * Sets date_creation
     * @param \Swagger\Client\Model\NADate $date_creation 
     * @return $this
     */
    public function setDateCreation($date_creation)
    {
        
        $this->date_creation = $date_creation;
        return $this;
    }
    
    /**
     * Gets devices
     * @return string[]
     */
    public function getDevices()
    {
        return $this->devices;
    }
  
    /**
     * Sets devices
     * @param string[] $devices An array of string containing the ids of the devices owned by the user
     * @return $this
     */
    public function setDevices($devices)
    {
        
        $this->devices = $devices;
        return $this;
    }
    
    /**
     * Gets friend_devices
     * @return string[]
     */
    public function getFriendDevices()
    {
        return $this->friend_devices;
    }
  
    /**
     * Sets friend_devices
     * @param string[] $friend_devices An array of string containing the ids of the devices on which the user has a \"guest\" access
     * @return $this
     */
    public function setFriendDevices($friend_devices)
    {
        
        $this->friend_devices = $friend_devices;
        return $this;
    }
    
    /**
     * Gets mail
     * @return string
     */
    public function getMail()
    {
        return $this->mail;
    }
  
    /**
     * Sets mail
     * @param string $mail 
     * @return $this
     */
    public function setMail($mail)
    {
        
        $this->mail = $mail;
        return $this;
    }
    
    /**
     * Gets timeline_not_read
     * @return int
     */
    public function getTimelineNotRead()
    {
        return $this->timeline_not_read;
    }
  
    /**
     * Sets timeline_not_read
     * @param int $timeline_not_read 
     * @return $this
     */
    public function setTimelineNotRead($timeline_not_read)
    {
        
        $this->timeline_not_read = $timeline_not_read;
        return $this;
    }
    
    /**
     * Gets timeline_size
     * @return int
     */
    public function getTimelineSize()
    {
        return $this->timeline_size;
    }
  
    /**
     * Sets timeline_size
     * @param int $timeline_size 
     * @return $this
     */
    public function setTimelineSize($timeline_size)
    {
        
        $this->timeline_size = $timeline_size;
        return $this;
    }
    
    /**
     * Returns true if offset exists. False otherwise.
     * @param  integer $offset Offset 
     * @return boolean
     */
    public function offsetExists($offset)
    {
        return isset($this->$offset);
    }
  
    /**
     * Gets offset.
     * @param  integer $offset Offset 
     * @return mixed 
     */
    public function offsetGet($offset)
    {
        return $this->$offset;
    }
  
    /**
     * Sets value based on offset.
     * @param  integer $offset Offset 
     * @param  mixed   $value  Value to be set
     * @return void
     */
    public function offsetSet($offset, $value)
    {
        $this->$offset = $value;
    }
  
    /**
     * Unsets offset.
     * @param  integer $offset Offset 
     * @return void
     */
    public function offsetUnset($offset)
    {
        unset($this->$offset);
    }
  
    /**
     * Gets the string presentation of the object
     * @return string
     */
    public function __toString()
    {
        if (defined('JSON_PRETTY_PRINT')) {
            return json_encode(get_object_vars($this), JSON_PRETTY_PRINT);
        } else {
            return json_encode(get_object_vars($this));
        }
    }
}