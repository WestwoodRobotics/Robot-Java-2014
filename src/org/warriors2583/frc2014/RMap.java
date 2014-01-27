package org.warriors2583.frc2014;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RMap {
	
	public static final int
			JOY_DRIVE = 1,
			JOY_SHOOT = 2,
			
			MODULE_DRIVE = 1,
			
			DRIVE_LEFT = 1,
			DRIVE_RIGHT = 2,
			
			MODULE_MOTOR = 1,

			MOTOR_SHOOTER = 3,
			MOTOR_LEADSCREW = 4,
			MOTOR_LIFT1 = 5,
			MOTOR_LIFT2 = 6,
			MOTOR_LIFT3 = 7,
		
			POT_1 = 2,
			POT_1_AVGBITS = 5,
			POT_1_OVRBITS = 6,
			
			MODULE_SOLENOID_MAIN = 1,

			SOLENOID_SUCTION_VALVE = 1,	
			SOLENOID_SUCTION_ARM = 2,
			SOLENOID_SUCTION_ROTATE = 3,
			SOLENOID_FEEDER = 4,
			SOLENOID_LIFT_VALVE = 5,
			
			MODULE_RELAY = 1,
		
			RELAY_COMPRESSOR = 1,
			RELAY_LED = 3,

			MODULE_DIO = 1,
		 
			DIO_COMPRESSOR = 1,
			DIO_FRISBEECATCH = 5,
			DIO_LEADSCREWEND = 7,
			DIO_SHOOTERREADY = 8;
	
	public static final String
			DASH_INSTANCE_DRIVETRAIN = "Subsystem-Drivetrain",
			DASH_INSTANCE_SHOOTER = "Subsystem-Shooter",
			DASH_INSTANCE_SHOOTER_TRAY = "Subsystem-ShooterTray",
			DASH_INSTANCE_COMPRESSOR = "Subsystem-Compressor",
			DASH_INSTANCE_LIFT_HOOKS = "Subsystem-LiftHooks",
			DASH_INSTANCE_VISION_LIGHT = "Subsystem-VisionLight",
			DASH_INSTANCE_DASHBOARD = "Subsystem-Dashboard",
			
			DASH_MEMORY_STATUS = "System-Memory",
			
			DASH_SHOOTER_ANGLE = "ShooterAngle",
			DASH_SHOOTER_SCALE = "ShooterScale",
			DASH_SHOOTER_LIMIT = "ShooterLimit",
			DASH_SHOOTER_SPEED = "ShooterSpeed",
			DASH_SHOOTER_AUTO_ANGLE = "ShooterAutoAngle",
			DASH_COMPRESSOR_RUNNING = "CompressorState",

			NETTABLE_DEFAULT_TABLE = "NetworkTables",
			NETTABLE_DASH_LOG = "DashboardLod";
	
}
