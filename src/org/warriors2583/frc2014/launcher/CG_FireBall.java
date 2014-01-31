package org.warriors2583.frc2014.launcher;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.warriors2583.frc2014.lib.C_Delay;

/**
 *
 * @author Austin Reuland
 */
public class CG_FireBall extends CommandGroup {

    public CG_FireBall() {
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
		addSequential(new CG_FireBall());
		addSequential(new C_Delay(0.5));
		addSequential(new CG_CockTheLauncher());
    }
}