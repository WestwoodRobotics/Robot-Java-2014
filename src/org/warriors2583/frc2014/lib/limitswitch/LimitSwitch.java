package org.warriors2583.frc2014.lib.limitswitch;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.livewindow.LiveWindowSendable;
import edu.wpi.first.wpilibj.parsing.IInputOutput;
import edu.wpi.first.wpilibj.tables.ITable;

/**
 *
 * @author Austin Reuland
 */
public class LimitSwitch implements IStandardSwitch, IInputOutput, LiveWindowSendable {
	
	public static class SwitchType{
		private final int type;
		private SwitchType(int type){
			this.type = type;
		}
		public int getType(){
			return type;
		}
		public boolean getValue(boolean value){
			return ((type == 1 && value) || (type == 2 && !value));
		}
		/**
		 * Normally Open Switch
		 */
		public static final SwitchType NO = new SwitchType(1);
		/**
		 * Normally Closed Switch
		 */
		public static final SwitchType NC = new SwitchType(2);
	}
	
	private DigitalInput limitSwitch;
	private SwitchType type;
	
	public LimitSwitch(int channel, SwitchType type){
		this(1, channel, type);
	}
	
	public LimitSwitch(int module, int channel, SwitchType type){
		limitSwitch = new DigitalInput(module, channel);
		this.type = type;
	}
	
	public boolean state() {
		return type.getValue(limitSwitch.get());
	}

	public int getChannel() {
		return limitSwitch.getChannel();
	}

	public SwitchType getType() {
		return type;
	}

	/**
     * {@inheritDoc}
     */
	public void updateTable() {
		limitSwitch.updateTable();
	}

	/**
     * {@inheritDoc}
     */
	public void startLiveWindowMode() {
		limitSwitch.startLiveWindowMode();
	}

	/**
     * {@inheritDoc}
     */
	public void stopLiveWindowMode() {
		limitSwitch.stopLiveWindowMode();
	}

	/**
     * {@inheritDoc}
     */
	public void initTable(ITable arg0) {
		limitSwitch.initTable(arg0);
	}

	/**
     * {@inheritDoc}
     */
	public ITable getTable() {
		return limitSwitch.getTable();
	}

	/**
     * {@inheritDoc}
     */
	public String getSmartDashboardType() {
		return limitSwitch.getSmartDashboardType();
	}

}
