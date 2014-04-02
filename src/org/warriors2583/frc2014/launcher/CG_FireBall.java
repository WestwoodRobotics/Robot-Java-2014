package org.warriors2583.frc2014.launcher;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.warriors2583.lib.C_Delay;
import org.warriors2583.frc2014.ballcatcher.C_CatcherOpen;

/**
 * Fires the Ball
 * @author Austin Reuland
 */
public class CG_FireBall extends CommandGroup {

    public CG_FireBall() {

        addSequential(new C_CatcherOpen());
        addSequential(new C_Delay(0.1));
        addSequential(new CG_LatchToggle());
        //addSequential(new C_Delay(0.1));
        //addSequential(new CG_CockTheLauncher());
    }
}