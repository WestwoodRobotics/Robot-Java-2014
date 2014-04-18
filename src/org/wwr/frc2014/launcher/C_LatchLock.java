package org.wwr.frc2014.launcher;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Locks the Launcher
 * @author Austin Reuland
 */
public class C_LatchLock extends Command {

    public C_LatchLock() {
        super("C_LatchLock");
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        SS_Launcher.latchLock();
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
