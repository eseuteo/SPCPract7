package lab7ex3;

import java.util.Random;

public class Chick extends Thread {
	private static Random rng = new Random();
	private Plate plate;
	private int id;

	public Chick(Plate plate, int id) {
		this.plate = plate;
		this.id = id;
	}
	
	@Override
	public void run() {
		while (true){
			try {
				sleep(rng.nextInt(5000));
				plate.eat(id);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
