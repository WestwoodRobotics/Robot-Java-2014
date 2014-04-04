package org.warriors2583.frc2014;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.parsing.IInputOutput;

/**
 *
 * @author Austin Reuland
 */
public class ArcadeController  extends GenericHID implements IInputOutput {
        
    public static final int BUTTON_ROLLERS_FORWARD = 13;
    public static final int BUTTON_ROLLERS_BACK = 14;
    public static final int BUTTON_CATCHER_CLOSE = 5;
    public static final int BUTTON_CATCHER_OPEN = 4;
    public static final int BUTTON_FLIPPER_UP = 5;
    public static final int BUTTON_FLIPPER_DOWN = 6;
    public static final int BUTTON_LAUNCHER_EXTEND = 10;
    public static final int BUTTON_LAUNCHER_RETRACT = 9;
    public static final int BUTTON_RELEASE_LATCH = 11;
    public static final int BUTTON_RELEASE_UNLATCH = 12;
    
    public static final int BUTTON_FIRE = 1;
    public static final int BUTTON_PREP_CATCH = 7;
    public static final int BUTTON_PREP_PICKUP = 6;
    public static final int BUTTON_REPREP = 8;
    public static final int BUTTON_CATCHER_TOGGLE = 3;
    public static final int BUTTON_FLIPPER_TOGGLE = 2;
    
    private final Joystick m_controller;
    
    public ArcadeController(final int port){
        m_controller = new Joystick(port);
    }

    public double getX(Hand hand) {
        return 0.0;
    }

    public double getY(Hand hand) {
        return 0.0;
    }

    public double getZ(Hand hand) {
        return 0.0;
    }

    public double getTwist() {
        return 0.0;
    }

    public double getThrottle() {
        return 0.0;
    }

    public double getRawAxis(int which) {
        return m_controller.getRawAxis(which);
    }

    public boolean getTrigger(Hand hand) {
        return false;
    }

    public boolean getTop(Hand hand) {
        return false;
    }

    public boolean getBumper(Hand hand) {
        return false;
    }

    public boolean getRawButton(int button) {
        if(button > 12){
            return getAxisButton(button);
        }else{
            return m_controller.getRawButton(button);
        }
    }
    
    //private boolean getAxisButton(int axis){
    //    int button = (axis - 11)/2;
    //    double lowerThresh = 1.0 - (0.5 * (axis % 2));
    //    return getAxisButton(button, -lowerThresh, 1.5 - lowerThresh);
    //}
    private boolean getAxisButton(int axis){
        int button = axis - 12;
        return getAxisButton(button, 0.5);
    }
    
    //private boolean getAxisButton(int axis, double lowerThresh, double upperThresh){
    //    double value = getRawAxis(axis);
    //    return (value <= lowerThresh | value >= upperThresh);
    //}
    
    private boolean getAxisButton(int axis, double upperThresh){
        double value = getRawAxis(axis);
        return (value >= upperThresh);
        
    }
    

}