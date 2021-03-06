#import <Foundation/Foundation.h>
#import "SWGObject.h"

/**
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */

#import "SWGNASetpoint.h"
#import "SWGNAThermProgram.h"
#import "SWGNAThermMeasure.h"


@protocol SWGNAThermStateBody
@end

@interface SWGNAThermStateBody : SWGObject


@property(nonatomic) SWGNASetpoint* setpoint;

@property(nonatomic) SWGNASetpoint* setpointOrder;

@property(nonatomic) SWGNAThermProgram* thermProgram;

@property(nonatomic) NSArray<SWGNAThermProgram>* thermProgramBackup;

@property(nonatomic) SWGNAThermProgram* thermProgramOrder;

@property(nonatomic) NSNumber* thermOrientation;

@property(nonatomic) NSNumber* thermRelayCmd;

@property(nonatomic) NSNumber* batteryVp;

@property(nonatomic) NSNumber* rfStatus;

@property(nonatomic) NSNumber* plugConnectedBoiler;

@property(nonatomic) NSNumber* udpConn;

@property(nonatomic) NSNumber* lastThermSeen;

@property(nonatomic) NSNumber* lastPlugSeen;

@property(nonatomic) NSNumber* wifiStatus;

@property(nonatomic) SWGNAThermMeasure* measured;

@end
