package org.wwr.frc2014.ballcatcher;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Toggles the Flipper Up/Down
 * @author Austin Reuland
 */
public class C_CatcherToggle extends Command {

    public C_CatcherToggle() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
		super("C_CatcherToggle");
        requires(SS_BallCatcher.getInstance());
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        if(SS_BallCatcher.isCatcherOpen()){
            SS_BallCatcher.catcherClose();
        }else{
            SS_BallCatcher.catcherOpen();
        }
        
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
