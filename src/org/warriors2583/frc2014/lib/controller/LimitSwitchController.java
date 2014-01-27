package org.warriors2583.frc2014.lib.controller;

import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.parsing.IDeviceController;
import org.warriors2583.frc2014.lib.limitswitch.ILimitSwitchSystem;

/**
 *
 * @author Austin Reuland
 */
public class LimitSwitchController implements SpeedController, IDeviceController, PIDOutput {
	
	private final SpeedController motor;
	private final ILimitSwitchSystem switchSystem;
	
	public LimitSwitchController(SpeedController motor, ILimitSwitchSystem switchSystem){
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
}