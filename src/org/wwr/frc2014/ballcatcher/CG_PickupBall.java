package org.wwr.frc2014.ballcatcher;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 * @author Austin Reuland
 */
public class CG_PickupBall extends CommandGroup {

    public CG_PickupBall() {
        addParallel(new C_CatcherOpen());
        addSequential(new C_SpindleForward(), 4);
    }
}