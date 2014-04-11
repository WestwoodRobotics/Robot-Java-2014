package org.warriors2583.frc2014.launcher;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.warriors2583.robolib.command.C_Delay;

/**
 * Quickly toggles the Launcher Release
 * @author Austin Reuland
 */
public class CG_LatchToggle extends CommandGroup {

    public CG_LatchToggle() {
        setInterruptible(false);
        addSequential(new C_LatchRelease());
        addSequential(new C_Delay(0.05));
        addSequential(new C_LatchLock());
    }
}