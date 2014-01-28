package org.warriors2583.frc2014.drivetrain;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.warriors2583.frc2014.RMap;
import org.warriors2583.frc2014.teleop.C_TeleopDrive;

/**
 * Drivetrain Class. Controls the Drivetrain Sub-System
 * @author Austin Reuland
 */
public class SS_Drivetrain extends Subsystem {
	
	/**
	 * DriveMode Class
	 * Used to determine the type of driving we are doing
	 */
	public static class DriveMode{
		private final int mode;
		private DriveMode(int mode){this.mode = mode;}
		public int getMode(){return mode;}
		
		public static final DriveMode ARCADE = new DriveMode(1);
		public static final DriveMode TANK = new DriveMode(2);
		public static final DriveMode MECANUM = new DriveMode(3);
	}
	
	private static boolean externalLock;
	
	private static DriveMode driveMode = DriveMode.ARCADE;
		
	private static final Talon motor_front_left, motor_back_left, motor_front_right, motor_back_right;
	
	private static final RobotDrive driveMain;
	
	private static final SS_Drivetrain instance = new SS_Drivetrain();

	public static SS_Drivetrain getInstance() {
		return instance;
	}

	static {
		externalLock = false;
		
		motor_front_left = new Talon(RMap.MODULE_DRIVE, RMap.DRIVE_FRONT_LEFT);
		motor_back_left = new Talon(RMap.MODULE_DRIVE, RMap.DRIVE_BACK_LEFT);
		motor_front_right = new Talon(RMap.MODULE_DRIVE, RMap.DRIVE_FRONT_RIGHT);
		motor_back_right = new Talon(RMap.MODULE_DRIVE, RMap.DRIVE_BACK_RIGHT);
		
	
		driveMain = new RobotDrive(motor_front_left, motor_back_left, motor_front_right, motor_back_right);
	}
	
	
	private SS_Drivetrain(){
		super("SS_Drivetrain");
	}
	
	
	public static void tank(double l, double r) {
		driveMain.tankDrive(l, r);
	}
	
	public static void arcade(double throt, double rot) {
		driveMain.arcadeDrive(throt, rot);
	}
	
	public static void mecanum(double x, double y, double rot, double gyro) {
		driveMain.mecanumDrive_Cartesian(x, y, rot, gyro);
	}
	
	public static void drive(double mag, double curve) {
		driveMain.drive(mag, curve);
	}
	
	public static void rotate(double rot) {
		driveMain.arcadeDrive(0.0, rot);
	}
	
	public static void teleDrive(double leftX, double leftY, double rightX, double rightY){
		if(externalLock){
			return;
		}
		switch(driveMode.getMode()){
			case 1: 
				arcade(leftY, rightX);
				break;
				
			case 2:
				tank(leftY, rightY);
				break;
				
			case 3:
				mecanum(leftX, leftY, rightX, 0.0);
				break;
		}
		
		
		
	}
	
	public static void setDriveMode(DriveMode mode){
		driveMode = mode;
	}
	
	public static DriveMode getDriveMode(){
		return driveMode;
	}
	
	public static void setExternalLock(boolean value) {
		externalLock = value;
	}
	
	public static boolean getExternLock() {
		return externalLock;
	}


	protected void initDefaultCommand() {
		setDefaultCommand(new C_TeleopDrive());
	}

}