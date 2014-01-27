package org.warriors2583.frc2014;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.warriors2583.frc2014.drivetrain.SS_Drivetrain;
import org.warriors2583.frc2014.lib.SS_Dashboard;
import org.warriors2583.frc2014.lib.XBoxController;
import org.warriors2583.frc2014.pneumatics.SS_Compressor;
/**
 *
 * @author Austin Reuland
 */
public class OI {
	
	public static final XBoxController joy_drive, joy_shoot;
	public static final NetworkTable rasPiTable, compTable;
	
	static{
		SmartDashboard.putData(RMap.DASH_INSTANCE_DRIVETRAIN, SS_Drivetrain.getInstance());
		SmartDashboard.putData(RMap.DASH_INSTANCE_COMPRESSOR, SS_Compressor.getInstance());
		SmartDashboard.putData(RMap.DASH_INSTANCE_DASHBOARD, SS_Dashboard.getInstance());
		
		joy_drive = new XBoxController(RMap.JOY_DRIVE);
		joy_shoot = new XBoxController(RMap.JOY_SHOOT);
		rasPiTable = NetworkTable.getTable(RMap.NETTABLE_RASPI);
		compTable = NetworkTable.getTable(RMap.NETTABLE_COMPUTER);
		
	}

	public static double getJDriveLeftX(){ return -joy_drive.getLeftX(); }
	public static double getJDriveLeftY(){ return -joy_drive.getLeftY(); }
	public static double getJDriveRightX(){ return -joy_drive.getRightX(); }
	public static double getJDriveRightY(){ return -joy_drive.getRightY(); }
	public static double getJDriveThrottle(){ return joy_drive.getTriggers(); }
	
	public static boolean getJDriveButton(int button){ return joy_drive.getRawButton(button); }
	
	public static double getJShootLeftX(){ return -joy_shoot.getX(); }
	public static double getJShootLeftY(){ return -joy_shoot.getY(); }
	public static double getJShootRightX(){ return -joy_shoot.getThrottle(); }
	public static double getJShootRightY(){ return -joy_shoot.getRawAxis(5); }
	public static double getJShootThrottle(){ return joy_shoot.getZ(); }
	
	public static boolean getJShootButton(int button){ return joy_shoot.getRawButton(button); }
}

