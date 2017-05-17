package lab7ex3;

import java.util.concurrent.Semaphore;

public class Plate {
	private final static int PLATE_CAPACITY = 8;
	private final static int PLATE_EMPTY = 0;
	private int bugsInPlate = 4;
	Semaphore mutex = new Semaphore(1, true);
	Semaphore food = new Semaphore(0, true);
	Semaphore space = new Semaphore(0, true);

	public void eat(int id) throws InterruptedException {
		mutex.acquire();
		if (bugsInPlate <= PLATE_EMPTY + 1) {
			mutex.release();
			food.acquire();
			mutex.acquire();
		}
		bugsInPlate--;
		System.out.println("Chick " + id + " eats a bug.\n\tBugs in plate: " + bugsInPlate);
		mutex.release();
		if (space.availablePermits() == 0)
			space.release();
	}

	public void goCatchBug() {
		System.out.println("One of the parents goes hunting");
	}

	public void comeBackAndPutBug() throws InterruptedException {
		mutex.acquire();
		System.out.println("One of the parents comes back ");
		if (bugsInPlate >= PLATE_CAPACITY - 1) {
			mutex.release();
			space.acquire();
			mutex.acquire();
		}
		bugsInPlate++;
		System.out.println("Parent puts bug in plate.\n\tBugs in plate: " + bugsInPlate);
		if (food.availablePermits() == 0 && bugsInPlate < 8)
			food.release();
		mutex.release();
	}

}
