package org.wwr.frc2014.drivetrain;

import edu.wpi.first.wpilibj.command.PIDCommand;
import org.wwr.frc2014.SS_Sensors;

/**
 * Moves the Robot to a the specified distance (in Feet).
 * @author Austin Reuland
 */
public class C_MoveToDistance extends PIDCommand {

    public C_MoveToDistance(double distance) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
		super("C_MoveToDistance", 0.0, 0.0, 0.0);
        requires(SS_Drivetrain.getInstance());
        setSetpoint(distance);
        getPIDController().setAbsoluteTolerance(2.0);
        setTimeout(distance);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }
    
    protected double returnPIDInput() {
        return SS_Sensors.getDistance();
    }

    protected void usePIDOutput(double output) {
        //SS_Drivetrain.PIDMove(output);
        SS_Drivetrain.PIDMove(0.7);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        //return (getPIDController().onTarget()) || isTimedOut();
        return isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
        SS_Drivetrain.PIDMove(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        end();
    }
}
