package org.wwr.frc2014.drivetrain;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Change the Robot's Drivemode and Wheels
 * @author Austin Reuland
 */
public class C_ChangeDrivemode extends Command {
    
    int mode;

    public C_ChangeDrivemode(double mode) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
		//super("C_ChangeDrivemode");
        //requires(SS_Drivetrain.getInstance());
        this((int) mode);
    }
    
    public C_ChangeDrivemode(int mode) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
		super("C_ChangeDrivemode");
        requires(SS_Drivetrain.getInstance());
        this.mode = mode;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        SS_Drivetrain.DriveMode dmode;
        switch(mode){
        case 1:
            dmode = SS_Drivetrain.DriveMode.ARCADE;
            break;

        case 2:
            dmode = SS_Drivetrain.DriveMode.TANK;
            break;

        case 3:
            dmode = SS_Drivetrain.DriveMode.MECANUM;
            break;
            
        case 4:
            dmode = SS_Drivetrain.DriveMode.MECATANK;
            break;
            
        default:
            dmode = SS_Drivetrain.DriveMode.ARCADE;
            break;
        }
        
        SS_Drivetrain.setDriveMode(dmode);
        SS_Drivetrain.resetDefaultCommand(dmode.getCommand());
        SS_Drivetrain.setSolenoid(dmode.getSolenoid());
        dmode.init();
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
}
