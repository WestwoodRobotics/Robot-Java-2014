package org.warriors2583.frc2014;

import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.warriors2583.frc2014.ballcatcher.C_CatcherClose;
import org.warriors2583.frc2014.ballcatcher.C_CatcherOpen;
import org.warriors2583.frc2014.ballcatcher.C_CatcherToggle;
import org.warriors2583.frc2014.ballcatcher.C_FlipperDown;
import org.warriors2583.frc2014.ballcatcher.C_FlipperToggle;
import org.warriors2583.frc2014.ballcatcher.C_FlipperUp;
import org.warriors2583.frc2014.ballcatcher.C_SpindleBackward;
import org.warriors2583.frc2014.ballcatcher.C_SpindleForward;
import org.warriors2583.frc2014.ballcatcher.SS_BallCatcher;
import org.warriors2583.frc2014.common.SS_Compressor;
import org.warriors2583.frc2014.drivetrain.C_ChangeDrivemode;
import org.warriors2583.frc2014.drivetrain.C_DriveForward;
import org.warriors2583.frc2014.drivetrain.C_DriveStop;
import org.warriors2583.frc2014.drivetrain.SS_Drivetrain;
import org.warriors2583.frc2014.launcher.CG_FireBall;
import org.warriors2583.frc2014.launcher.CG_PrepLauncher;
import org.warriors2583.frc2014.launcher.CG_PrepLauncherCatch;
import org.warriors2583.frc2014.launcher.CG_PrepLauncherPickup;
import org.warriors2583.frc2014.launcher.C_ExtendRam;
import org.warriors2583.frc2014.launcher.C_LatchLock;
import org.warriors2583.frc2014.launcher.C_LatchRelease;
import org.warriors2583.frc2014.launcher.C_RetractRam;
import org.warriors2583.frc2014.launcher.SS_Launcher;
import org.warriors2583.lib.SS_Dashboard;
import org.warriors2583.lib.XBoxController;

/**
 * The Operator Interface Class. Controls Things that interface with the operator.
 * @author Austin Reuland
 */
public class OI implements RMap {
    
    //Controllers
    public static final XBoxController joy_drive;
    public static final ArcadeController joy_shoot;
    
    //Button Controls
    private static final JoystickButton arcadeButton, tankButton, mecanumButton, mecatankButton;
    private static final JoystickButton moveToSetDistance1, moveToSetDistance2;
    private static final JoystickButton fireBall, prepLauncher, prepLauncherCatch, prepLauncherPickup;
    private static final JoystickButton latchRelease, latchLock, pistonExtend, pistonRetract;
    private static final JoystickButton flipperToggle, flipperUp, flipperDown;
    private static final JoystickButton catcherToggle, catcherUp, catcherDown;
    private static final JoystickButton spindleForward, spindleBackward;
    // add buttons for single stick marathon control
    private static final JoystickButton openCatcher, closeCatcher, startForward, stopRobot;
    
