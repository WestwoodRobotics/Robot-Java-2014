
package org.wwr.frc2014.ballcatcher;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 * @author Austin Reuland
 */
public class CG_EjectBall extends CommandGroup {

    public CG_EjectBall() {
        addParallel(new C_CatcherClose());
        addSequential(new C_SpindleBackward(), 4);
    }
}