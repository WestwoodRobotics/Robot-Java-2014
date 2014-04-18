package org.wwr.frc2014.auton;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.wwr.frc2014.launcher.CG_FireBall;
import org.wwr.robolib.command.C_Delay;

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