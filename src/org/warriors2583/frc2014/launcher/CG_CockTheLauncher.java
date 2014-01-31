package org.warriors2583.frc2014.launcher;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * Command Group to ready the Launcher for firing.
 * Had to add the 'The' because too many kids are immature
 * @author Austin Reuland
 */
public class CG_CockTheLauncher extends CommandGroup {

    public CG_CockTheLauncher() {
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
		addSequential(new C_ExtendRam());
		addSequential(new C_RetractRam());
    }
}