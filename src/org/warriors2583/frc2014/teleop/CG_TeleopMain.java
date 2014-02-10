package org.warriors2583.frc2014.teleop;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 * @author Austin Reuland
 */
public class CG_TeleopMain extends CommandGroup {

    public CG_TeleopMain() {

        addParallel(new C_TeleopDrive());
        addParallel(new C_TeleopCatcher());
        addParallel(new C_TeleopLauncher());
    }
}