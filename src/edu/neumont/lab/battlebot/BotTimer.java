package edu.neumont.lab.battlebot;

public class BotTimer extends Thread{
	private double time;
	private boolean running;

	public void run() {
		time = 0.0;
		running = true;
		
		while(running)
		{
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			time += 0.1;
		}
	}
	
	public double getTime()
	{
		return time;
	}
	
	public void stop()
	{
		running = false;
	}

}
