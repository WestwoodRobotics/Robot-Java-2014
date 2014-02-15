package org.warriors2583.frc2014.launcher;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 * @author Austin Reuland
 */
public class C_FlapperUp extends Command {

    public C_FlapperUp() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
		super("C_FlapperUp");
        requires(SS_Launcher.getInstance());
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        SS_Launcher.flapperUp();
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
