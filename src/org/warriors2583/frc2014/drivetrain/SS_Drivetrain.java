package org.warriors2583.frc2014.drivetrain;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 * @author Austin Reuland
 */
public class SS_Drivetrain extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

	private static final SS_Drivetrain instance = new SS_Drivetrain();

	public static SS_Drivetrain getInstance(){
		return instance;
	}

	static{
		
	}

	private SS_Drivetrain(){
		super("SS_Drivetrain");
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}
