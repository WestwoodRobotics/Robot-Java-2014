package org.warriors2583.frc2014;

import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.tables.ITable;
import edu.wpi.first.wpilibj.tables.ITableListener;
import org.warriors2583.frc2014.drivetrain.C_ChangeDrivemode;
import org.warriors2583.frc2014.ballcatcher.SS_BallCatcher;

/**
 *
 * @author Austin Reuland
 */
public class Computer implements RMap {

    private static final NetworkTable computerTable, settingsTable, statusTable;
    
    private static final ITableListener settingsListener, statusListener;

    private static boolean tablesInitd = false;

    static{
        computerTable = NetworkTable.getTable(NETTABLE_COMPUTER);
        settingsTable = (NetworkTable) computerTable.getSubTable(NETTABLE_COMPUTER_SETTINGS);
        statusTable = (NetworkTable) computerTable.getSubTable(NETTABLE_COMPUTER_STATUS);
        
        settingsListener = new ITableListener(){
            public void valueChanged(ITable table, String key, Object value, boolean isNew){
                if(key.equals(NETTABLE_COMPUTER_SETTINGS_DRIVEMODE)){
                    new C_ChangeDrivemode((int)table.getNumber(NETTABLE_COMPUTER_SETTINGS_DRIVEMODE));
                }else if(key.equals(NETTABLE_COMPUTER_SETTINGS_CATCHER_SCALE)){
                    SS_BallCatcher.setSpindleScale(table.getNumber(NETTABLE_COMPUTER_SETTINGS_CATCHER_SCALE));
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

        settingsTable.putNumber(NETTABLE_COMPUTER_SETTINGS_DRIVEMODE, 1.0);
        settingsTable.putNumber(NETTABLE_COMPUTER_SETTINGS_CATCHER_SCALE, 0.75);

        settingsTable.addTableListener(settingsListener, false);
        statusTable.addTableListener(statusListener, false);
        
        tablesInitd = true;

    }

}