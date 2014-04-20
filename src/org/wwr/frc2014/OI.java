package org.wwr.frc2014;

import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.wwr.robolib.control.XBoxController;
import org.wwr.frc2014.drivetrain.SS_Drivetrain;
import org.wwr.frc2014.drivetrain.C_ChangeDrivemode;
import org.wwr.frc2014.ballcatcher.*;
//import org.wwr.frc2014.drivetrain.C_MoveToDistance;
import org.wwr.frc2014.launcher.*;
//import org.wwr.robolib.control.NetTableController;

/**
 * The Operator Interface Class. Controls Things that interface with the operator.
 * @author Austin Reuland
 */
public class OI implements RMap {
    
    //Controllers
    public static final XBoxController joy_drive;
    public static final ArcadeController joy_shoot;
    //public static final NetTableController joy_test;
    
    //Button Controls
    private static final JoystickButton arcadeButton, tankButton, mecanumButton, mecatankButton;
    private static final JoystickButton moveToSetDistance1, moveToSetDistance2;
    private static final JoystickButton fireBall, prepLauncher, prepLauncherPickup, ejectBall;
    private static final JoystickButton latchRelease, latchLock, pistonExtend, pistonRetract;
    private static final JoystickButton flipperToggle, flipperUp, flipperDown;
    private static final JoystickButton catcherToggle, catcherUp, catcherDown;
    private static final JoystickButton spindleForward, spindleBackward;
    
    static{
        SmartDashboard.putData(DASH_INSTANCE_DRIVETRAIN, SS_Drivetrain.getInstance());
        SmartDashboard.putData(DASH_INSTANCE_LAUNCHER, SS_Launcher.getInstance());
        SmartDashboard.putData(DASH_INSTANCE_BALLCATCHER, SS_BallCatcher.getInstance());
        
        joy_drive = new XBoxController(JOY_DRIVE);
        joy_shoot = new ArcadeController(JOY_SHOOT);
        //joy_test = new NetTableController("Test", 16, 32);
        
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
                
        ejectBall = new JoystickButton(joy_shoot, JOY_SHOOT_EJECT_BALL);
        ejectBall.whenPressed(new CG_EjectBall());
        
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

