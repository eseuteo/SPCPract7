package lab6ex3;

public class Driver {
	public static void main(String[] args) {
		Table table = new Table();
		Agent agent = new Agent(table);
		Smoker smoker1 = new Smoker(1, table);
		Smoker smoker2 = new Smoker(2, table);
		Smoker smoker3 = new Smoker(3, table);
		agent.start();
		smoker1.start();
		smoker2.start();
		smoker3.start();
	}
}
