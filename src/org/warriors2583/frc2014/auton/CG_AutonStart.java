package org.warriors2583.frc2014.auton;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.warriors2583.frc2014.ballcatcher.C_CatcherDown;
import org.warriors2583.frc2014.launcher.CG_CockTheLauncher;

/**
 *
 * @author Austin Reuland
 */
public class CG_AutonStart extends CommandGroup {

    public CG_AutonStart() {
        
        addSequential(new CG_CockTheLauncher());
        addSequential(new C_CatcherDown());
    }
}