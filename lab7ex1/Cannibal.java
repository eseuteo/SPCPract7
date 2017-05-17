package lab7ex1;

import java.util.Random;

public class Cannibal extends Thread {
	private static Random rng = new Random();
	private Cauldron cauldron;
	private int id;
	
	public Cannibal(Cauldron cauldron, int id){
		this.cauldron = cauldron;
		this.id = id;
	}
	
	@Override
	public void run() {
		while (true){
			try {
				sleep(rng.nextInt(1000));
				cauldron.eat(id);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
