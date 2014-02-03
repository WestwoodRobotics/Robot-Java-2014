package org.warriors2583.frc2014;

import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.warriors2583.frc2014.ballcatcher.*;
import org.warriors2583.frc2014.drivetrain.SS_Drivetrain;
import org.warriors2583.lib.SS_Dashboard;
import org.warriors2583.lib.XBoxController;
import org.warriors2583.frc2014.common.SS_Compressor;
import org.warriors2583.frc2014.launcher.CG_FireBall;
/**
 *
 * @author Austin Reuland
 */
public class OI {
	
	//Controllers
	public static final XBoxController joy_drive, joy_shoot;
	
	//Button Controls
	//private static final JoystickButton catchUp, catchDown, spindleForward, spindleBackward;
	private static final JoystickButton fireBall;
	
	static{
		SmartDashboard.putData(RMap.DASH_INSTANCE_DRIVETRAIN, SS_Drivetrain.getInstance());
		SmartDashboard.putData(RMap.DASH_INSTANCE_BALLCATCHER, SS_BallCatcher.getInstance());
		SmartDashboard.putData(RMap.DASH_INSTANCE_COMPRESSOR, SS_Compressor.getInstance());
		SmartDashboard.putData(RMap.DASH_INSTANCE_DASHBOARD, SS_Dashboard.getInstance());
		
		joy_drive = new XBoxController(RMap.JOY_DRIVE);
		joy_shoot = new XBoxController(RMap.JOY_SHOOT);
		
		fireBall = new JoystickButton(OI.joy_drive, XBoxController.BTN_B_ID);
		fireBall.whenPressed(new CG_FireBall());
				
//		catchUp = new JoystickButton(OI.joy_drive, XBoxController.BTN_X_ID);
//		catchUp.whenPressed(new C_CatcherUp());
//		
//		catchDown = new JoystickButton(OI.joy_drive, XBoxController.BTN_Y_ID);
//		catchDown.whenPressed(new C_CatcherDown());
//		
//		spindleForward = new JoystickButton(OI.joy_drive, XBoxController.BTN_RIGHT_SHOULDER_ID);
//		spindleForward.whileHeld(new C_SpindleForward());
//		
//		spindleBackward = new JoystickButton(OI.joy_drive, XBoxController.BTN_LEFT_SHOULDER_ID);
//		spindleBackward.whileHeld(new C_SpindleBackward());
		
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

