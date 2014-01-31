package org.warriors2583.frc2014.launcher;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.warriors2583.frc2014.RMap;

/**
 *
 * @author Austin Reuland
 */
public class SS_Launcher extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	private static final Solenoid solenoid_ram, solenoid_release;
	

	private static final SS_Launcher instance = new SS_Launcher();

	public static SS_Launcher getInstance(){
		return instance;
	}

	static{
		solenoid_ram = new Solenoid(RMap.MODULE_SOLENOID_MAIN, RMap.SOLENOID_LAUNCHER_LOAD);
		solenoid_release = new Solenoid(RMap.MODULE_SOLENOID_MAIN, RMap.SOLENOID_LAUNCHER_RELEASE);
	}

	private SS_Launcher(){
		super("SS_Launcher");
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}
