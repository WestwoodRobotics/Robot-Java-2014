package org.warriors2583.frc2014.launcher;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * Command Group to ready the Launcher for firing.
 * Had to add the 'The' because too many kids are immature
 * @author Austin Reuland
 */
public class CG_CockTheLauncher extends CommandGroup {

    public CG_CockTheLauncher() {
        
        addSequential(new C_ExtendRam());
        //addSequential(new C_)
        addSequential(new C_RetractRam());
    }
}