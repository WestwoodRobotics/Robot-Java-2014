package org.wwr.frc2014.ballcatcher;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.tables.ITable;
import edu.wpi.first.wpilibj.tables.ITableListener;
import org.wwr.frc2014.RMap;

/**
 * The Ball Catcher Subsystem
 * @author Austin Reuland
 */
public class SS_BallCatcher extends Subsystem implements RMap {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    
    private static double m_spindleScale;

    private static final Victor m_motor;
    private static final Solenoid m_solenoidCatcher, m_solenoidFlipper;
    
    private static final ITable m_table;
    
    private static ITableListener m_tableListener;
    
    private static final SS_BallCatcher instance = new SS_BallCatcher();

    public static SS_BallCatcher getInstance(){
        return instance;
    }

    static{
        m_spindleScale = 0.75;
         
        m_motor = new Victor(MODULE_MOTOR, MOTOR_CATCHER);
        m_solenoidCatcher = new Solenoid(MODULE_SOLENOID_MAIN, SOLENOID_CATCHER);
        m_solenoidFlipper = new Solenoid(MODULE_SOLENOID_MAIN, SOLENOID_LAUNCHER_FLAPPER);
        
        m_table = roboTable.getSubTable(NETTABLE_CATCHER);
        
        initCatcherTable();

    }

    private SS_BallCatcher(){
        super("SS_BallCatcher");
    }
    
    /**
     * Set the Ball Catcher Frame Down
     */
    public static void catcherClose(){
        m_solenoidCatcher.set(false);
        m_table.putBoolean(NETTABLE_CATCHER_CATCHER_STATE, false);
    }
    
    /**
     * Set the Ball Catcher Frame Down
     */
    public static void catcherOpen(){
        m_solenoidCatcher.set(true);
        m_table.putBoolean(NETTABLE_CATCHER_CATCHER_STATE, true);
    }
    
    /**
     * Find if the Ball Catcher frame is Down
     * @return state of Ball Catcher frame
     */
    public static boolean isCatcherOpen(){
        return m_solenoidCatcher.get();
    }
    
    /**
     * Run the Ball Catcher Spindle Forward
     */
    public static void spindleForward(){
        m_motor.set(getSpindleScale());
    }
    
    /**
     * Run the Ball Catcher Spindle Backward
     */
    public static void spindleBackward(){
        m_motor.set(-getSpindleScale());
    }
    
    /**
     * Stop the Ball Catcher Spindle
     */
    public static void spindleStop(){
        m_motor.set(0);
    }
    
    /**
     * Set the Ball Catcher Spindle to a Custom Speed
     * @param speed Spindle Speed
     */
    public static void spindleSet(double speed){
        m_motor.set(speed * m_spindleScale);
    }

    /**
     * Gets the scaling speed of the spindle
     * @return double value
     */
    public static double getSpindleScale(){
        return m_spindleScale;
    }

    /**
     * Sets the scaling speed of the spindle
     * @param scale Spindle Speed Scaling Factor
     */
    public static void setSpindleScale(double scale){
        m_spindleScale = scale;
        m_table.putNumber(NETTABLE_CATCHER_SPINDLE_SCALE, scale);
    }
    
    public static void flipperDown(){
        m_solenoidFlipper.set(true);
        m_table.putBoolean(NETTABLE_CATCHER_FLIPPER_STATE, true);
    }
    
    public static void flipperUp(){
        m_solenoidFlipper.set(false);
        m_table.putBoolean(NETTABLE_CATCHER_FLIPPER_STATE, false);
    }
    
    public static boolean isFlipperDown(){
        return m_solenoidFlipper.get();
    }

    /**
     * Get the state of the Ball Catcher Frame
     * @return ball catcher frame state (up/down)
     */
    public static boolean getCatcherState(){
        return m_solenoidCatcher.get();
    }
    
    public static void makeSafe(){
        m_motor.stopMotor();
        m_motor.disable();
        m_motor.free();
        
        m_solenoidCatcher.set(false);
        m_solenoidCatcher.free();
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new C_Teleop());
    }
    
    private static void initCatcherTable(){
        
        m_table.putBoolean(NETTABLE_CATCHER_CATCHER_STATE, m_solenoidCatcher.get());
        m_table.putBoolean(NETTABLE_CATCHER_FLIPPER_STATE, m_solenoidFlipper.get());
        m_table.putNumber(NETTABLE_CATCHER_SPINDLE_SCALE, m_spindleScale);
        m_tableListener = new ITableListener(){
            public void valueChanged(ITable table, String key, Object value, boolean isNew){
                if(key.equals(NETTABLE_CATCHER_CATCHER_STATE)){
                    m_solenoidCatcher.set(((Boolean)value).booleanValue());
                }else if(key.equals(NETTABLE_CATCHER_FLIPPER_STATE)){
                    m_solenoidFlipper.set(((Boolean)value).booleanValue());
                }else if(key.equals(NETTABLE_CATCHER_SPINDLE_SCALE)){
                    setSpindleScale(((Double)value).doubleValue());
                }
            }
        };
        
        m_table.addTableListener(m_tableListener, true);
    }
}
