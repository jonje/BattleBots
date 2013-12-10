package edu.neumont.lab.battlebot;

import lejos.nxt.Button;
import lejos.util.TextMenu;

public class BattleBot {
	private static Battler bot;
	private static String[] options = {"Battle!","Test Drive","Test Line","Test Sensors","QUIT"};

	public static void main(String[] args) throws InterruptedException {
		Thread.sleep(3000);
		boolean done = false;
		
		if(!Button.ENTER.isDown())
		{
			bot = new Battler();
			TextMenu menu = new TextMenu(options);
			while(!done)
			{
				switch(menu.select())
				{
				case(0):
					bot.runBattle();
				break;
				case(1):
					bot.testDriveSystem();
				break;
				case(2):
					bot.testLineSystem();
				break;
				case(3):
					bot.testSensors();
				break;
				case(4):
					System.out.println("Goodbye!");
					done = true;
				break;
				default:
					System.out.println("ERROR: INVALID SELECTION");
				}
			}
		}
	}
}
