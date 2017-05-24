package lab6ex3;

public class Table {
	private int missingResource;
	
	public Table(){
		this.missingResource = 0;
	}
	
	public synchronized void waitTurnAndSmoke(int resource) throws InterruptedException {
		while (missingResource != resource)
			wait();
		System.out.println("Smoker with resource " + resourceNo(resource) + " crafting a cigar");
		Thread.sleep(2000);
		this.missingResource = 0;
		notifyAll();
	}

	public synchronized void putResourcesAndWait(int missingResource) throws InterruptedException {
		while (this.missingResource != 0){
			wait();
		}
		this.missingResource = missingResource;
		System.out.println("Put the resources " + complementaryResources(missingResource) + " on the table.");
		Thread.sleep(1000);
		notifyAll();
	}
	
	private String resourceNo(int no){
		String res = "-1";
		switch (no){
			case 1: 
				res = "Tobacco";
				break;
			case 2: 
				res = "Vanilla";
				break;
			case 3: 
				res = "Matches";
				break;
		}
		return res;
	}
	
	private String complementaryResources(int no){
		String res = "-1";
		switch (no){
			case 1: 
				res = "Vanilla and Matches";
				break;
			case 2: 
				res = "Tobacco and Matches";
				break;
			case 3: 
				res = "Tobacco and Vanilla";
				break;
		}
		return res;
	}
}
