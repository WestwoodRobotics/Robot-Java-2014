package org.warriors2583.frc2014.auton;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.warriors2583.frc2014.ballcatcher.C_CatcherDown;
import org.warriors2583.frc2014.drivetrain.C_MoveToDistance;
import org.warriors2583.frc2014.launcher.CG_CockTheLauncher;

/**
 * The Main Autonomous Command.
 * This must be called at the beginning of every autonomous period.
 * @author Austin Reuland
 */
public class CG_AutonStart extends CommandGroup {

    public CG_AutonStart() {
        
        //addParallel(new C_MoveToDistance(0.0));
        addSequential(new CG_CockTheLauncher());
        addSequential(new C_CatcherDown());
        //addSequential(new C_LedStatus(C_LedStatus.AUTONREADY));
    }
}