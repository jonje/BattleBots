package edu.neumont.lab.battlebot;

import lejos.nxt.Button;

public class Battler {
	DriveSystem drive;
	LineDetector line;
	RobotDetector sensor;
	
	public Battler()
	{
		drive = new DriveSystem();
		line = new LineDetector();
		sensor = new RobotDetector();
	}
	
	public boolean lineOperations()
	{
		boolean lineFound = false;
		
		if(line.isLineDetected())
		{
			lineFound = true;
			drive.stop();
			drive.setMovingBackward();
			try {
				Thread.sleep(1500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			drive.stop();
		}
		
		return lineFound;
	}
	
	public void escapeOperations()
	{
		if(sensor.isLeftButtonPushed())
		{
			drive.setEscapeLeft();
		}
		else
		{
			drive.setEscapeRight();
		}
	}
	
	public boolean killOperations()
	{
		boolean isKilling = false;
		
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		isKilling = sensor.isRobotInPath();
		
		if(isKilling)
		{
			drive.setMovingForward();
			drive.goHighSpeed();
		}
		
		return isKilling;
	}
	
	public void runBattle()
	{
		drive.HidePerson();
		boolean waitingForLine = false;
		boolean turn = true;
		
		while(!Button.ENTER.isDown())
		{
			if(waitingForLine)
			{
				waitingForLine = (lineOperations())?false:true;
			}
			else if(sensor.isLeftButtonPushed() || sensor.isRightButtonPushed())
			{
				waitingForLine = true;
				escapeOperations();
			}
			else if(sensor.isRobotInPath())
			{
				drive.stop();
				turn = turn?false:true;
				waitingForLine = killOperations();
			}
			else
			{
				drive.goLowSpeed();
				if(turn)
					drive.setTurningRight();
				else
					drive.setTurningLeft();
			}
		}
	}
	
	public void testLineSystem()
	{
		System.out.println("LINE SYSTEM RAN");
	}
	
	public void testSensors()
	{
		System.out.println("SENSOR TESTS RAN");
	}
	
	public void testDriveSystem() throws InterruptedException
	{
		drive.stop();
		
		drive.HidePerson();
		Thread.sleep(250);
		
		drive.setMovingForward();
		Thread.sleep(1000);
		drive.stop();
		Thread.sleep(250);
		
		drive.setMovingBackward();
		Thread.sleep(1000);
		drive.stop();
		Thread.sleep(250);
		
		drive.setTurningRight();
		Thread.sleep(1000);
		drive.stop();
		Thread.sleep(250);
		
		drive.setTurningLeft();
		Thread.sleep(1000);
		drive.stop();
		Thread.sleep(250);
		
		drive.setEscapeRight();
		Thread.sleep(1000);
		drive.stop();
		Thread.sleep(250);
		
		drive.setEscapeLeft();
		Thread.sleep(1000);
		drive.stop();
		Thread.sleep(250);
		
	}
}
