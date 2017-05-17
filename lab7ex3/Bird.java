package lab7ex3;

import java.util.Random;

public class Bird extends Thread {
	private static Random rng = new Random();
	private Plate plate;

	public Bird(Plate plate) {
		this.plate = plate;
	}
	
	@Override
	public void run() {
		while (true){
			try {
				plate.goCatchBug();
				sleep(rng.nextInt(1000));
				plate.comeBackAndPutBug();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
