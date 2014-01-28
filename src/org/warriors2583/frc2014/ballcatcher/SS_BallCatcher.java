package org.warriors2583.frc2014.ballcatcher;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.warriors2583.frc2014.OI;
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
	
	/**
	 * Set the Ball Catcher Frame Down
	 */
	public static void catcherUp(){solenoid_frame.set(false);}
	
	/**
	 * Set the Ball Catcher Frame Down
	 */
	public static void catcherDown(){solenoid_frame.set(true);}
	
	/**
	 * Find if the Ball Catcher frame is Down
	 * @return state of Ball Catcher frame
	 */
	public static boolean isDown(){return solenoid_frame.get();}
	
	/**
	 * Run the Ball Catcher Spindle Forward
	 */
	public static void spindleForward(){motor_spindle.set(0.75);}
	
	/**
	 * Run the Ball Catcher Spindle Backward
	 */
	public static void spindleBackward(){motor_spindle.set(-0.75);}
	
	/**
	 * Stop the Ball Catcher Spindle
	 */
	public static void spindleStop(){motor_spindle.set(0);}
	
	/**
	 * Set the Ball Catcher Spindle to a Custom Speed
	 * @param speed Spindle Speed
	 */
	public static void spindleSet(double speed){motor_spindle.set(speed);}
	
	/**
	 * Get the state of the Ball Catcher Frame
	 * @return ball catcher frame state (up/down)
	 */
	public static boolean getCatcherState(){return solenoid_frame.get();}
	
	
	public static void makeSafe(){
		motor_spindle.stopMotor();
		motor_spindle.disable();
		motor_spindle.free();
		
		solenoid_frame.set(false);
		solenoid_frame.free();
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}
