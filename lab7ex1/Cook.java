package lab7ex1;

public class Cook extends Thread {
	private Cauldron cauldron;

	public Cook(Cauldron cauldron) {
		this.cauldron = cauldron;
	}
	
	@Override
	public void run() {
		while (true){
			try {
				cauldron.sleepAndPrepare();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
