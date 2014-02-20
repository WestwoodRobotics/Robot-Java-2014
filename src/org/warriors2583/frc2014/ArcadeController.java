package org.warriors2583.frc2014;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.parsing.IInputOutput;

/**
 *
 * @author Austin Reuland
 */
public class ArcadeController  extends GenericHID implements IInputOutput {

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
        return 0.0;
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
        return false;
    }
    

}