package org.warriors2583.frc2014.launcher;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.warriors2583.lib.C_Delay;

/**
 *
 * @author Austin Reuland
 */
public class CG_LatchToggle extends CommandGroup {

    public CG_LatchToggle() {

        addSequential(new C_LatchRelease());
        addSequential(new C_Delay(0.1));
        addSequential(new C_LatchLock());
    }
}