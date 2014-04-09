package org.warriors2583.frc2014;

import org.warriors2583.lib.FRCBot;
import edu.wpi.first.wpilibj.command.CommandGroup;
import org.warriors2583.frc2014.auton.CG_OneBall;

/**
 * The main class for the robot.
 * It does the Top level stuff
 * 
 * @author Austin Reuland
 */
public class WestwoodBot extends FRCBot implements RMap {
    
    public WestwoodBot(){
        super("Fire Flower", "2.0.6");
    }

    OI oi = new OI();
    CommandGroup auton = new CG_OneBall();

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void init(){
        enableWatchdog(true);
        compressor(DIO_COMPRESSOR, RELAY_COMPRESSOR);
    }

    public void initAutonomous(){
        auton.start();
    }
}