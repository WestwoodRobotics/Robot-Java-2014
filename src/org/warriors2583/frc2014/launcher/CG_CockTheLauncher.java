package org.warriors2583.frc2014.launcher;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.warriors2583.lib.C_Delay;

/**
 * Command Group to ready the Launcher for firing.
 * Had to add the 'The' because too many kids are immature
 * @author Austin Reuland
 */
public class CG_CockTheLauncher extends CommandGroup {

    public CG_CockTheLauncher() {
        
        addSequential(new C_ExtendRam());
        addSequential(new C_Delay(3));
        //addSequential(new C_)
        addParallel(new C_RetractRam());
        addSequential(new C_Delay(2));
    }
}