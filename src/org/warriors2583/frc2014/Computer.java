package org.warriors2583.frc2014;

import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.tables.ITable;
import edu.wpi.first.wpilibj.tables.ITableListener;
import org.warriors2583.frc2014.drivetrain.SS_Drivetrain;

/**
 *
 * @author Austin Reuland
 */
public class Computer {

    private static final NetworkTable computerTable, settingsTable, statusTable;
    
    private static final ITableListener settingsListener, statusListener;

    private static boolean tablesInitd = false;

    static{
        computerTable = NetworkTable.getTable(RMap.NETTABLE_COMPUTER);
        settingsTable = (NetworkTable) computerTable.getSubTable(RMap.NETTABLE_COMPUTER_SETTINGS);
        statusTable = (NetworkTable) computerTable.getSubTable(RMap.NETTABLE_COMPUTER_STATUS);
        
        settingsListener = new ITableListener(){
            public void valueChanged(ITable table, String key, Object value, boolean isNew){
                if(key.equals(RMap.NETTABLE_COMPUTER_SETTINGS_DRIVEMODE)){
                    SS_Drivetrain.setDriveMode((int)table.getNumber(RMap.NETTABLE_COMPUTER_SETTINGS_DRIVEMODE));
                }
            }
        };
        
        statusListener = new ITableListener(){
            public void valueChanged(ITable table, String key, Object value, boolean isNew){
                
            }
        };
                
    }
    
    public Computer(){
        initTables();
    }

    private static void initTables(){
        if(tablesInitd){
            settingsTable.removeTableListener(settingsListener);
            statusTable.removeTableListener(statusListener);
        }

        settingsTable.putNumber(RMap.NETTABLE_COMPUTER_SETTINGS_DRIVEMODE, 1.0);

        settingsTable.addTableListener(settingsListener, false);
        statusTable.addTableListener(statusListener, false);
        
        tablesInitd = true;

    }

}