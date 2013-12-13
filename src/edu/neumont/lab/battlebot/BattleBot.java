package edu.neumont.lab.battlebot;

import lejos.nxt.LCD;
import lejos.util.TextMenu;

public class BattleBot {
	private static Battler bot;
	private static String[] options = {"Battle!","Test Drive","Test Line","Test Sensors","QUIT"};

	public static void main(String[] args) throws InterruptedException {

		bot = new Battler();
		TextMenu menu = new TextMenu(options);

		switch(menu.select())
		{
		case(0):
			LCD.clearDisplay();
			bot.runBattle();
		break;
		case(1):
			LCD.clearDisplay();
			bot.testDriveSystem();
		break;
		case(2):
			LCD.clearDisplay();
			bot.testLineSystem();
		break;
		case(3):
			LCD.clearDisplay();
			bot.testSensors();
		break;
		case(4):
			LCD.clearDisplay();
			System.out.println("Goodbye!");
		break;
		default:
			System.out.println("ERROR: INVALID SELECTION");
		}
	}
}