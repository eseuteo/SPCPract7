package lab7ex2;

import java.util.Random;

public class Car extends Thread {
	private WaitingLane waitingLane;

	public Car(WaitingLane waitingLane) {
		this.waitingLane = waitingLane;
	}
	
	@Override
	public void run() {
		Random rng = new Random();
		while (true)
			try {
				waitingLane.startLap();
				sleep(rng.nextInt(5000));
				waitingLane.endLap();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	}
}
