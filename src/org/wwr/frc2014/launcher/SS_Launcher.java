package org.wwr.frc2014.launcher;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.tables.ITable;
import edu.wpi.first.wpilibj.tables.ITableListener;
import org.wwr.frc2014.RMap;

/**
 * Ball Launcher Class. Controls the Launcher Sub-System
 * @author Austin Reuland
 */
public class SS_Launcher extends Subsystem implements RMap {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    
    private static final Solenoid m_solenoidRam, m_solenoidRelease, m_solenoidFlow, m_solenoidLock;
    private static final DigitalInput m_dioPreped, m_dioBall, m_dioRamPosA;
    
    private static final ITable m_table;
    
    private static ITableListener m_tableListener;

    private static final SS_Launcher m_instance = new SS_Launcher();

    public static SS_Launcher getInstance(){
        return m_instance;
    }

    static{
        m_solenoidRam = new Solenoid(MODULE_SOLENOID_MAIN, SOLENOID_LAUNCHER_LOAD);
        m_solenoidRelease = new Solenoid(MODULE_SOLENOID_MAIN, SOLENOID_LAUNCHER_RELEASE);
        m_solenoidFlow = new Solenoid(MODULE_SOLENOID_MAIN, SOLENOID_LAUNCHER_FLOW);
        m_solenoidLock = new Solenoid(MODULE_SOLENOID_MAIN, SOLENOID_LAUNCHER_LOCK);
        
        m_dioPreped = new DigitalInput(MODULE_DIO, DIO_LAUNCHER_PREPRED);
        m_dioBall = new DigitalInput(MODULE_DIO, DIO_LAUNCHER_BALL);
        m_dioRamPosA = new DigitalInput(MODULE_DIO, DIO_LAUNCHER_RAM_A);
        //m_dioRamPosB = new DigitalInput(MODULE_DIO, DIO_LAUNCHER_RAM_B);
        
        m_table = roboTable.getSubTable(NETTABLE_LAUNCHER);
        initLauncherTable();
    }

    private SS_Launcher(){
        super("SS_Launcher");
    }
    
    public static void loaderExtend(){
        m_solenoidRam.set(true);
        m_solenoidLock.set(true);
    }
    
    public static void loaderRetract(){
        m_solenoidRam.set(false);
    }
    
    public static void setFlow(boolean on){
        m_solenoidFlow.set(on);
    }
    
    public static void latchRelease(){
        m_solenoidRelease.set(true);
    }
    
    public static void latchLock(){
        m_solenoidRelease.set(false);
    }
    
    public static boolean isRamExtended(){
        //return m_dioRamPosB.get();
        return false;
    }
    
    public static boolean isRamRetracted(){
        return m_dioRamPosA.get();
    }
    
    public static boolean isPreped(){
        return !m_dioPreped.get();
    }
    
    public static boolean ballPresent(){
        return m_dioBall.get();
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    private static void initLauncherTable(){
        m_table.putBoolean(NETTABLE_LAUNCHER_READY, isPreped());
        m_tableListener = new ITableListener(){
            public void valueChanged(ITable table, String key, Object value, boolean isNew){
                
            }
        };
        
        m_table.addTableListener(m_tableListener, true);
    }
}
