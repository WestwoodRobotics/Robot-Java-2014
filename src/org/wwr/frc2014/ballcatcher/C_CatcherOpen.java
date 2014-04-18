package org.wwr.frc2014.ballcatcher;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Lower the Ball Catcher
 * @author Austin Reuland
 */
public class C_CatcherOpen extends Command {

    public C_CatcherOpen() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        super("C_CatcherOpen");
        setInterruptible(false);
        requires(SS_BallCatcher.getInstance());
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        SS_BallCatcher.catcherOpen();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return SS_BallCatcher.isCatcherOpen();
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
