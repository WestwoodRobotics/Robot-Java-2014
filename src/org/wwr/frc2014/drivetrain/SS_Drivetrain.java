package org.wwr.frc2014.drivetrain;

//import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.tables.ITable;
import edu.wpi.first.wpilibj.tables.ITableListener;
import org.wwr.frc2014.RMap;

/**
 * Drivetrain Class. Controls the Drivetrain Sub-System
 * @author Austin Reuland
 */
public class SS_Drivetrain extends Subsystem implements RMap {
    
    /**
     * DriveMode Class
     * Used to determine the type of driving we are doing
     */
    public static class DriveMode{
        private final int m_mode;
        private final boolean m_solenoid;
        private final Command m_command;
        private final String m_name;
        
        private DriveMode(int mode, boolean mecanum, Command command, String name){
            this.m_mode = mode;
            this.m_solenoid = mecanum;
            this.m_command = command;
            this.m_name = name;
        }
        
        public int getMode(){return m_mode;}
        public boolean getSolenoid(){return m_solenoid;}
        public Command getCommand(){return m_command;}
        public String toString(){return m_name;}
        
        public boolean inMode(){
            boolean yes = true;
            yes = (m_instance.getDefaultCommand() == m_command ? yes : false);
            yes = (m_wheelSwitch.get() == m_solenoid ? yes : false);
            yes = (m_driveMode == this ? yes : false);
            return yes;
        }
        
        public void init(){
            resetDefaultCommand(m_command);
            setSolenoid(m_solenoid);
            setDriveMode(this);
        }
        
        public static final DriveMode ARCADE = new DriveMode(1, false, new C_Arcade(), "Arcade Drive");
        public static final DriveMode TANK = new DriveMode(2, false, new C_Tank(), "Tank Drive");
        public static final DriveMode MECANUM = new DriveMode(3, true, new C_Mecanum(), "Mecanum Drive");
        public static final DriveMode MECATANK = new DriveMode(4, true, new C_Tank(), "MecaTank Drive");
    }
    
    private static DriveMode m_driveMode;
    
    private static double m_scale = 1.0;
        
    private static final Talon m_motorFrontLeft, m_motorBackLeft, m_motorFrontRight, m_motorBackRight;
    
    //private static final Encoder m_encFL, m_encBL, m_encFR, m_encBR;
    
    private static final Solenoid m_wheelSwitch;
    
    private static final RobotDrive m_drive;
    
    private static final ITable m_table;
    
    private static ITableListener m_tableListener;
    
    private static final SS_Drivetrain m_instance = new SS_Drivetrain();

    public static SS_Drivetrain getInstance(){
        return m_instance;
    }

    static {
        
        m_motorFrontLeft = new Talon(MODULE_DRIVE, DRIVE_FRONT_LEFT);
        //m_encFL = new Encoder(4, 5);
        m_motorBackLeft = new Talon(MODULE_DRIVE, DRIVE_BACK_LEFT);
        //m_encBL = new Encoder(6, 7);
        m_motorFrontRight = new Talon(MODULE_DRIVE, DRIVE_FRONT_RIGHT);
        //m_encFR = new Encoder(8, 9);
        m_motorBackRight = new Talon(MODULE_DRIVE, DRIVE_BACK_RIGHT);
        //m_encBR = new Encoder(10, 11);
        
        m_driveMode = DriveMode.ARCADE;
        
        m_wheelSwitch = new Solenoid(MODULE_SOLENOID_MAIN, SOLENOID_DRIVESWITCH);
        
        m_drive = new RobotDrive(m_motorFrontLeft, m_motorBackLeft, m_motorFrontRight, m_motorBackRight);
        
        m_table = roboTable.getSubTable(NETTABLE_DRIVETRAIN);

        initDriveTable();
    }

    private SS_Drivetrain(){
        super("SS_Drivetrain");
    }
    
    public static void arcade(double throt, double rot){
        m_drive.arcadeDrive(throt, rot);
    }
    
    public static void tank(double l, double r){
        m_drive.tankDrive(l, r);
    }
    
    public static void mecanum(double x, double rot, double y, double gyro){
        m_drive.mecanumDrive_Cartesian(x, y, rot, gyro);
    }
    
    public static void drive(double mag, double curve){
        m_drive.drive(mag, curve);
    }
    
    public static void PIDMove(double throt){
        m_drive.arcadeDrive(-throt, 0.0);
    }
    
    public static void PIDrotate(double rot){
        m_drive.arcadeDrive(0.0, rot);
    }
    
    /*public static void feedDrive(){
        m_drive.feedSafety();
    }*/
    
    public static void setMotors(double values[]){
        setMotors(values[0], values[1], values[2], values[3]);
    }

    public static void setMotors(double frontLeft, double backLeft, double frontRight, double backRight){
        m_motorFrontLeft.set(frontLeft);
        m_motorBackLeft.set(frontLeft);
        m_motorFrontRight.set(frontLeft);
        m_motorBackRight.set(frontLeft);
    }
    
    public static void setDriveMode(DriveMode mode){
        m_driveMode = mode;
        m_table.putNumber("drivemode", m_driveMode.getMode());
        m_table.putString("drivemode_string", m_driveMode.toString());
    }
    
    public static void resetDefaultCommand(Command commnand){
        m_instance.setDefaultCommand(commnand);
        m_table.putString("default_cmd", m_instance.getDefaultCommand().getName());
    }
    
    public static void setSolenoid(boolean on){
        m_wheelSwitch.set(on);
        m_table.putBoolean("solenoid", on);
    }
    
    public static DriveMode getDriveMode(){
        return m_driveMode;
    }
    
    public static void makeSafe(){
        m_drive.stopMotor();
        m_motorFrontLeft.disable();
        m_motorFrontLeft.free();
        
        m_motorBackLeft.disable();
        m_motorBackLeft.free();
        
        m_motorFrontRight.disable();
        m_motorFrontRight.free();
        
        m_motorBackRight.disable();
        m_motorBackRight.free();        
        
    }

    protected void initDefaultCommand(){
        setDefaultCommand(m_driveMode.getCommand());
    }
    
    private static void initDriveTable(){
        m_table.putNumber(NETTABLE_DRIVETRAIN_DRIVEMODE, DriveMode.ARCADE.getMode());
        m_table.putString(NETTABLE_DRIVETRAIN_DRIVEMODE_STRING, DriveMode.ARCADE.toString());
        m_table.putBoolean(NETTABLE_DRIVETRAIN_SOLENOID, DriveMode.ARCADE.getSolenoid());
        m_table.putString(NETTABLE_DRIVETRAIN_DEFAULT_COMMAND, DriveMode.ARCADE.getCommand().getName());
        m_table.putNumber(NETTABLE_DRIVETRAIN_SCALE, m_scale);
        m_tableListener = new ITableListener(){
            public void valueChanged(ITable table, String key, Object value, boolean isNew){
                if(key.equalsIgnoreCase(NETTABLE_DRIVETRAIN_DRIVEMODE)){
                    new C_ChangeDrivemode(table.getNumber(NETTABLE_DRIVETRAIN_DRIVEMODE)).start();
                }else if(key.equals(NETTABLE_DRIVETRAIN_SCALE)){
                    m_scale = table.getNumber(NETTABLE_DRIVETRAIN_SCALE);
                }
            }
        };
        
        m_table.addTableListener(m_tableListener, true);
    }
}
