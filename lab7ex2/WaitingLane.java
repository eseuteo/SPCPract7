package lab7ex2;

import java.util.concurrent.Semaphore;

public class WaitingLane {
	int passengersInWaitingLane;
	Semaphore mutex;
	Semaphore startLap;
	Semaphore endLap;
	Semaphore enterCar;

	public WaitingLane() {
		passengersInWaitingLane = 0;
		mutex = new Semaphore(1, true);
		startLap = new Semaphore(0, true);
		endLap = new Semaphore(0, true);
		enterCar = new Semaphore(0, true);
	}

	public void startLap() throws InterruptedException {
		startLap.acquire();
		mutex.acquire();
		for (int i=0; i<RollerCoaster.CAR_CAPACITY; i++)
			enterCar.release();
		passengersInWaitingLane -= RollerCoaster.CAR_CAPACITY;
		System.out.println("Car started lap");
		mutex.release();
	}

	public void endLap() {
		System.out.println("Car finished lap");
		for (int i = 0; i < 8; i++)
			endLap.release();
	}

	public void enterWaitingLane(int id) throws InterruptedException {
		mutex.acquire();
		passengersInWaitingLane++;
		System.out.println("Passenger\t" + id + "\thas entered WL");
		if (passengersInWaitingLane >= 8)
			startLap.release();
		mutex.release();
		
		enterCar.acquire();
		System.out.println("Passenger\t" + id + "\thas entered car");
		endLap.acquire();
		System.out.println("Passenger\t" + id + "\thas exited car");
	}

}
