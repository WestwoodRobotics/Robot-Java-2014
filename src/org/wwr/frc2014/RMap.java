package org.wwr.frc2014;

import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.tables.ITable;
import org.wwr.robolib.control.XBoxController;

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
    public static final int JOY_DRIVE_BTN_SCALE = XBoxController.BTN_RIGHT_SHOULDER;

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
     * Would be 4, but wires are too short
     */
    public static final int DRIVE_BACK_RIGHT = 8;
    
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
    public static final int SOLENOID_CATCHER = 5;
    
    /**
     * Launcher Loading Solenoid Number
     */
    public static final int SOLENOID_LAUNCHER_LOAD = 2;
    
    /**
     * Launcher Release Solenoid Number
     */
    public static final int SOLENOID_LAUNCHER_RELEASE = 3;
    
    /**
     * Launcher Flow Solenoid Number
     */
    public static final int SOLENOID_LAUNCHER_FLOW = 6;
    
    /**
     * Launcher Flapper Solenoid Number
     */
    public static final int SOLENOID_LAUNCHER_FLAPPER = 4;
    
    /**
     * Launcher Lock Solenoid Number
     */
    public static final int SOLENOID_LAUNCHER_LOCK = 7;
    
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
    public static final int RELAY_LED = 2;
    
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
    public static final int DIO_LAUNCHER_PREPRED = 2;
    
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

    /**
     * Digital I/O Sensor Ultrasonic Trigger
     */
    public static final int DIO_SENSOR_ULTRASONIC_TRIGGER = 8;
    
    /**
     * Digital I/O Sensor Ultrasonic Pulse
     */
    public static final int DIO_SENSOR_ULTRASONIC_ECHO = 9;
    
    /**
     * Driver Joystick Arcade Mode Button
     */
    public static final int JOY_DRIVER_MODE_ARCADE = XBoxController.BTN_A;
    
    /**
     * Driver Joystick Mecanum Mode Button
     */
    public static final int JOY_DRIVER_MODE_MECANUM = XBoxController.BTN_B;
    
    /**
     * Driver Joystick Tank Mode Button
     */
    public static final int JOY_DRIVER_MODE_TANK = XBoxController.BTN_LEFT_STICK;
    
    /**
     * Driver Joystick MecaTank Mode Button
     */
    public static final int JOY_DRIVER_MODE_MECATANK = XBoxController.BTN_RIGHT_STICK;
    
    /**
     * Driver Joystick Move to Point 1
     */
    public static final int JOY_DRIVER_SETDISTANCE_1 = XBoxController.BTN_X;
    
    /**
     * Driver Joystick Move to Point 2
     */
    public static final int JOY_DRIVER_SETDISTANCE_2 = XBoxController.BTN_Y;
    
    /**
     * Shooter Joystick Catcher Up Button
     */
    public static final int JOY_SHOOT_CATCHER_CLOSE = ArcadeController.BUTTON_CATCHER_CLOSE;
    
    /**
     * Shooter Joystick Catcher Down Button
     */
    public static final int JOY_SHOOT_CATCHER_OPEN = ArcadeController.BUTTON_CATCHER_OPEN;
    
    /**
     * Shooter Joystick Catcher Toggle Button
     */
    public static final int JOY_SHOOT_CATCHER_TOGGLE = ArcadeController.BUTTON_CATCHER_TOGGLE;
    
    /**
     * Shooter Joystick Wheels Forward Button
     */
    public static final int JOY_SHOOT_WHEELS_FORWARD = ArcadeController.BUTTON_ROLLERS_FORWARD;
    
    /**
     * Shooter Joystick Wheels Backward Button
     */
    public static final int JOY_SHOOT_WHEELS_BACK = ArcadeController.BUTTON_ROLLERS_BACK;
    
    /**
     * Shooter Joystick Eject Ball Button
     */
    public static final int JOY_SHOOT_EJECT_BALL = ArcadeController.BUTTON_EJECT_BALL;
    
    /**
     * Shooter Joystick Fire Launcher Button
     */
    public static final int JOY_SHOOT_LAUNCHER_FIRE = ArcadeController.BUTTON_FIRE;
    
    /**
     * Shooter Joystick Prep Launcher Button
     */
    public static final int JOY_SHOOT_LAUNCHER_PREP = ArcadeController.BUTTON_REPREP;
    
    /**
     * Shooter Joystick Prep Launcher Catch Button
     */
    //public static final int JOY_SHOOT_LAUNCHER_PREP_CATCH = ArcadeController.BUTTON_PREP_CATCH;
    
    /**
     * Shooter Joystick Prep Launcher Pickup Button
     */
    public static final int JOY_SHOOT_LAUNCHER_PREP_PICKUP = ArcadeController.BUTTON_PREP_PICKUP;
    
    /**
     * Shooter Joystick Launcher Latch Release Button
     */
    public static final int JOY_SHOOT_LAUNCHER_LATCH_RELEASE = ArcadeController.BUTTON_RELEASE_UNLATCH;
    
    /**
     * Shooter Joystick Launcher Latch Lock Button
     */
    public static final int JOY_SHOOT_LAUNCHER_LATCH_LOCK = ArcadeController.BUTTON_RELEASE_LATCH;
    
    /**
     * Shooter Joystick Launcher Piston Extend Button
     */
    public static final int JOY_SHOOT_LAUNCHER_PISTON_EXTEND = ArcadeController.BUTTON_LAUNCHER_EXTEND;
    
    /**
     * Shooter Joystick Launcher Piston Retract Button
     */
    public static final int JOY_SHOOT_LAUNCHER_PISTON_RETRACT = ArcadeController.BUTTON_LAUNCHER_RETRACT;
    
    /**
     * Shooter Joystick Flipper Up Button (Not Used)
     */
    public static final int JOY_SHOOT_FLIPPER_UP = ArcadeController.BUTTON_FLIPPER_UP;
    
    /**
     * Shooter Joystick Flipper Down Button (Not Used)
     */
    public static final int JOY_SHOOT_FLIPPER_DOWN = ArcadeController.BUTTON_FLIPPER_DOWN;
    
    /**
     * Shooter Joystick Flipper Toggle Button
     */
    public static final int JOY_SHOOT_FLIPPER_TOGGLE = ArcadeController.BUTTON_FLIPPER_TOGGLE;
    
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
     * Sensors Dashboard label
     */
    public static final String DASH_INSTANCE_SENSORS = "Subsystem-Sensors";
    
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
     * Robot NetworkTables Table
     */
    public static final String NETTABLE_ROBOT_TABLE = "Robot";
    
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
    public static final String NETTABLE_RASPI = "pi";
    
    /**
     * Raspberry Pi Compass Subtable name
     */
    public static final String NETTABLE_RASPI_COMP = "compass";
    
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
    public static final String NETTABLE_RASPI_ACCEL = "accel";
    
    /**
     * Raspberry Pi Gyro Subtable name
     */
    public static final String NETTABLE_RASPI_GYRO = "gyro";
    
    /**
     * Raspberry Pi Status Subtable name
     */
    public static final String NETTABLE_RASPI_STATUS = "status";
    
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
     * Drivetrain Subtable name
     */
    public static final String NETTABLE_DRIVETRAIN = "Drivetrain";
    
    /**
     * Drivetrain Drivemode value key
     */
    public static final String NETTABLE_DRIVETRAIN_DRIVEMODE = "drivemode";
    
    /**
     * Drivetrain Drivemode String value key
     */
    public static final String NETTABLE_DRIVETRAIN_DRIVEMODE_STRING = "drivemode_string";

    /**
     * Drivetrain Solenoid value key
     */
    public static final String NETTABLE_DRIVETRAIN_SOLENOID = "solenoid";
    
    /**
     * Drivetrain Default Command Name value key
     */
    public static final String NETTABLE_DRIVETRAIN_DEFAULT_COMMAND = "default_cmd";
    
    public static final String NETTABLE_DRIVETRAIN_SCALE = "driveScale";
    
    /**
     * Launcher Subtable name
     */
    public static final String NETTABLE_LAUNCHER = "Launcher";
    
    /**
     * Launcher isCcoked value key
     */
    public static final String NETTABLE_LAUNCHER_READY = "ispreped";
    
    /**
     * Ball Catcher Subtable name
     */
    
    public static final String NETTABLE_CATCHER = "Catcher";
    
    /**
     * Ball Catcher Catcher State key name
     */
    public static final String NETTABLE_CATCHER_CATCHER_STATE = "catcherState";
    
    /**
     * Ball Catcher Flipper State key name
     */
    public static final String NETTABLE_CATCHER_FLIPPER_STATE = "flipperState";
    
    /**
     * Ball Catcher Spindle Speed key name
     */
    public static final String NETTABLE_CATCHER_SPINDLE_SCALE = "spindle_scaler";
    
    /**
     * Sensors Subtable name
     */
    public static final String NETTABLE_SENSORS = "Sensors";
    
    /**
     * Sensors Ultrasonic key name
     */
    public static final String NETTABLE_SENSORS_ULTRASONIC = "distance";
    
    /**
     * Sensors Battery Value
     */
    public static final String NETTABLE_SENSORS_BATTERY = "battery";

    /**
     * Computer Status Subtable name
     */
    public static final String NETTABLE_COMPUTER_STATUS = "Status";
    
    public static ITable roboTable = NetworkTable.getTable(NETTABLE_ROBOT_TABLE);
}

