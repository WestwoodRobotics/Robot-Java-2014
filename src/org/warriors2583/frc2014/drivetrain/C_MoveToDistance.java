package org.warriors2583.frc2014.drivetrain;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.PIDCommand;

/**
 * Moves the Robot to a the specified distance (in Feet).
 * @author Austin Reuland
 */
public class C_MoveToDistance extends PIDCommand {
    
    Timer m_timer;
    double m_timeout;

    public C_MoveToDistance(double distance) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
		super("C_MoveToDistance", 0.0, 0.0, 0.0);
        requires(SS_Drivetrain.getInstance());
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
