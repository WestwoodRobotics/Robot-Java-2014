package org.warriors2583.frc2014.drivetrain;

import edu.wpi.first.wpilibj.command.Command;
import org.warriors2583.frc2014.RasPi;
import org.warriors2583.frc2014.lib.CommonFunctions;

/**
 *
 * @author Austin Reuland
 */
public class C_RotateToAngle extends Command {
	
	int dir = 0;
	double angle;

    public C_RotateToAngle(double angleToGoTo) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
		super("C_DTRotateToAngle");
		requires(SS_Drivetrain.getInstance());
		angle = angleToGoTo;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
		dir = CommonFunctions.directionTo(angle, RasPi.getCompassHeading());
		
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
		SS_Drivetrain.rotate(0.5 * dir);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return (Math.abs(angle - RasPi.getCompassHeading()) < 3.5) ||
				(SS_Drivetrain.getExternLock() == false);
    }

    // Called once after isFinished returns true
    protected void end() {
		SS_Drivetrain.setExternalLock(true);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
