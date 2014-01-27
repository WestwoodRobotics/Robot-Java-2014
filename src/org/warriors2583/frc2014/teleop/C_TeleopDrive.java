package org.warriors2583.frc2014.teleop;

import edu.wpi.first.wpilibj.command.Command;
import org.warriors2583.frc2014.OI;
import org.warriors2583.frc2014.drivetrain.SS_Drivetrain;

/**
 *
 * @author Austin Reuland
 */
public class C_TeleopDrive extends Command {
	
	public C_TeleopDrive() {
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
		super("C_TeleopDrive");
		requires(SS_Drivetrain.getInstance());
	}

	// Called just before this Command runs the first time
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		boolean scale = OI.getJDriveButton(5);
		SS_Drivetrain.teleDrive(OI.getJDriveLeftX() * (scale ? 0.7 : 1),
				OI.getJDriveLeftY() * (scale ? 0.7 : 1),
				OI.getJDriveRightX() * (scale ? 0.75 : 1),
				OI.getJDriveRightY()  * (scale ? 0.7 : 1));
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
		end();
	}
}
