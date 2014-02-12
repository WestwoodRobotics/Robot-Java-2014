package org.warriors2583.frc2014.drivetrain;

import edu.wpi.first.wpilibj.command.PIDCommand;
import org.warriors2583.frc2014.RasPi;
import org.warriors2583.lib.CommonFunctions;

/**
 *
 * @author Austin Reuland
 */
public class C_RotateToAngle extends PIDCommand {
    
    int dir = 0;
    double angle;

    public C_RotateToAngle(double angleToGoTo) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        super("C_RotateToAngle", 0.0, 0.0, 0.0);
        requires(SS_Drivetrain.getInstance());
        angle = angleToGoTo;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        dir = CommonFunctions.directionTo(angle, RasPi.getCompassHeading());
        
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
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

    protected double returnPIDInput() {
        return 0.0;
    }

    protected void usePIDOutput(double output) {
        //SS_Drivetrain.PIDMove
    }
}
