package edu.neumont.lab.battlebot;

import lejos.nxt.Button;

public class Battler {
	DriveSystem drive;
	LineDetector line;
	RobotDetector sensor;
	BotTimer timer = new BotTimer();
	boolean mustCheckTime, turning;
	double oldTime;
	
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
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		timer.start();
		
		drive.HidePerson();
		mustCheckTime = false;
		turning = false;
		boolean waitingForLine = false;
		boolean turn = true;
		
		while(!Button.ESCAPE.isDown())
		{
			if(waitingForLine)
			{
				waitingForLine = (lineOperations())?false:true;
			}
			else if(line.isLineDetected())
			{
				lineOperations();
			}
			else if(sensor.isLeftButtonPushed() || sensor.isRightButtonPushed())
			{
				escapeOperations();
			}
			else if(sensor.isRobotInPath())
			{
				drive.stop();
				turn = turn?false:true;
				waitingForLine = killOperations();
			}
			else if(!mustCheckTime)
			{
				oldTime = timer.getTime();
				drive.goLowSpeed();
				drive.setTurningRight();
				mustCheckTime = true;
				turning = true;
			}
			else if(turning && timer.getTime() > (2+oldTime))
			{
				drive.stop();
				drive.setMovingForward();
				turning = false;
			}
			else if(timer.getTime() > (3.5+oldTime))
			{
				drive.stop();
				mustCheckTime = false;
			}
		}
	}
	
	public void testLineSystem()
	{
		int oldValue = 0;
		
		while(!Button.ESCAPE.isDown())
		{
			int newValue = line.getValue();
			if(newValue != oldValue)
			{
				System.out.println(newValue);
				oldValue = newValue;
			}
		}
	}
	
	public void testSensors()
	{
		while(!Button.ESCAPE.isDown())
		{
			if(sensor.isRobotInPath())
			{
				System.out.println("ROBOT DETECTED");
			}
			if(sensor.isLeftButtonPushed())
			{
				System.out.println("LEFT ESCAPE DETECTED");
			}
			if(sensor.isRightButtonPushed())
			{
				System.out.println("RIGHT ESCAPE DETECTED");
			}
		}
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
