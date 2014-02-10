package org.warriors2583.frc2014.teleop;

import edu.wpi.first.wpilibj.command.Command;
import org.warriors2583.frc2014.launcher.SS_Launcher;

/**
 *
 * @author Austin Reuland
 */
public class C_TeleopLauncher extends Command {

    public C_TeleopLauncher() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        super("C_TeleopLauncher");
        requires(SS_Launcher.getInstance());
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        
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
