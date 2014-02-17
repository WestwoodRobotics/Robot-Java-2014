package org.warriors2583.frc2014.common;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.warriors2583.frc2014.RMap;

/**
 * The Compressor Class. Controls the Compressor Sub-System.
 * @author Austin Reuland
 */
public class SS_Compressor extends Subsystem implements RMap {
    
    private static final Compressor m_compressor = new Compressor(DIO_COMPRESSOR, RELAY_COMPRESSOR);
    
    private static final SS_Compressor m_instance = new SS_Compressor();
    
    public static SS_Compressor getInstance() {
        return m_instance;
    }
    
    private SS_Compressor(){
        super("SS_Compressor");
    }
    
    /**
     * Enable the Compressor control loop
     */
    public static void start(){
        m_compressor.start();
    }
    
    /**
     * Disable the Compressor control loop
     */ 
    public static void stop(){
        m_compressor.stop();
    }
    
    /**
     * Get the current enabled state of the compressor
     * @return compressor enabled state
     */
    public static boolean isEnabled(){
        return m_compressor.enabled();
    }
    
    /**
     * Get the current running state of the compressor (are we compressing)
     * @return compressor running state
     */
    public static boolean isRunning(){
        return m_compressor.getPressureSwitchValue();
    }
    
    
    public static void makeSafe(){
        m_compressor.stop();
        m_compressor.free();
    }
    
    
    protected void initDefaultCommand() {
        //setDefaultCommand(new C_CompressorStart());
    }
}
