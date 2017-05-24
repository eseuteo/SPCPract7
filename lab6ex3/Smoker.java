package lab6ex3;

public class Smoker extends Thread{
	private int resource;
	private Table table;
	
	public Smoker(int resource, Table table) {
		this.resource = resource;
		this.table = table;
	}
	
	public void run(){
		while (true){
			try {
				table.waitTurnAndSmoke(resource);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
