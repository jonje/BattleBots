package edu.neumont.lab.battlebot;

public class Battler {
	DriveSystem drive;
	LineDetector line;
	
	public Battler()
	{
		drive = new DriveSystem();
		line = new LineDetector();
	}
	
	public void runBattle()
	{
		System.out.println("RUN BATTLE RAN");
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
		System.out.println("DRIVE TESTS RAN");
		/*
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
		*/
	}
}
