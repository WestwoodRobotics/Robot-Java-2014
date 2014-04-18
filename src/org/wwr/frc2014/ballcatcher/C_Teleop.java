package org.wwr.frc2014.ballcatcher;

import edu.wpi.first.wpilibj.command.Command;
import org.wwr.frc2014.OI;
import org.wwr.frc2014.RMap;

/**
 * Tele-Operation Class.
 * @author Austin Reuland
 */
public class C_Teleop extends Command implements RMap {

    public C_Teleop() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        super("C_TeleopCatcher");
        requires(SS_BallCatcher.getInstance());
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    
    private int bTI(boolean bool){return bool ? 1 : 0;}
    
    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        SS_BallCatcher.spindleSet(
                (bTI(OI.joy_shoot.getRawButton(JOY_SHOOT_WHEELS_FORWARD)) - 
                        bTI(OI.joy_shoot.getRawButton(JOY_SHOOT_WHEELS_BACK))));
        if(OI.joy_shoot.getRawButton(JOY_SHOOT_CATCHER_OPEN)){
            SS_BallCatcher.catcherOpen();
        }else if(OI.joy_shoot.getRawButton(JOY_SHOOT_CATCHER_CLOSE)){
            SS_BallCatcher.catcherClose();
        }
        if(OI.joy_shoot.getRawButton(JOY_SHOOT_FLIPPER_TOGGLE)){
            if(SS_BallCatcher.isFlipperDown()){
                SS_BallCatcher.flipperUp();
            }else{
                SS_BallCatcher.flipperDown();
            }
        }
        if(OI.joy_shoot.getRawButton(JOY_SHOOT_CATCHER_CLOSE)){
            if(SS_BallCatcher.isCatcherOpen()){
                SS_BallCatcher.catcherClose();
            }else{
                SS_BallCatcher.catcherOpen();
            }
        }
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
