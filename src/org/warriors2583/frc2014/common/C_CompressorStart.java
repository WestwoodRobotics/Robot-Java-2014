package org.warriors2583.frc2014.common;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 * @author Austin Reuland
 */
public class C_CompressorStart extends Command {
	

	public C_CompressorStart() {
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
		super("C_CompressorStart");
		requires(SS_Compressor.getInstance());
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		SS_Compressor.start();
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
		SS_Compressor.stop();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		end();
	}
}
