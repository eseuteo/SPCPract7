package lab7monitors_ex1;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankAccount {
	private int balance;
	private Lock l = new ReentrantLock(true);
	private Condition room = l.newCondition();

	public BankAccount(int initialAmount) {
		balance = initialAmount;
	}

	public void deposit(int amount, int id) {
		try {
			l.lock();
			balance += amount;
			System.out.println("Client " + id + " deposits " + amount + "\nBalance: " + balance);
			room.signalAll();
		} finally {
			l.unlock();
		}
	}

	public void withdraw(int amount, int id) throws InterruptedException {
		try {
			l.lock();
			while (balance < amount) {
				System.out.println("Client " + id + " waits for " + amount + "\nBalance: " + balance);
				room.await();
			}
			balance -= amount;
			System.out.println("Client " + id + " withdraws " + amount + "\nBalance: " + balance);
		} finally {
			l.unlock();
		}
	}
}
