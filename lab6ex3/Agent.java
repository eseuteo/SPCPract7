package lab6ex3;

import java.util.Random;

public class Agent extends Thread{
	private Table table;
	
	public Agent(Table table) {
		this.table = table;
	}
	
	public void run(){
		Random rng = new Random();
		while (true){
			try {
				table.putResourcesAndWait(rng.nextInt(3) + 1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
