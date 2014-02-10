package org.warriors2583.frc2014;

import edu.wpi.first.wpilibj.networktables.NetworkTable;

/**
 *
 * @author Austin Reuland
 */
public class RasPi {
    
    private static final NetworkTable rasPiTable, compTable, accelTable, gyroTable, statusTable;
    
    static{
        rasPiTable = NetworkTable.getTable(RMap.NETTABLE_RASPI);
        compTable = (NetworkTable) rasPiTable.getSubTable(RMap.NETTABLE_RASPI_COMP);
        accelTable = (NetworkTable) rasPiTable.getSubTable(RMap.NETTABLE_RASPI_ACCEL);
        gyroTable = (NetworkTable) rasPiTable.getSubTable(RMap.NETTABLE_RASPI_GYRO);
        statusTable = (NetworkTable) rasPiTable.getSubTable(RMap.NETTABLE_RASPI_STATUS);
    }
    
    public static double getCompassHeading(){
        return compTable.getNumber(RMap.NETTABLE_RASPI_COMP_HEADING_SCALED, 0.0);
    }
    
    public static void setEnabled(boolean value){
        statusTable.putBoolean(RMap.NETTABLE_RASPI_STATUS_ENABLED, value);
    }
    
    public static boolean getReady(){
        return statusTable.getBoolean(RMap.NETTABLE_RASPI_STATUS_READY);
    }
    
    

}