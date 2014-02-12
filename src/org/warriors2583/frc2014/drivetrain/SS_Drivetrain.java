package org.warriors2583.frc2014.drivetrain;

import com.sun.squawk.VM;
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
        private final int mode;
        private final boolean mecanum;
        private final Command command;
        private final String name;
        
        
        private DriveMode(int mode, boolean mecanum, Command command, String name){
            this.mode = mode;
            this.mecanum = mecanum;
            this.command = command;
            this.name = name;
        }
        public int getMode(){return mode;}
        public boolean getSolenoid(){return mecanum;}
        public Command getCommand(){return command;}
        public String toString(){return name;}
        
        public static final DriveMode ARCADE = new DriveMode(1, false, new C_Arcade(), "Arcade Drive");
        public static final DriveMode TANK = new DriveMode(2, false, new C_Tank(), "Tank Drive");
        public static final DriveMode MECANUM = new DriveMode(3, true, new C_Mecanum(), "Mecanum Drive");
    }
    
    private static boolean externalLock = false;
    private static int lockNum = 0;
    
    private static DriveMode driveMode;
        
    private static final Talon motor_front_left, motor_back_left, motor_front_right, motor_back_right;
    
    private static final Solenoid solenoid_wheelSwitch;
    
    private static final RobotDrive driveMain;
    
    private static final SS_Drivetrain instance = new SS_Drivetrain();

    public static SS_Drivetrain getInstance() {
        return instance;
    }

    static {
        
        driveMode = DriveMode.ARCADE;
        
        motor_front_left = new Talon(MODULE_DRIVE, DRIVE_FRONT_LEFT);
        motor_back_left = new Talon(MODULE_DRIVE, DRIVE_BACK_LEFT);
        motor_front_right = new Talon(MODULE_DRIVE, DRIVE_FRONT_RIGHT);
        motor_back_right = new Talon(MODULE_DRIVE, DRIVE_BACK_RIGHT);
        
        solenoid_wheelSwitch = new Solenoid(MODULE_SOLENOID_MAIN, SOLENOID_DRIVESWITCH);
        
        driveMain = new RobotDrive(motor_front_left, motor_back_left, motor_front_right, motor_back_right);
    }
    
    
    private SS_Drivetrain(){
        super("SS_Drivetrain");
    }
    
    
    public static void tank(double l, double r) {
        driveMain.tankDrive(l, r);
    }
    
    public static void arcade(double throt, double rot) {
        driveMain.arcadeDrive(throt, rot);
    }
    
    public static void mecanum(double x, double y, double rot, double gyro) {
        driveMain.mecanumDrive_Cartesian(x, y, rot, gyro);
    }
    
    public static void drive(double mag, double curve) {
        driveMain.drive(mag, curve);
    }
    
    public static void rotate(double rot) {
        driveMain.arcadeDrive(0.0, rot);
    }
    
    public static void setDriveMode(DriveMode mode){
        driveMode = mode;        
    }
    
    public static void resetDefaultCommand(Command commnand){
        instance.setDefaultCommand(commnand);   
    }
    
    public static void setSolenoid(boolean on){
        solenoid_wheelSwitch.set(on);
    }
    
    public static DriveMode getDriveMode(){
        return driveMode;
    }
    
    public static int takeLock(boolean force){
        if(!externalLock || force){
            lockNum = (int)VM.getTimeMillis();
            externalLock = true;
            return lockNum;
        }else{
            return -1;
        }
        
    }
    
    public static boolean releaseLock(int num){
        if(externalLock){
            if(num == lockNum){
                externalLock = false;
                lockNum = 0;
                return true;
            }else{
                return false;
            }
        }else{
            return false;
        }
    }
    
    public static void setExternalLock(boolean value) {
        externalLock = value;
    }
    
    public static boolean getExternLock() {
        return externalLock;
    }
    
    public static void makeSafe(){
        externalLock = true;
        driveMain.stopMotor();
        motor_front_left.disable();
        motor_front_left.free();
        
        motor_back_left.disable();
        motor_back_left.free();
        
        motor_front_right.disable();
        motor_front_right.free();
        
        motor_back_right.disable();
        motor_back_right.free();        
        
    }


    protected void initDefaultCommand() {
        setDefaultCommand(new C_Arcade());
    }
}