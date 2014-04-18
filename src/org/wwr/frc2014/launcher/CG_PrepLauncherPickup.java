package org.wwr.frc2014.launcher;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.wwr.frc2014.ballcatcher.C_CatcherOpen;
import org.wwr.frc2014.ballcatcher.C_FlipperDown;

/**
 * Command Group to ready the Launcher for firing.
 * Had to add the 'The' because too many kids are immature
 * @author Austin Reuland
 */
public class CG_PrepLauncherPickup extends CommandGroup {

    public CG_PrepLauncherPickup() {
        setInterruptible(false);
        
        addParallel(new C_CatcherOpen());
        addParallel(new C_FlipperDown());
        addParallel(new CG_PrepLauncher());
    }
}