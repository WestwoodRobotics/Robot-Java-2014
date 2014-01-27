package org.warriors2583.frc2014.ballcatcher;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.warriors2583.frc2014.RMap;

/**
 *
 * @author Austin Reuland
 */
public class SS_BallCatcher extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	private static final Victor motor_spindle;
	private static final Solenoid solenoid_frame;

	private static final SS_BallCatcher instance = new SS_BallCatcher();

	public static SS_BallCatcher getInstance(){
		return instance;
	}

	static{
		motor_spindle = new Victor(RMap.MODULE_MOTOR, RMap.MOTOR_CATCHER);
		solenoid_frame = new Solenoid(RMap.MODULE_SOLENOID_MAIN, RMap.SOLENOID_CATCHER);
	}

	private SS_BallCatcher(){
		super("SS_BallCatcher");
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}
