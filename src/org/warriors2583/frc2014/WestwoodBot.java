package org.warriors2583.frc2014;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.warriors2583.frc2014.auton.CG_OneBall;
import org.warriors2583.robolib.robot.Robot;
import org.warriors2583.robolib.robot.AutonMode;

/**
 * The main class for the robot.
 * It does the Top level stuff
 * 
 * @author Austin Reuland
 */
public class WestwoodBot extends Robot implements RMap {
    
    public WestwoodBot(){
        super("Fire Flower - 2014", "2.0.6");
        
        new AutonMode(){
            CommandGroup auton = new CG_OneBall();
            public void init() {auton.start();}
            public void run() {}
            public void end() {auton.cancel();}
        };
    }

    OI oi = new OI();
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit(){
        enableWatchdog(true);
        compressor(DIO_COMPRESSOR, RELAY_COMPRESSOR);
    }

}