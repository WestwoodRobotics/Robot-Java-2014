package org.warriors2583.frc2014;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 * 
 * @author Austin Reuland
 */
public class RMap {
	
	public static final int
			JOY_DRIVE = 1,
			JOY_SHOOT = 2,
			
			MODULE_DRIVE = 1,
			
			DRIVE_FRONT_LEFT = 1,
			
			DRIVE_BACK_LEFT = 2,
			DRIVE_FRONT_RIGHT = 3,
			DRIVE_BACK_RIGHT = 4,
			
			MODULE_MOTOR = 1,
			
			MOTOR_CATCHER = 5,

			POT_1 = 2,
			POT_1_AVGBITS = 5,
			POT_1_OVRBITS = 6,
			
			MODULE_SOLENOID_MAIN = 1,
			
			SOLENOID_CATCHER = 1,
			
			MODULE_RELAY = 1,
		
			RELAY_COMPRESSOR = 1,
			RELAY_LED = 3,

			MODULE_DIO = 1,
		 
			DIO_COMPRESSOR = 1;
	
	public static final String
			/**
			 * The Drivetrain Dashboard Name
			 */
			DASH_INSTANCE_DRIVETRAIN = "Subsystem-Drivetrain",
			DASH_INSTANCE_COMPRESSOR = "Subsystem-Compressor",
			DASH_INSTANCE_DASHBOARD = "Subsystem-Dashboard",
			
			DASH_MEMORY_STATUS = "System-Memory",

			DASH_COMPRESSOR_RUNNING = "CompressorState",

			NETTABLE_DEFAULT_TABLE = "NetworkTables",
			NETTABLE_DASH_LOG = "DashboardLog",
			
			NETTABLE_RASPI = "RasPi",
			NETTABLE_RASPI_COMP = "Compass",
			NETTABLE_RASPI_COMP_X_RAW = "x_raw", NETTABLE_RASPI_COMP_Y_RAW = "y_raw",
			NETTABLE_RASPI_COMP_Z_RAW = "z_raw", NETTABLE_RASPI_COMP_HEADING_RAW = "head_raw",
			NETTABLE_RASPI_COMP_X_SCALED = "x_scale", NETTABLE_RASPI_COMP_Y_SCALED = "y_scale",
			NETTABLE_RASPI_COMP_Z_SCALED = "z_scale", NETTABLE_RASPI_COMP_HEADING_SCALED = "head_scale",
			NETTABLE_RASPI_ACCEL = "Accel",
			NETTABLE_RASPI_GYRO = "Gyro",
			NETTABLE_RASPI_STATUS = "Status",
			NETTABLE_RASPI_STATUS_ENABLED = "enabled", NETTABLE_RASPI_STATUS_READY = "pi_ready",
			NETTABLE_COMPUTER = "Base";
	
}
