package lab7ex1;

public class Party {
	final static int POPULATION = 15;

	public static void main(String[] args) {
		Cauldron cauldron = new Cauldron();
		Cook tribeCook = new Cook(cauldron);
		tribeCook.start();
		Cannibal[] tribeMembers = new Cannibal[POPULATION];
		for (int i = 0; i < POPULATION; i++){
			tribeMembers[i] = new Cannibal(cauldron, i);
			tribeMembers[i].start();
		}
	}
}
