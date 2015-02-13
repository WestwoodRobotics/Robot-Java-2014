/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.warriors2583.frc2014.ballcatcher;

import edu.wpi.first.wpilibj.command.Command;
import org.warriors2583.frc2014.OI;

/**
 *
 * @author mswalker
 */
public class C_SpindleVariable extends Command {
    
    public C_SpindleVariable() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(SS_BallCatcher.getInstance());
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        // set roller speed to Y axis value of right joystick on XBox controller
        SS_BallCatcher.spindleSet(OI.getJDriveRightY());
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
