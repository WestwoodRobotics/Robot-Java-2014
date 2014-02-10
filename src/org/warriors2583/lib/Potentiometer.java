package org.warriors2583.lib;

import edu.wpi.first.wpilibj.AnalogChannel;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.livewindow.LiveWindowSendable;
import edu.wpi.first.wpilibj.tables.ITable;

/**
 *
 * @author Austin Reuland
 */
public class Potentiometer implements PIDSource, LiveWindowSendable {
    
    private AnalogChannel pot;
    
    /**
     * 
     * @param channel Analog Channel of the Potentiometer
     * @param avgBits Number of Averaging Bits
     * @param ovrBits Number of Oversample Bits
     */
    public Potentiometer(int channel, int avgBits, int ovrBits){
        this(1, channel, avgBits, ovrBits);
    }
    
    /**
     * 
     * @param module Analog Module Number
     * @param channel Analog Channel of the Potentiometer
     * @param avgBits Number of Averaging Bits
     * @param ovrBits Number of Oversample Bits
     */ 
    public Potentiometer(int module, int channel, int avgBits, int ovrBits){
        pot = new AnalogChannel(module, channel);
        pot.setAverageBits(avgBits);
        pot.setOversampleBits(ovrBits);
    }

    /**
     * Get raw value
     * @return Potentiometer raw value
     */
    public int getValue() {return pot.getValue(); }
    
    /**
     * Get raw voltage
     * @return Potentiometer raw voltage
     */
    public double getVoltage() { return pot.getVoltage(); }
        
    private double lastRaw = 0;
    
    /**
     * Get an Averaged value from the pot
     * @return The average of the current and last values
     */
    public double getAverage(){
        lastRaw = (lastRaw + getVoltage())/2;
        return lastRaw;
    }
    
    public int getAverageBits() { return pot.getAverageBits(); }
    
    public int getOversampleBits() { return pot.getOversampleBits(); }
    
    public double pidGet() { return pot.pidGet(); }

    public void updateTable() { pot.updateTable(); }

    public void startLiveWindowMode() { pot.startLiveWindowMode(); }

    public void stopLiveWindowMode() { pot.stopLiveWindowMode(); }

    public void initTable(ITable arg0) { pot.initTable(arg0); }

    public ITable getTable() { return pot.getTable(); }

    public String getSmartDashboardType() { return pot.getSmartDashboardType(); }

}