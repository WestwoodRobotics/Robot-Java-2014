package org.warriors2583.frc2014.ballcatcher;

import edu.wpi.first.wpilibj.command.Command;
import org.warriors2583.frc2014.OI;
import org.warriors2583.frc2014.RMap;
import org.warriors2583.lib.CommonFunctions.*;

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
        if(OI.joy_shoot.getRawButton(JOY_SHOOT_CATCHER_UP)){
            SS_BallCatcher.catcherDown();
        }else if(OI.joy_shoot.getRawButton(JOY_SHOOT_CATCHER_DOWN)){
            SS_BallCatcher.catcherUp();
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
