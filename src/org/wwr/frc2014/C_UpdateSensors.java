package org.wwr.frc2014;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 * @author Austin Reuland
 */
public class C_UpdateSensors extends Command {

    public C_UpdateSensors() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
		super("C_UpdateSensors");
        requires(SS_Sensors.getInstance());
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        SS_Sensors.updateValues();
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
