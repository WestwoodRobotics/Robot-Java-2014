package org.warriors2583.frc2014.launcher;

import edu.wpi.first.wpilibj.DigitalInput;
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
	private static final DigitalInput dio_locked, dio_ball, dio_ramPosA, dio_ramPosB;
	
	private static final SS_Launcher instance = new SS_Launcher();

	public static SS_Launcher getInstance(){
		return instance;
	}

	static{
		solenoid_ram = new Solenoid(RMap.MODULE_SOLENOID_MAIN, RMap.SOLENOID_LAUNCHER_LOAD);
		solenoid_release = new Solenoid(RMap.MODULE_SOLENOID_MAIN, RMap.SOLENOID_LAUNCHER_RELEASE);
		
		dio_locked = new DigitalInput(RMap.MODULE_DIO, RMap.DIO_LAUNCHER_LOCKED);
		dio_ball = new DigitalInput(RMap.MODULE_DIO, RMap.DIO_LAUNCHER_BALL);
		dio_ramPosA = new DigitalInput(RMap.MODULE_DIO, RMap.DIO_LAUNCHER_RAM_A);
		dio_ramPosB = new DigitalInput(RMap.MODULE_DIO, RMap.DIO_LAUNCHER_RAM_B);
	}

	private SS_Launcher(){
		super("SS_Launcher");
	}
	
	public static void loaderExtend(){
		solenoid_ram.set(true);
	}
	
	public static void loaderRetract(){
		solenoid_ram.set(false);
	}
	
	public static void latchRelease(){
		solenoid_release.set(true);
	}
	
	public static void latchLock(){
		solenoid_release.set(false);
	}
	
	public static boolean isRamExtended(){
		return dio_ramPosB.get();
	}
	
	public static boolean isRamRetracted(){
		return dio_ramPosA.get();
	}
	
	public static boolean isCocked(){
		return dio_locked.get();
	}
	
	public static boolean ballPresent(){
		return dio_ball.get();
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}
