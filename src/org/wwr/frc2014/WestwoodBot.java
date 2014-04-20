package org.wwr.frc2014;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.wwr.frc2014.auton.CG_OneBall;
import org.wwr.robolib.robot.AutonMode;
import org.wwr.robolib.robot.RoboLibBot;
import org.wwr.robolib.robot.TeleopMode;
import org.wwr.robolib.util.DSInfo;

/**
 * The main class for the robot.
 * It does the Top level stuff
 * 
 * @author Austin Reuland
 */
public class WestwoodBot extends RoboLibBot implements RMap {
    
    public WestwoodBot(){
        super("Fire Flower", "2.0.6");
    }

    OI oi = new OI();
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit(){
        enableWatchdog(true);
        compressor(DIO_COMPRESSOR, RELAY_COMPRESSOR);

        new AutonMode(){
            CommandGroup auton = new CG_OneBall();
            public void init() {auton.start();}
            public void run() {}
            public void end() {auton.cancel();}
        };
    }

}