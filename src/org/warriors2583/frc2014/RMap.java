package org.warriors2583.frc2014;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 * 
 * @author Austin Reuland
 */
public interface RMap {
    
    /**
     * Driver Joystick ID Number
     */
    public static final int JOY_DRIVE = 1;

    /**
     * Driver Joystick Speed Scaling Button
     */
    public static final int JOY_DRIVE_BTN_SCALE = 5;

    /**
     * Shooter Joystick ID Number
     */
    public static final int JOY_SHOOT = 2;

    /**
     * Drive Motor Module Number
     */
    public static final int MODULE_DRIVE = 1;

    /**
     * Front Left Drive Motor PWM Number
     */
    public static final int DRIVE_FRONT_LEFT = 1;
    
    /**
     * Back Left Drive Motor PWM Number
     */
    public static final int DRIVE_BACK_LEFT = 2;
    
    /**
     * Front Right Drive Motor PWM Number
     */
    public static final int DRIVE_FRONT_RIGHT = 3;
    
    /**
     * Back Right Drive Motor PWM Number
     */
    public static final int DRIVE_BACK_RIGHT = 4;
    
    /**
     * Motor Module Number
     */
    public static final int MODULE_MOTOR = 1;
    
    /**
     * Ball Catcher Motor PWM Number
     */
    public static final int MOTOR_CATCHER = 5;
    
    /**
     * Main Solenoid Module Number
     */
    public static final int MODULE_SOLENOID_MAIN = 1;
    
    /**
     * Drivetrain Wheel Swtiching Solenoid
     */
    public static final int SOLENOID_DRIVESWITCH = 1;
    
    /**
     * Ball Catcher Solenoid Number
     */
    public static final int SOLENOID_CATCHER = 2;
    
    /**
     * Launcher Loading Solenoid Number
     */
    public static final int SOLENOID_LAUNCHER_LOAD = 3;
    
    /**
     * Launcher Release Solenoid Number
     */
    public static final int SOLENOID_LAUNCHER_RELEASE = 4;
    
    /**
     * Relay Module Number
     */
    public static final int MODULE_RELAY = 1;
    
    /**
     * Compressor Relay Number
     */
    public static final int RELAY_COMPRESSOR = 1;

    /**
     * LED Relay Number
     */
    public static final int RELAY_LED = 3;
    
    /**
     * Digital I/O Module Number
     */
    public static final int MODULE_DIO = 1;
    
    /**
     * Compressor Safety Switch DIO Number
     */
    public static final int DIO_COMPRESSOR = 1;
    
    /**
     * Launcher Locked Status Switch DIO Number
     */
    public static final int DIO_LAUNCHER_LOCKED = 2;
    
    /**
     * Launcher Ball Loaded Status Switch DIO Number
     */
    public static final int DIO_LAUNCHER_BALL = 3;
    
    /**
     * Launcher Ram Back Position Sensor DIO Number
     */
    public static final int DIO_LAUNCHER_RAM_A = 4;
    
    /**
     * Launcher Ram Forward Position Sensor DIO Number
     */
    public static final int DIO_LAUNCHER_RAM_B = 5;
    
    /* Dashboard and NetworkTable Values */
    /* --------------------------------- */
    
    /**
     * Drivetrain Dashboard label
     */
    public static final String DASH_INSTANCE_DRIVETRAIN = "Subsystem-Drivetrain";
    
    /**
     * Ball Catcher Dashboard label
     */
    public static final String DASH_INSTANCE_BALLCATCHER = "Subsystem-BallCatcher";
    
    /**
     * Launcher Dashboard Label
     */
    public static final String DASH_INSTANCE_LAUNCHER = "Subsystem-Launcher";
    
    /**
     * Compressor Dashboard label
     */
    public static final String DASH_INSTANCE_COMPRESSOR = "Subsystem-Compressor";
    
    /**
     * System Stats Dashboard label
     */
    public static final String DASH_INSTANCE_DASHBOARD = "Subsystem-Dashboard";

    /**
     * System Memory Dashboard label
     */
    public static final String DASH_MEMORY_STATUS = "System-Memory";

    /**
     * Compressor Status Dashboard label
     */
    public static final String DASH_COMPRESSOR_RUNNING = "CompressorState";

    /**
     * Default NetworkTables Table
     */
    public static final String NETTABLE_DEFAULT_TABLE = "NetworkTables";

    /**
     * Dashboard Logging Table
     */
    public static final String NETTABLE_DASH_LOG = "DashboardLog";
       
    /**
     * Raspberry Pi Subtable name
     */
    public static final String NETTABLE_RASPI = "RasPi";
    
    /**
     * Raspberry Pi Compass Subtable name
     */
    public static final String NETTABLE_RASPI_COMP = "Compass";
    
    /**
     * Raspberry Pi Compass Raw X value key
     */
    public static final String NETTABLE_RASPI_COMP_X_RAW = "x_raw";
    
    /**
     * Raspberry Pi Compass Raw Y value key
     */
    public static final String NETTABLE_RASPI_COMP_Y_RAW = "y_raw";
    
    /**
     * Raspberry Pi Compass Raw Z value key
     */
    public static final String NETTABLE_RASPI_COMP_Z_RAW = "z_raw";
    
    /**
     * Raspberry Pi Compass Raw Heading value key
     */
    public static final String NETTABLE_RASPI_COMP_HEADING_RAW = "head_raw";
    
    /**
     * Raspberry Pi Compass Scaled X value key
     */
    public static final String NETTABLE_RASPI_COMP_X_SCALED = "x_scale";
    
    /**
     * Raspberry Pi Compass Scaled Y value key 
     */
    public static final String NETTABLE_RASPI_COMP_Y_SCALED = "y_scale";
    
    /**
     * Raspberry Pi Compass Scaled Z value key
     */
    public static final String NETTABLE_RASPI_COMP_Z_SCALED = "z_scale";
    
    /**
     * Raspberry Pi Compass Scaled Heading value key
     */
    public static final String NETTABLE_RASPI_COMP_HEADING_SCALED = "head_scale";
    
    /**
     * Raspberry Pi Accelerometer Subtable name
     */
    public static final String NETTABLE_RASPI_ACCEL = "Accel";
    
    /**
     * Raspberry Pi Gyro Subtable name
     */
    public static final String NETTABLE_RASPI_GYRO = "Gyro";
    
    /**
     * Raspberry Pi Status Subtable name
     */
    public static final String NETTABLE_RASPI_STATUS = "Status";
    
    /**
     * Raspberry Pi Status Enabled value key
     */
    public static final String NETTABLE_RASPI_STATUS_ENABLED = "enabled";
    
    /**
     * Raspberry Pi Status Ready value key
     */
    public static final String NETTABLE_RASPI_STATUS_READY = "pi_ready";
    
    /**
     * Raspberry Pi Status Error Number value key
     */
    public static final String NETTABLE_RASPI_STATUS_ERRORNO = "errorno";
    
    /**
     * Computer Subtable name
     */
    public static final String NETTABLE_COMPUTER = "Base";

    /**
     * Computer Settings Subtable name
     */
    public static final String NETTABLE_COMPUTER_SETTINGS = "Settings";

    /**
     * Computer Settings Drivemode value key
     */
    public static final String NETTABLE_COMPUTER_SETTINGS_DRIVEMODE = "drivemode";

    /**
     * Computer Status Subtable name
     */
    public static final String NETTABLE_COMPUTER_STATUS = "Status";

}
