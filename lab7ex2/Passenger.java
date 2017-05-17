package lab7ex2;

import java.util.Random;

public class Passenger extends Thread {
	private static Random rng = new Random();
	private WaitingLane waitingLane;
	int id;

	public Passenger(WaitingLane waitingLane, int id) {
		this.waitingLane = waitingLane;
		this.id = id;
	}
	
	@Override
	public void run() {
		while (true)
			try {
				sleep(rng.nextInt(1000));
				waitingLane.enterWaitingLane(id);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
	}
}
