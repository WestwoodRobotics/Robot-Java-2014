package org.warriors2583.frc2014;

import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.warriors2583.frc2014.ballcatcher.SS_BallCatcher;
import org.warriors2583.frc2014.drivetrain.SS_Drivetrain;
import org.warriors2583.lib.SS_Dashboard;
import org.warriors2583.lib.XBoxController;
import org.warriors2583.frc2014.common.SS_Compressor;
import org.warriors2583.frc2014.drivetrain.C_ChangeDrivemode;
import org.warriors2583.frc2014.launcher.CG_CockTheLauncher;
import org.warriors2583.frc2014.launcher.CG_FireBall;
//import org.warriors2583.frc2014.launcher.C_FlipperDown;
import org.warriors2583.frc2014.launcher.C_FlipperToggle;
//import org.warriors2583.frc2014.launcher.C_FlipperUp;
import org.warriors2583.frc2014.launcher.SS_Launcher;

/**
 * The Operator Interface Class. Controls Things that interface with the operator.
 * @author Austin Reuland
 */
public class OI implements RMap {
    
    //Controllers
    public static final XBoxController joy_drive, joy_shoot;
    
    //Button Controls
    //private static final JoystickButton catchUp, catchDown, spindleForward, spindleBackward;
    private static final JoystickButton arcadeButton, tankButton, mecanumButton, mecatankButton;
    private static final JoystickButton fireBall, cockLauncher, flipperToggle; //flipperUp, flipperDown;
    
    static{
        SmartDashboard.putData(DASH_INSTANCE_DRIVETRAIN, SS_Drivetrain.getInstance());
        SmartDashboard.putData(DASH_INSTANCE_LAUNCHER, SS_Launcher.getInstance());
        SmartDashboard.putData(DASH_INSTANCE_BALLCATCHER, SS_BallCatcher.getInstance());
        SmartDashboard.putData(DASH_INSTANCE_COMPRESSOR, SS_Compressor.getInstance());
        SmartDashboard.putData(DASH_INSTANCE_DASHBOARD, SS_Dashboard.getInstance());
        
        joy_drive = new XBoxController(JOY_DRIVE);
        joy_shoot = new XBoxController(JOY_SHOOT);
        
        arcadeButton = new JoystickButton(joy_drive, JOY_DRIVER_MODE_ARCADE);
        arcadeButton.whenPressed(new C_ChangeDrivemode(1));
        
        tankButton = new JoystickButton(joy_drive, JOY_DRIVER_MODE_TANK);
        tankButton.whenPressed(new C_ChangeDrivemode(2));
        
        mecanumButton = new JoystickButton(joy_drive, JOY_DRIVER_MODE_MECANUM);
        mecanumButton.whenPressed(new C_ChangeDrivemode(3));
        
        mecatankButton = new JoystickButton(joy_drive, JOY_DRIVER_MODE_MECATANK);
        mecatankButton.whenPressed(new C_ChangeDrivemode(4));
        
        fireBall = new JoystickButton(joy_shoot, JOY_SHOOT_LAUNCHER_FIRE);
        fireBall.whenPressed(new CG_FireBall());
        
        cockLauncher = new JoystickButton(joy_shoot, JOY_SHOOT_LAUNCHER_COCK);
        cockLauncher.whenPressed(new CG_CockTheLauncher());
        
        flipperToggle = new JoystickButton(joy_shoot, JOY_SHOOT_FLIPPER_TOGGLE);
        flipperToggle.whenPressed(new C_FlipperToggle());
        
        //flipperUp = new JoystickButton(joy_shoot, JOY_SHOOT_FLIPPER_UP);
        //flipperUp.whenPressed(new C_FlipperUp());
        
        //flipperDown = new JoystickButton(joy_shoot, JOY_SHOOT_FLIPPER_DOWN);
        //flipperDown.whenPressed(new C_FlipperDown());
        
        
        
        
//      catchUp = new JoystickButton(OI.joy_drive, XBoxController.BTN_X_ID);
//      catchUp.whenPressed(new C_CatcherUp());
//      
//      catchDown = new JoystickButton(OI.joy_drive, XBoxController.BTN_Y_ID);
//      catchDown.whenPressed(new C_CatcherDown());
//      
//      spindleForward = new JoystickButton(OI.joy_drive, XBoxController.BTN_RIGHT_SHOULDER_ID);
//      spindleForward.whileHeld(new C_SpindleForward());
//      
//      spindleBackward = new JoystickButton(OI.joy_drive, XBoxController.BTN_LEFT_SHOULDER_ID);
//      spindleBackward.whileHeld(new C_SpindleBackward());
        
    }

    public static double getJDriveLeftX(){ return joy_drive.getLeftX(); }
    public static double getJDriveLeftY(){ return joy_drive.getLeftY(); }
    public static double getJDriveRightX(){ return joy_drive.getRightX(); }
    public static double getJDriveRightY(){ return joy_drive.getRightY(); }
    public static double getJDriveThrottle(){ return joy_drive.getTriggers(); }
    
    public static boolean getJDriveButton(int button){ return joy_drive.getRawButton(button); }
    
    public static double getJShootLeftX(){ return joy_shoot.getX(); }
    public static double getJShootLeftY(){ return joy_shoot.getY(); }
    public static double getJShootRightX(){ return joy_shoot.getThrottle(); }
    public static double getJShootRightY(){ return joy_shoot.getRawAxis(5); }
    public static double getJShootThrottle(){ return joy_shoot.getZ(); }
    
    public static boolean getJShootButton(int button){ return joy_shoot.getRawButton(button); }
}

