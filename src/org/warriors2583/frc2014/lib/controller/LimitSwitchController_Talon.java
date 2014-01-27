package org.warriors2583.frc2014.lib.controller;

import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.livewindow.LiveWindowSendable;
import edu.wpi.first.wpilibj.parsing.IDeviceController;
import edu.wpi.first.wpilibj.tables.ITable;
import org.warriors2583.frc2014.lib.limitswitch.ILimitSwitchSystem;

/**
 *
 * @author Austin Reuland
 */
public class LimitSwitchController_Talon implements SpeedController, IDeviceController, PIDOutput, LiveWindowSendable {
	
	private final Talon motor;
	private final ILimitSwitchSystem switchSystem;
	
	public LimitSwitchController_Talon(Talon motor, ILimitSwitchSystem switchSystem){
		this.motor = motor;
		this.switchSystem = switchSystem;
	}

	public double get() {
		return motor.get();
	}

	private double speed = 0;

	public void set(double speed, byte syncGroup) {
		speed = speed > 0 && !switchSystem.canUp() ? 0.00 : speed;
		speed = speed < 0 && !switchSystem.canDown() ? 0.00 : speed;
		motor.set(speed, syncGroup);
		this.speed = speed;
	}

	public void set(double speed) {
		speed = speed > 0 && !switchSystem.canUp() ? 0.00 : speed;
		speed = speed < 0 && !switchSystem.canDown() ? 0.00 : speed;
		motor.set(speed);
		this.speed = speed;
	}
	
	public boolean atLimit(){
		if(speed >= 0 && !switchSystem.canUp()) return true;
		return speed < 0 && !switchSystem.canDown();
	}

	public void disable() {
		motor.disable();
	}

	public void pidWrite(double output) {
		motor.pidWrite(output);
	}

	public void updateTable() {
		motor.updateTable();
	}

	public void startLiveWindowMode() {
		motor.startLiveWindowMode();
	}

	public void stopLiveWindowMode() {
		motor.stopLiveWindowMode();
	}

	public void initTable(ITable arg0) {
		motor.initTable(arg0);
	}

	public ITable getTable() {
		return motor.getTable();
	}

	public String getSmartDashboardType() {
		return motor.getSmartDashboardType();
	}

}