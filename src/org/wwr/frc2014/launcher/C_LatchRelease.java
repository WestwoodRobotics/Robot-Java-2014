package org.wwr.frc2014.launcher;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Releases the Launcher
 * @author Austin Reuland
 */
public class C_LatchRelease extends Command {

    public C_LatchRelease() {
        super("C_LatchRelease");
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        SS_Launcher.latchRelease();
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
