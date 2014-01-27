package org.warriors2583.frc2014.lib;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.parsing.IInputOutput;

/**
 * A better Joystick implementation for the XBox Controller
 * @author Austin Reuland
 */
public class XBoxController extends GenericHID implements IInputOutput{
	
	private final Joystick controller;
	private final int port;

	public XBoxController(final int port){
		controller = new Joystick(port);
		this.port = port;
	}
	
	/**
	 * Get the Left X Axis
	 * @return the left X axis value
	 */
	public double getLeftX(){return controller.getRawAxis(1);}
	
	/**
	 * Get the Left Y Axis
	 * @return the right Y axis value
	 */
	public double getLeftY(){return controller.getRawAxis(2);}
	
	/**
	 * Get the Trigger Axis
	 * @return the trigger axis value
	 */
	public double getTriggers(){return controller.getRawAxis(3);}

	/**
	 * Get the Right X Axis
	 * @return the right x axis value
	 */
	public double getRightX(){return controller.getRawAxis(4);}
	
	/**
	 * Get the Right Y Axis
	 * @return the right Y axis value
	 */
	public double getRightY(){return controller.getRawAxis(5);}
	
	/**
	 * Get the A Button
	 * @return the A button value
	 */
	public boolean btnA(){return controller.getRawButton(0);}
	
	/**
	 * Get the B Button
	 * @return the B button value
	 */
	public boolean btnB(){return controller.getRawButton(1);}
	
	/**
	 * Get the X Button
	 * @return the X button value
	 */
	public boolean btnX(){return controller.getRawButton(2);}
	
	/**
	 * Get the Y Button
	 * @return the Y button value
	 */
	public boolean btnY(){return controller.getRawButton(3);}
	
	/**
	 * Get the Left Shoulder Button
	 * @return the Left Shoulder button value
	 */
	public boolean btnLeftShoulder(){return controller.getRawButton(4);}
	
	/**
	 * Get the Right Shoulder Button
	 * @return the Right Shoulder button value
	 */
	public boolean btnRightShoulder(){return controller.getRawButton(5);}
	
	/**
	 * Get the Start Button
	 * @return the Start button value
	 */
	public boolean btnStart(){return controller.getRawButton(6);}
	
	/**
	 * Get the Select Button
	 * @return the Select button value
	 */
	public boolean btnSelect(){return controller.getRawButton(7);}
	
	/**
	 * Get the Left Stick Button
	 * @return the Left Stick button value
	 */
	public boolean btnLeftStick(){return controller.getRawButton(8);}
	
	/**
	 * Get the Right Stick Button
	 * @return the Right Stick button value
	 */
	public boolean btnRightStick(){return controller.getRawButton(9);}
	
	public double getX(Hand hand) {
		return controller.getX(hand);
	}

	public double getY(Hand hand) {
		return controller.getY(hand);
	}

	public double getZ(Hand hand) {
		return controller.getZ(hand);
	}

	public double getTwist() {
		return controller.getTwist();
	}

	public double getThrottle() {
		return controller.getThrottle();
	}

	public double getRawAxis(int which) {
		return controller.getRawAxis(which);
	}

	public boolean getTrigger(Hand hand) {
		return controller.getTrigger(hand);
	}

	public boolean getTop(Hand hand) {
		return controller.getTop(hand);
	}

	public boolean getBumper(Hand hand) {
		return controller.getBumper(hand);
	}

	public boolean getRawButton(int button) {
		return controller.getRawButton(button);
	}

}