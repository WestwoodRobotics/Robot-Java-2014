package org.wwr.frc2014.auton;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.wwr.frc2014.ballcatcher.C_CatcherOpen;
import org.wwr.frc2014.drivetrain.C_ChangeDrivemode;
import org.wwr.frc2014.drivetrain.C_MoveToDistance;
import org.wwr.frc2014.launcher.CG_PrepLauncher;

/**
 * The Main Autonomous Command.
 * This must be called at the beginning of every autonomous period.
 * @author Austin Reuland
 */
public class CG_AutonStart extends CommandGroup {

    public CG_AutonStart() {
        
        addParallel(new C_ChangeDrivemode(1));
        addParallel(new CG_PrepLauncher());
        addParallel(new C_CatcherOpen());
        addSequential(new C_MoveToDistance(1.5));
        //addSequential(new C_LedStatus(C_LedStatus.AUTONREADY));
    }
}