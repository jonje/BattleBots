package edu.neumont.lab.battlebot;

import lejos.nxt.Button;

public class BattleBot {

	public static void main(String[] args) {
		LineDetector lineDetector = new LineDetector();
		while(!Button.ENTER.isDown()) {
			System.out.println(lineDetector.isLineDetected());
			
		}

	}

}
