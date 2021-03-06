package edu.neumont.lab.battlebot;

import lejos.nxt.LightSensor;
import lejos.nxt.SensorPort;

public class LineDetector {
	private LightSensor lineDetector;
	private final int LINE_VALUE = 45;
	
	public LineDetector() {
		lineDetector = new LightSensor(SensorPort.S2);
	}
	
	public boolean isLineDetected() {
		return (lineDetector.getLightValue() > LINE_VALUE);
	}
	
	public int getValue()
	{
		return lineDetector.getLightValue();
	}

}