    static{
        SmartDashboard.putData(DASH_INSTANCE_DRIVETRAIN, SS_Drivetrain.getInstance());
        SmartDashboard.putData(DASH_INSTANCE_LAUNCHER, SS_Launcher.getInstance());
        SmartDashboard.putData(DASH_INSTANCE_BALLCATCHER, SS_BallCatcher.getInstance());
        SmartDashboard.putData(DASH_INSTANCE_COMPRESSOR, SS_Compressor.getInstance());
        SmartDashboard.putData(DASH_INSTANCE_SENSORS, SS_Sensors.getInstance());
        SmartDashboard.putData(DASH_INSTANCE_DASHBOARD, SS_Dashboard.getInstance());
        
        joy_drive = new XBoxController(JOY_DRIVE);
        joy_shoot = new ArcadeController(JOY_SHOOT);
        
        arcadeButton = new JoystickButton(joy_drive, JOY_DRIVER_MODE_ARCADE);
        arcadeButton.whenPressed(new C_ChangeDrivemode(1));
        
        tankButton = new JoystickButton(joy_drive, JOY_DRIVER_MODE_TANK);
        tankButton.whenPressed(new C_ChangeDrivemode(2));
        
        mecanumButton = new JoystickButton(joy_drive, JOY_DRIVER_MODE_MECANUM);
        mecanumButton.whenPressed(new C_ChangeDrivemode(3));
        
        mecatankButton = new JoystickButton(joy_drive, JOY_DRIVER_MODE_MECATANK);
        mecatankButton.whenPressed(new C_ChangeDrivemode(4));
        
        moveToSetDistance1 = new JoystickButton(joy_drive, JOY_DRIVER_SETDISTANCE_1);
        //moveToSetDistance1.whenPressed(new C_MoveToDistance(7.0*12));
        
        moveToSetDistance2 = new JoystickButton(joy_drive, JOY_DRIVER_SETDISTANCE_2);
        //moveToSetDistance2.whenPressed(new C_MoveToDistance(14.0*12));
      
        fireBall = new JoystickButton(joy_shoot, JOY_SHOOT_LAUNCHER_FIRE);
        fireBall.whenPressed(new CG_FireBall());
        
        prepLauncher = new JoystickButton(joy_shoot, JOY_SHOOT_LAUNCHER_PREP);
        prepLauncher.whenPressed(new CG_PrepLauncher());
        
        prepLauncherCatch = new JoystickButton(joy_shoot, JOY_SHOOT_LAUNCHER_PREP_CATCH);
        prepLauncherCatch.whenPressed(new CG_PrepLauncherCatch());
        
        prepLauncherPickup = new JoystickButton(joy_shoot, JOY_SHOOT_LAUNCHER_PREP_PICKUP);
        prepLauncherPickup.whenPressed(new CG_PrepLauncherPickup());
        
        latchRelease = new JoystickButton(joy_shoot, JOY_SHOOT_LAUNCHER_LATCH_RELEASE);
        latchRelease.whenPressed(new C_LatchRelease());
        
        latchLock = new JoystickButton(joy_shoot, JOY_SHOOT_LAUNCHER_LATCH_LOCK);
        latchLock.whenPressed(new C_LatchLock());
        
        pistonExtend = new JoystickButton(joy_shoot, JOY_SHOOT_LAUNCHER_PISTON_EXTEND);
        pistonExtend.whenPressed(new C_ExtendRam());
        
        pistonRetract = new JoystickButton(joy_shoot, JOY_SHOOT_LAUNCHER_PISTON_RETRACT);
        pistonRetract.whenPressed(new C_RetractRam());
        
        flipperToggle = new JoystickButton(joy_shoot, JOY_SHOOT_FLIPPER_TOGGLE);
        flipperToggle.whenPressed(new C_FlipperToggle());

        flipperUp = new JoystickButton(joy_shoot, JOY_SHOOT_FLIPPER_UP);
        flipperUp.whenPressed(new C_FlipperUp());
        
        flipperDown = new JoystickButton(joy_shoot, JOY_SHOOT_FLIPPER_DOWN);
        flipperDown.whenPressed(new C_FlipperDown());

        catcherToggle = new JoystickButton(joy_shoot, JOY_SHOOT_CATCHER_TOGGLE);
        catcherToggle.whenPressed(new C_CatcherToggle());
        
        catcherUp = new JoystickButton(joy_shoot, JOY_SHOOT_CATCHER_CLOSE);
        catcherUp.whenPressed(new C_CatcherClose());

        catcherDown = new JoystickButton(joy_shoot, JOY_SHOOT_CATCHER_OPEN);
        catcherDown.whenPressed(new C_CatcherOpen());

        spindleForward = new JoystickButton(joy_shoot, JOY_SHOOT_WHEELS_FORWARD);
        spindleForward.whileHeld(new C_SpindleForward());

        spindleBackward = new JoystickButton(joy_shoot, JOY_SHOOT_WHEELS_BACK);
        spindleBackward.whileHeld(new C_SpindleBackward());
        
        openCatcher = new JoystickButton(joy_drive, XBoxController.BTN_LEFT_SHOULDER_ID);
        openCatcher.whenPressed(new C_CatcherOpen());
        closeCatcher = new JoystickButton(joy_drive, XBoxController.BTN_RIGHT_SHOULDER_ID);
        closeCatcher.whenPressed(new C_CatcherClose());
        startForward = new JoystickButton(joy_drive, XBoxController.BTN_START_ID);
        startForward.whenPressed(new C_DriveForward(0.7));
        stopRobot = new JoystickButton(joy_drive, XBoxController.BTN_SELECT_ID);
        stopRobot.whenPressed(new C_DriveStop());
        
        
      
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

