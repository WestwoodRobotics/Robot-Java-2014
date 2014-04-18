package org.wwr.frc2014.launcher;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.wwr.robolib.command.C_Delay;

/**
 * Command Group to ready the Launcher for firing.
 * @author Austin Reuland
 */
public class CG_PrepLauncher extends CommandGroup {

    public CG_PrepLauncher() {
        setInterruptible(false);
        
        addSequential(new C_ExtendRam());
        //addSequential(new C_WaitForPrep());
        addSequential(new C_Delay(3));
        //addSequential(new C_)
        addSequential(new C_RetractRam());
        addSequential(new C_Delay(2));
    }
}