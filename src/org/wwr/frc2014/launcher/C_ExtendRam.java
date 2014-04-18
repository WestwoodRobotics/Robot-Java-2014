package org.wwr.frc2014.launcher;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Extend the Launcher Preping Piston
 * @author Austin Reuland
 */
public class C_ExtendRam extends Command {

    public C_ExtendRam() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        super("C_ExtendRam");
        requires(SS_Launcher.getInstance());
        setInterruptible(false);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        SS_Launcher.loaderExtend();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        //return SS_Launcher.isPreped();
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
