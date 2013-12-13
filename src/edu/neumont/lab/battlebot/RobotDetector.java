package edu.neumont.lab.battlebot;

import lejos.nxt.SensorPort;
import lejos.nxt.TouchSensor;
import lejos.nxt.UltrasonicSensor;

public class RobotDetector {
	private UltrasonicSensor sonicSensor;
	private TouchSensor leftSensor;
	private TouchSensor rightSensor;
	private final int MAX_DISTANCE = 40;

	
	
	public RobotDetector() {
		sonicSensor = new UltrasonicSensor(SensorPort.S1);
		leftSensor = new TouchSensor(SensorPort.S3);
		rightSensor = new TouchSensor(SensorPort.S4);

	}
	
	public boolean isRobotInPath() {
		return (sonicSensor.getDistance() < MAX_DISTANCE);
	}
	
	public boolean isLeftButtonPushed() {
		return leftSensor.isPressed();
	}
	
	public boolean isRightButtonPushed() {
		return rightSensor.isPressed();
	}
}
