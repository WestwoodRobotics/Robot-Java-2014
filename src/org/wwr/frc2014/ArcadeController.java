package org.wwr.frc2014;

import org.wwr.robolib.control.Joystick;

/**
 *
 * @author Austin Reuland
 */
public class ArcadeController extends Joystick{
        
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
    public static final int BUTTON_EJECT_BALL = 7;
    public static final int BUTTON_PREP_PICKUP = 6;
    public static final int BUTTON_REPREP = 8;
    public static final int BUTTON_CATCHER_TOGGLE = 3;
    public static final int BUTTON_FLIPPER_TOGGLE = 2;
    
    public ArcadeController(final int port){
        super(port);
        addAxisButton(1, 0.5, -1.0);
        addAxisButton(2, 0.5, -1.0);
    }
}