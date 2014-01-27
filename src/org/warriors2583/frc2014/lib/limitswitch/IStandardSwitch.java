package org.warriors2583.frc2014.lib.limitswitch;

import org.warriors2583.frc2014.lib.limitswitch.LimitSwitch.SwitchType;

/**
 *
 * @author Austin Reuland
 */
public interface IStandardSwitch {
	
	public boolean state();
	
	public int getChannel();
	
	public SwitchType getType();
}
