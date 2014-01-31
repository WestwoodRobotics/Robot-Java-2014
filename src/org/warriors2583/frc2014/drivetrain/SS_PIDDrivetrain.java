package org.warriors2583.frc2014.drivetrain;

import com.sun.squawk.VM;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import org.warriors2583.frc2014.RMap;
import org.warriors2583.frc2014.teleop.C_TeleopDrive;

/**
 * Drivetrain Class. Controls the Drivetrain Sub-System
 * @author Austin Reuland
 */
public class SS_PIDDrivetrain extends PIDSubsystem {
	
	/**
	 * DriveMode Class
	 * Used to determine the type of driving we are doing
	 */
	public static class DriveMode{
		private final int mode;
		private final boolean mecanum;
		private final String name;
		private DriveMode(int mode, boolean mecanum, String name){
			this.mode = mode;
			this.mecanum = mecanum;
			this.name = name;
		}
		public int getMode(){return mode;}
		public void init(){
			int num = takeLock(true);
			solenoid_wheelSwitch.set(mecanum);
			releaseLock(num);
		}
		public String toString(){
			return name;
		}
		
		public static final DriveMode ARCADE = new DriveMode(1, false, "Arcade Drive");
		public static final DriveMode TANK = new DriveMode(2, false, "Tank Drive");
		public static final DriveMode MECANUM = new DriveMode(3, true, "Mecanum Drive");
	}
	
	private static boolean externalLock = false;
	private static int lockNum = 0;
	
	private static DriveMode driveMode = DriveMode.ARCADE;
		
	private static final Talon motor_front_left, motor_back_left, motor_front_right, motor_back_right;
	
	private static final Solenoid solenoid_wheelSwitch;
	
	private static final RobotDrive driveMain;
	
	private static final SS_PIDDrivetrain instance = new SS_PIDDrivetrain();

	public static SS_PIDDrivetrain getInstance() {
		return instance;
	}

	static {
		
		motor_front_left = new Talon(RMap.MODULE_DRIVE, RMap.DRIVE_FRONT_LEFT);
		motor_back_left = new Talon(RMap.MODULE_DRIVE, RMap.DRIVE_BACK_LEFT);
		motor_front_right = new Talon(RMap.MODULE_DRIVE, RMap.DRIVE_FRONT_RIGHT);
		motor_back_right = new Talon(RMap.MODULE_DRIVE, RMap.DRIVE_BACK_RIGHT);
		
		solenoid_wheelSwitch = new Solenoid(RMap.MODULE_SOLENOID_MAIN, RMap.SOLENOID_DRIVESWITCH);
		
		driveMain = new RobotDrive(motor_front_left, motor_back_left, motor_front_right, motor_back_right);
	}
	
	
	private SS_PIDDrivetrain(){
		super("SS_Drivetrain", 1.0, 0.0, 0.0);
		setAbsoluteTolerance(0.2);
		
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
	
	public static void modeDrive(double leftX, double leftY, double rot, double rightY){
		if(externalLock){
			return;
		}
		switch(driveMode.getMode()){
			case 1: 
				arcade(leftY, rot);
				break;
				
			case 2:
				tank(leftY, rightY);
				break;
				
			case 3:
				mecanum(leftX, leftY, rot, rightY);
				break;
		}
		
		
		
	}
	
	protected double returnPIDInput() {
		return 0.0;
	}

	protected void usePIDOutput(double output) {
		modeDrive(0.0, 0.0, output, 0.0);
	}
	
	public static void setDriveMode(DriveMode mode){
		driveMode = mode;
		driveMode.init();
	}
	
	public static DriveMode getDriveMode(){
		return driveMode;
	}
	
	public static int takeLock(boolean force){
		if(!externalLock || force){
			lockNum = (int)VM.getTimeMillis();
			externalLock = true;
			return lockNum;
		}else{
			return -1;
		}
		
	}
	
	public static boolean releaseLock(int num){
		if(externalLock){
			if(num == lockNum){
				externalLock = false;
				lockNum = 0;
				return true;
			}else{
				return false;
			}
		}else{
			return false;
		}
	}
	
	public static void setExternalLock(boolean value) {
		externalLock = value;
	}
	
	public static boolean getExternLock() {
		return externalLock;
	}
	
	public static void makeSafe(){
		externalLock = true;
		driveMain.stopMotor();
		motor_front_left.disable();
		motor_front_left.free();
		
		motor_back_left.disable();
		motor_back_left.free();
		
		motor_front_right.disable();
		motor_front_right.free();
		
		motor_back_right.disable();
		motor_back_right.free();		
		
	}


	protected void initDefaultCommand() {
		setDefaultCommand(new C_TeleopDrive());
	}

}