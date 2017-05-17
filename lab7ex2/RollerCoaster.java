package lab7ex2;

public class RollerCoaster {
	static final int CAR_CAPACITY = 8;
	static final int NUM_PASSENGERS = 20;

	public static void main(String[] args) {
		WaitingLane waitingLane = new WaitingLane();
		Car car = new Car(waitingLane);
		car.start();
		Passenger[] passengers = new Passenger[NUM_PASSENGERS];
		for (int i=0; i<NUM_PASSENGERS; i++){
			passengers[i] = new Passenger(waitingLane, i);
			passengers[i].start();
		}
	}
}
