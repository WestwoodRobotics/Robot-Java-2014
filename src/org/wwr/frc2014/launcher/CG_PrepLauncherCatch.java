package org.wwr.frc2014.launcher;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.wwr.frc2014.ballcatcher.C_CatcherOpen;
import org.wwr.frc2014.ballcatcher.C_FlipperUp;

/**
 * Command Group to ready the Launcher for firing.
 * Had to add the 'The' because too many kids are immature
 * @author Austin Reuland
 */
public class CG_PrepLauncherCatch extends CommandGroup {

    public CG_PrepLauncherCatch() {
        setInterruptible(false);
        
        addParallel(new C_CatcherOpen());
        addParallel(new C_FlipperUp());
        addParallel(new CG_PrepLauncher());
    }
}