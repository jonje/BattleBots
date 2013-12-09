package edu.neumont.lab.battlebot;

import lejos.nxt.Button;

public class BattleBot {

	public static void main(String[] args) throws InterruptedException {
		Thread.sleep(1000);
		if(!Button.ESCAPE.isDown())
		{
			DriveSystem drive = new DriveSystem();
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

}
