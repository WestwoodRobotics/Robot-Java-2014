package org.warriors2583.frc2014.lib;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import org.warriors2583.frc2014.RMap;

/**
 *
 * @author Austin Reuland
 */
public class SS_DashLogger extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	private static final NetworkTable logTable;

	private static final SS_DashLogger instance = new SS_DashLogger();

	public static SS_DashLogger getInstance(){
		return instance;
	}

	static{
		logTable = NetworkTable.getTable(RMap.NETTABLE_DEFAULT_TABLE);
		
	}

	private SS_DashLogger(){
		super("SS_DashLogger");
	}
	
	public static void logDebug(String str){ 
		logTable.putString(RMap.NETTABLE_DASH_LOG, "[D]" + str);
	}
	
	public static void logInfo(String str){
		logTable.putString(RMap.NETTABLE_DASH_LOG, "[I]" + str);
	}
	
	public static void logWarn(String str){
		logTable.putString(RMap.NETTABLE_DASH_LOG, "[W]" + str);
	}
	
	public static void logErr(String str){
		logTable.putString(RMap.NETTABLE_DASH_LOG, "[E]" + str);
	}
	
	public static void logCritErr(String str){
		logTable.putString(RMap.NETTABLE_DASH_LOG, "[CRITERROR]" + str);
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}
