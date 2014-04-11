package org.warriors2583.frc2014.auton;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.warriors2583.frc2014.launcher.CG_FireBall;
import org.warriors2583.robolib.command.C_Delay;

/**
 * Shoot one Ball.
 * @author Austin Reuland
 */
public class CG_OneBall extends CommandGroup {

    public CG_OneBall() {
    	this(false);
    }
    
    public CG_OneBall(boolean secondFive){
        addSequential(new CG_AutonStart());
        if(secondFive){
            addSequential(new C_Delay(3.0));
        }
        addSequential(new CG_FireBall());
    }
}