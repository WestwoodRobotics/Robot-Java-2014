package org.warriors2583.frc2014.drivetrain;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.warriors2583.frc2014.RMap;
import org.warriors2583.frc2014.teleop.C_TeleopDrive;

/**
 *
 * @author Austin Reuland
 */
public class SS_Drivetrain extends Subsystem {
	
	private static boolean externalLock;
	
	private static final Talon motor_left, motor_right;
	
	private static final RobotDrive driveMain;
	
	private static final SS_Drivetrain instance = new SS_Drivetrain();

	public static SS_Drivetrain getInstance() {
		return instance;
	}

	static {
		externalLock = false;
		
		motor_left = new Talon(RMap.MODULE_DRIVE, RMap.DRIVE_LEFT);
		motor_right = new Talon(RMap.MODULE_DRIVE, RMap.DRIVE_RIGHT);
	
		driveMain = new RobotDrive(motor_left, motor_right);
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
	
	public static void drive(double mag, double curve) {
		driveMain.drive(mag, curve);
	}
	
	public static void rotate(double rot) {
		driveMain.arcadeDrive(0.0, rot);
	}
	
	public static void teleDrive(double leftX, double leftY, double rightX, double rightY){
		
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