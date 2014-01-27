/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST 2008. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.warriors2583.frc2014;


import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Watchdog;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import org.warriors2583.frc2014.pneumatics.C_CompressorStart;
import org.warriors2583.frc2014.pneumatics.SS_Compressor;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class WestwoodBot extends IterativeRobot {

    OI oi = new OI();
	RasPi raspi = new RasPi();
	Command compressor = new C_CompressorStart();

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
        // instantiate the command used for the autonomous period
        Watchdog.getInstance().setEnabled(true);
        System.out.println("Robot Initiated");
        // Initialize all subsystems
    }

    public void autonomousInit(){
        System.gc();
        if(!SS_Compressor.isOn()) compressor.start();
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        // feed the user watchdog at every period when in autonomous
        Watchdog.getInstance().feed();
        Scheduler.getInstance().run();
    }

    /**
     * Called when the robot is first disabled
     */

    public void disabledInit(){
        compressor.cancel();
        System.gc();
    }

    /**
     * Called periodically during the disabled time based 
     * on a periodic timer for the class. 
     */

    public void disabledPeriodic() {
        // feed the user watchdog at every period when in autonomous
        Watchdog.getInstance().feed();
        Scheduler.getInstance().run();
    }

    /**
     * Called continuously while the robot is disabled. Each 
     * time the program returns from this function, it is 
     * immediately called again provided that the state 
     * hasn’t changed. 
     */
    public void disabledContinuous(){
        
    }

    public void teleopInit(){
        // This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to 
        // continue until interrupted by another command, remove
        // this line or comment it out.
        //autonomousCommand.cancel();
        if(!SS_Compressor.isOn()) compressor.start();
        System.gc();
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic(){
        // feed the user watchdog at every period when in autonomous
        Watchdog.getInstance().feed();
        
        Scheduler.getInstance().run();
    }
    
    public void testPeriodic(){
        Watchdog.getInstance().feed();
        LiveWindow.run();
        Scheduler.getInstance().run();
    }
}