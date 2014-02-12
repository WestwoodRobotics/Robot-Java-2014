package org.warriors2583.frc2014.launcher;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.warriors2583.frc2014.RMap;

/**
 *
 * @author Austin Reuland
 */
public class SS_Launcher extends Subsystem implements RMap {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    
    private static final Solenoid m_solenoidRam, m_solenoidRelease;
    private static final DigitalInput m_dioLocked, m_dioBall, m_dioRamPosA, m_dioRamPosB;
    
    private static final SS_Launcher m_instance = new SS_Launcher();

    public static SS_Launcher getInstance(){
        return m_instance;
    }

    static{
        m_solenoidRam = new Solenoid(MODULE_SOLENOID_MAIN, SOLENOID_LAUNCHER_LOAD);
        m_solenoidRelease = new Solenoid(MODULE_SOLENOID_MAIN, SOLENOID_LAUNCHER_RELEASE);
        
        m_dioLocked = new DigitalInput(MODULE_DIO, DIO_LAUNCHER_LOCKED);
        m_dioBall = new DigitalInput(MODULE_DIO, DIO_LAUNCHER_BALL);
        m_dioRamPosA = new DigitalInput(MODULE_DIO, DIO_LAUNCHER_RAM_A);
        m_dioRamPosB = new DigitalInput(MODULE_DIO, DIO_LAUNCHER_RAM_B);
    }

    private SS_Launcher(){
        super("SS_Launcher");
    }
    
    public static void loaderExtend(){
        m_solenoidRam.set(true);
    }
    
    public static void loaderRetract(){
        m_solenoidRam.set(false);
    }
    
    public static void latchRelease(){
        m_solenoidRelease.set(true);
    }
    
    public static void latchLock(){
        m_solenoidRelease.set(false);
    }
    
    public static boolean isRamExtended(){
        return m_dioRamPosB.get();
    }
    
    public static boolean isRamRetracted(){
        return m_dioRamPosA.get();
    }
    
    public static boolean isCocked(){
        return m_dioLocked.get();
    }
    
    public static boolean ballPresent(){
        return m_dioBall.get();
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}
