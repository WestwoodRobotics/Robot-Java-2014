package org.warriors2583.lib;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.parsing.IInputOutput;

/**
 * A better Joystick implementation for the XBox Controller
 * @author Austin Reuland
 */
public class XBoxController extends GenericHID implements IInputOutput{
    
    private final Joystick m_controller;
    
    public static final int AXIS_LEFT_X_ID = 1,
    AXIS_LEFT_Y_ID = 2,
    AXIS_TRIGGERS_ID = 3,
    AXIS_RIGHT_X_ID = 4,
    AXIS_RIGHT_Y_ID = 5,
    AXIS_HAT_X_ID = 6;

    public static final int BTN_A_ID = 1,
    BTN_B_ID = 2,
    BTN_X_ID = 3,
    BTN_Y_ID = 4,
    BTN_LEFT_SHOULDER_ID = 5,
    BTN_RIGHT_SHOULDER_ID = 6,
    BTN_START_ID = 7,
    BTN_SELECT_ID = 8,
    BTN_LEFT_STICK_ID = 9,
    BTN_RIGHT_STICK_ID = 10;

    public XBoxController(final int port){
        m_controller = new Joystick(port);
    }
    
    /**
     * Get the Left X Axis
     * @return the left X axis value
     */
    public double getLeftX(){return m_controller.getRawAxis(AXIS_LEFT_X_ID);}
    
    /**
     * Get the Left Y Axis
     * @return the right Y axis value
     */
    public double getLeftY(){return m_controller.getRawAxis(AXIS_LEFT_Y_ID);}
    
    /**
     * Get the Trigger Axis
     * @return the trigger axis value
     */
    public double getTriggers(){return m_controller.getRawAxis(AXIS_TRIGGERS_ID);}

    /**
     * Get the Right X Axis
     * @return the right x axis value
     */
    public double getRightX(){return m_controller.getRawAxis(AXIS_RIGHT_X_ID);}
    
    /**
     * Get the Right Y Axis
     * @return the right Y axis value
     */
    public double getRightY(){return m_controller.getRawAxis(AXIS_RIGHT_Y_ID);}

    /**
     * Get the D-Pad/Hat X Axis
     * @return the d-pad X axis value
     */
    public double getHatX(){return m_controller.getRawAxis(AXIS_HAT_X_ID);}
    
    /**
     * Get the A Button
     * @return the A button value
     */
    public boolean btnA(){return m_controller.getRawButton(BTN_A_ID);}
    
    /**
     * Get the B Button
     * @return the B button value
     */
    public boolean btnB(){return m_controller.getRawButton(BTN_B_ID);}
    
    /**
     * Get the X Button
     * @return the X button value
     */
    public boolean btnX(){return m_controller.getRawButton(BTN_X_ID);}

    /**
     * Get the Y Button
     * @return the Y button value
     */
    public boolean btnY(){return m_controller.getRawButton(BTN_Y_ID);}
    
    /**
     * Get the Left Shoulder Button
     * @return the Left Shoulder button value
     */
    public boolean btnLeftShoulder(){return m_controller.getRawButton(BTN_LEFT_SHOULDER_ID);}
    
    /**
     * Get the Right Shoulder Button
     * @return the Right Shoulder button value
     */
    public boolean btnRightShoulder(){return m_controller.getRawButton(BTN_RIGHT_SHOULDER_ID);}
    
    /**
     * Get the Start Button
     * @return the Start button value
     */
    public boolean btnStart(){return m_controller.getRawButton(BTN_START_ID);}
    
    /**
     * Get the Select Button
     * @return the Select button value
     */
    public boolean btnSelect(){return m_controller.getRawButton(BTN_SELECT_ID);}
    
    /**
     * Get the Left Stick Button
     * @return the Left Stick button value
     */
    public boolean btnLeftStick(){return m_controller.getRawButton(BTN_LEFT_STICK_ID);}
    
    /**
     * Get the Right Stick Button
     * @return the Right Stick button value
     */
    public boolean btnRightStick(){return m_controller.getRawButton(BTN_RIGHT_STICK_ID);}
        
    public double getX(Hand hand) {
        return m_controller.getX(hand);
    }

    public double getY(Hand hand) {
        return m_controller.getY(hand);
    }

    public double getZ(Hand hand) {
        return m_controller.getZ(hand);
    }

    public double getTwist() {
        return m_controller.getTwist();
    }

    public double getThrottle() {
        return m_controller.getThrottle();
    }

    public double getRawAxis(int which) {
        return m_controller.getRawAxis(which);
    }

    public boolean getTrigger(Hand hand) {
        return m_controller.getTrigger(hand);
    }

    public boolean getTop(Hand hand) {
        return m_controller.getTop(hand);
    }

    public boolean getBumper(Hand hand) {
        return m_controller.getBumper(hand);
    }

    public boolean getRawButton(int button) {
        return m_controller.getRawButton(button);
    }

}