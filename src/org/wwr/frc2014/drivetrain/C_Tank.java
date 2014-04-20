package org.wwr.frc2014.drivetrain;

import edu.wpi.first.wpilibj.command.Command;
import org.wwr.frc2014.OI;
import org.wwr.frc2014.RMap;

/**
 * Tank mode Driving Logic
 * @author Austin Reuland
 */
public class C_Tank extends Command implements RMap {

    public C_Tank() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        super("C_Tank");
        requires(SS_Drivetrain.getInstance());
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        boolean scale = OI.getJDriveButton(JOY_DRIVE_BTN_SCALE);
        SS_Drivetrain.tank(OI.getJDriveLeftY() * (scale ? 0.7 : 1),
                OI.getJDriveRightY() * (scale ? 0.7 : 1));
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
