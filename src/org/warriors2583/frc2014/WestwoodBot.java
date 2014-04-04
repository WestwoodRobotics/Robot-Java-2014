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
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import java.io.IOException;
import org.warriors2583.frc2014.auton.CG_OneBall;
import org.warriors2583.frc2014.common.C_CompressorStart;

/**
 * The main class for the robot.
 * It does the Top level stuff
 * 
 * @author Austin Reuland
 */
public class WestwoodBot extends IterativeRobot {

    OI oi = new OI();
    RasPi raspi = new RasPi();
    Computer comp = new Computer();
    Command compressor = new C_CompressorStart();
    CommandGroup auton = new CG_OneBall();

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
        Watchdog.getInstance().setEnabled(true);
        
        compressor.start();
        System.out.println("Robot Initiated");
    }

    public void autonomousInit(){
        System.gc();
        compressor.start();
        auton.start();
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    /**
     * Called when the robot is first disabled
     */

    public void disabledInit(){
        System.gc();
    }

    /**
     * Called periodically during the disabled time based 
     * on a periodic timer for the class. 
     */

    public void disabledPeriodic() {
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
        System.gc();
        compressor.start();
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic(){
        Scheduler.getInstance().run();
    }
    
    public void testPeriodic(){
        LiveWindow.run();
        Scheduler.getInstance().run();
    }
}