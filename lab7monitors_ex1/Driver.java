package lab7monitors_ex1;

public class Driver {
	public static void main(String[] args) {
		BankAccount account = new BankAccount(0);
		Client[] clients = new Client[10];
		boolean type;
		for (int i = 0; i<4; i++){
			type = i%2 == 0;
			clients[i] = new Client(account, i, type);
			clients[i].start();
		}
			
	}
}
