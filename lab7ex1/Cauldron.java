package lab7ex1;

import java.util.concurrent.Semaphore;

public class Cauldron {
	private static final int CAULDRON_CAPACITY = 5;
	private int plates = 0;
	Semaphore hut = new Semaphore(0, true);
	Semaphore mutex = new Semaphore(1, true);
	Semaphore firstCannibal = new Semaphore(0, true);
	Semaphore cauldron = new Semaphore(1, true);

	public void sleepAndPrepare() throws InterruptedException {
		hut.acquire();
		mutex.acquire();
		plates = CAULDRON_CAPACITY;
		reportFill();
		mutex.release();
		firstCannibal.release();
	}

	public void eat(int id) throws InterruptedException {
		cauldron.acquire();
		mutex.acquire();
		if (plates == 0){
			hut.release();
			mutex.release();
			firstCannibal.acquire();
			mutex.acquire();
		}
		plates--;
		reportUpdate(id);
		mutex.release();
		cauldron.release();
	}

	private void reportFill() {
		System.out.println("Cauldron filled");
	}

	private void reportUpdate(int id) {
		System.out.println("Plate served to Cannibal " + id + "\nCauldron content: " + plates);
	}
}
