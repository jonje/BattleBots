package edu.neumont.lab.battlebot;

import lejos.nxt.Motor;

public class DriveSystem {
	
	public DriveSystem()
	{
		//initialize
		Motor.C.forward();
	}
	
	public void goHighSpeed()
	{
		Motor.A.setSpeed(500);
		Motor.B.setSpeed(500);
	}
	public void goNormalSpeed()
	{
		Motor.A.setSpeed(360);
		Motor.B.setSpeed(360);
	}
	public void goLowSpeed()
	{
		Motor.A.setSpeed(200);
		Motor.B.setSpeed(200);
	}
	
	public void setMovingForward()
	{
		Motor.A.forward();
		Motor.B.forward();
	}
	
	public void setMovingBackward()
	{
		Motor.A.backward();
		Motor.B.backward();
	}
	
	public void stop()
	{
		Motor.A.setSpeed(360);
		Motor.B.setSpeed(360);
		Motor.A.stop();
		Motor.B.stop();
	}
	
	public void setTurningRight()
	{
		Motor.A.forward();
		Motor.B.backward();
	}
	
	public void setTurningLeft()
	{
		Motor.B.forward();
		Motor.A.backward();
	}
	
	public void setEscapeRight()
	{
		Motor.A.setSpeed(500);
		Motor.A.forward();
		Motor.B.forward();
	}
	
	public void setEscapeLeft()
	{
		Motor.B.setSpeed(500);
		Motor.B.forward();
		Motor.A.forward();
	}
}
