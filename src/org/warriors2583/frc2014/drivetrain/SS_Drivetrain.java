package org.warriors2583.frc2014.drivetrain;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.warriors2583.frc2014.RMap;

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
            m_instance.setDefaultCommand(m_command);
            m_wheelSwitch.set(m_solenoid);
            m_driveMode = this;
            
            if(!inMode()){
                init();
            }
        }
        
        public static final DriveMode ARCADE = new DriveMode(1, false, new C_Arcade(), "Arcade Drive");
        public static final DriveMode TANK = new DriveMode(2, false, new C_Tank(), "Tank Drive");
        public static final DriveMode MECANUM = new DriveMode(3, true, new C_Mecanum(), "Mecanum Drive");
        public static final DriveMode MECATANK = new DriveMode(4, true, new C_Tank(), "MecaTank Drive");
    }
    
    private static DriveMode m_driveMode;
        
    private static final Talon m_motorFrontLeft, m_motorBackLeft, m_motorFrontRight, m_motorBackRight;
    
    //private static final Encoder m_encFL, m_encBL, m_encFR, m_encBR;
    
    private static final Solenoid m_wheelSwitch;
    
    private static final RobotDrive m_drive;
    
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
        
        m_wheelSwitch = new Solenoid(MODULE_SOLENOID_MAIN, SOLENOID_DRIVESWITCH);
        
        //Had to change Front and back of left side because the mecanum is stupid
        m_drive = new RobotDrive(m_motorBackLeft, m_motorFrontLeft, m_motorFrontRight, m_motorBackRight);
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
    
    public static void mecanum(double x, double y, double rot, double gyro){
        m_drive.mecanumDrive_Cartesian(x, y, rot, gyro);
    }
    
    public static void drive(double mag, double curve){
        m_drive.drive(mag, curve);
    }
    
    public static void PIDMove(double throt){
        m_drive.arcadeDrive(throt, 0.0);
    }
    
    public static void PIDrotate(double rot){
        m_drive.arcadeDrive(0.0, rot);
    }
    
    public static void setDriveMode(DriveMode mode){
        m_driveMode = mode;        
    }
    
    public static void resetDefaultCommand(Command commnand){
        m_instance.setDefaultCommand(commnand);   
    }
    
    public static void setSolenoid(boolean on){
        m_wheelSwitch.set(on);
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
        setDefaultCommand(new C_Arcade());
    }
}
