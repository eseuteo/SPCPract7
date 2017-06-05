package lab7monitors_ex1;

import java.util.Random;

public class Client extends Thread {
	static Random rng = new Random();
	private BankAccount ac;
	private int id;
	boolean type;

	public Client(BankAccount ac, int i, boolean type) {
		this.ac = ac;
		this.id = i;
		this.type = type;
	}

	public void run() {
		while (true) {
			int amount = rng.nextInt(100);
			try {
				sleep(rng.nextInt(1000));
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}

			if (type)
				ac.deposit(amount, id);
			else
				try {
					ac.withdraw(amount, id);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
		}
	}
}
