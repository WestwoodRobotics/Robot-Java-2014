package org.wwr.frc2014.drivetrain;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.PIDCommand;
import org.wwr.robolib.util.CommonFunctions;

/**
 * Rotates the Robot to the specified angle (relative to earth).
 * @author Austin Reuland
 */
public class C_RotateToAngle extends PIDCommand {
    
    int dir = 0;
    double angle;
    Timer m_timer;
    double m_timeout;

    public C_RotateToAngle(double angleToGoTo) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        super("C_RotateToAngle", 0.0, 0.0, 0.0);
        requires(SS_Drivetrain.getInstance());
        angle = angleToGoTo;
        dir = CommonFunctions.directionTo(angle, 0);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        m_timer = new Timer();   
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        
    }
    
    protected double returnPIDInput() {
        return 0.0;
    }

    protected void usePIDOutput(double output) {
        SS_Drivetrain.PIDMove(output);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return m_timer.get() >= m_timeout;
    }

    // Called once after isFinished returns true
    protected void end() {
        m_timer.stop();
        m_timer = null;
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        end();
    }
}
