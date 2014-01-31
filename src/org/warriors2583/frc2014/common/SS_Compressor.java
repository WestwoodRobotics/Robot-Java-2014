package org.warriors2583.frc2014.common;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.warriors2583.frc2014.RMap;

/**
 *
 * @author Austin Reuland
 */
public class SS_Compressor extends Subsystem {
	
	private static final Compressor compressor = new Compressor(RMap.DIO_COMPRESSOR, RMap.RELAY_COMPRESSOR);
	
	private static final SS_Compressor instance = new SS_Compressor();
	
	public static SS_Compressor getInstance() {
		return instance;
	}
	
	private SS_Compressor(){
		super("SS_Compressor");
	}
	
	/**
	 * Enable the Compressor control loop
	 */
	public static void start(){
		compressor.start();
	}
	
	/**
	 * Disable the Compressor control loop
	 */	
	public static void stop(){
		compressor.stop();
	}
	
	/**
	 * Get the current enabled state of the compressor
	 * @return compressor enabled state
	 */
	public static boolean isOn(){
		return compressor.enabled();
	}
	
	/**
	 * Get the current running state of the compressor (are we compressing)
	 * @return compressor running state
	 */
	public static boolean isRunning(){
		return compressor.getPressureSwitchValue();
	}
	
	
	public static void makeSafe(){
		compressor.stop();
		compressor.free();
	}
	
	
	protected void initDefaultCommand() {
		setDefaultCommand(new C_CompressorStart());
	}
}
