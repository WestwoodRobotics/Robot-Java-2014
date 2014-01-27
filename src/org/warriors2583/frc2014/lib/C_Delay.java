package org.warriors2583.frc2014.lib;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 * @author Austin Reuland
 */
public class C_Delay extends Command {

	private final double sec;
	private final Timer timer = new Timer();
	
    public C_Delay(double sec) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
		super("C_Delay");
		this.sec = sec;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
		timer.start();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return timer.get() >= sec;
    }

    // Called once after isFinished returns true
    protected void end() {
		timer.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
