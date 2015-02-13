/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.warriors2583.frc2014.drivetrain;
import edu.wpi.first.wpilibj.command.Command;


/**
 *
 * @author mswalker
 */
public class C_DriveForward extends Command {
    
    private double forwardSpeed;
    
    public C_DriveForward(double iSpeed) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(SS_Drivetrain.getInstance());
        forwardSpeed = iSpeed;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        // start robot driving forward
        SS_Drivetrain.setDriveMode(SS_Drivetrain.DriveMode.TANK);
        SS_Drivetrain.tank(forwardSpeed, forwardSpeed);
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
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        end();
    }
}
