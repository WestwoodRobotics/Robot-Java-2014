package org.warriors2583.frc2014;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.warriors2583.frc2014.drivetrain.SS_Drivetrain;
import org.warriors2583.frc2014.lib.SS_Dashboard;
import org.warriors2583.frc2014.pneumatics.SS_Compressor;
/**
 *
 * @author Austin Reuland
 */
public class OI {
	
	public static final Joystick joy_drive, joy_shoot;
	
	static{
		SmartDashboard.putData(RMap.DASH_INSTANCE_DRIVETRAIN, SS_Drivetrain.getInstance());
		SmartDashboard.putData(RMap.DASH_INSTANCE_COMPRESSOR, SS_Compressor.getInstance());
		SmartDashboard.putData(RMap.DASH_INSTANCE_DASHBOARD, SS_Dashboard.getInstance());
		
		joy_drive = new Joystick(RMap.JOY_DRIVE);
		joy_shoot = new Joystick(RMap.JOY_SHOOT);
		
	}

	public static double getJDriveLeftX(){ return -joy_drive.getX(); }
	public static double getJDriveLeftY(){ return -joy_drive.getY(); }
	public static double getJDriveRightX(){ return -joy_drive.getThrottle(); }
	public static double getJDriveRightY(){ return -joy_drive.getRawAxis(5); }
	public static double getJDriveThrottle(){ return joy_drive.getZ(); }
	
	public static boolean getJDriveButton(int button){ return joy_drive.getRawButton(button); }
	
	public static double getJShootLeftX(){ return -joy_shoot.getX(); }
	public static double getJShootLeftY(){ return -joy_shoot.getY(); }
	public static double getJShootRightX(){ return -joy_shoot.getThrottle(); }
	public static double getJShootRightY(){ return -joy_shoot.getRawAxis(5); }
	public static double getJShootThrottle(){ return joy_shoot.getZ(); }
	
	public static boolean getJShootButton(int button){ return joy_shoot.getRawButton(button); }
	
	public static double getShooterSpeedScale(){
		return SmartDashboard.getNumber(RMap.DASH_SHOOTER_SCALE, 0.75);
	}
	
	public static double getShooterAutoAngle(){
		return SmartDashboard.getNumber(RMap.DASH_SHOOTER_AUTO_ANGLE);
	}
}

