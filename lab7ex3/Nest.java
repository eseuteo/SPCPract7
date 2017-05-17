package lab7ex3;

public class Nest {
	static final int NUM_OF_CHICKS = 10;
	public static void main(String[] args) {
		Plate plate = new Plate();
		Bird mother = new Bird(plate);
		Bird father = new Bird(plate);
		mother.start();
		father.start();
		Chick[] chicks = new Chick[NUM_OF_CHICKS];
		for (int i=0; i<NUM_OF_CHICKS; i++){
			chicks[i] = new Chick(plate, i);
			chicks[i].start();
		}
	}
}
