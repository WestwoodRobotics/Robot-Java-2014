package org.warriors2583.frc2014.teleop;

import edu.wpi.first.wpilibj.command.Command;
import org.warriors2583.frc2014.OI;
import org.warriors2583.frc2014.ballcatcher.SS_BallCatcher;
import org.warriors2583.lib.CommonFunctions.*;

/**
 *
 * @author Austin Reuland
 */
public class C_TeleopCatcher extends Command {

    public C_TeleopCatcher() {
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
                (bTI(OI.joy_drive.btnRightShoulder()) - 
                        bTI(OI.joy_drive.btnLeftShoulder())) * 0.65);
        if(OI.joy_drive.btnX()){
            SS_BallCatcher.catcherDown();
        }else if(OI.joy_drive.btnY()){
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
