package bearAndHoneyBeas;

import java.util.concurrent.Semaphore;


public class BearMain {
	//Semaphore to signal bear when pot is full
	public static Semaphore signalBear = new Semaphore(0, true);
	//Used as lock for shared variables
	public static Semaphore lock = new Semaphore(1, true);
	public static int pot = 0;
	public static int max = 100;
	public static int honeybees = 1000;
	
	public static void main(String[] args) {
		Bear bear = new Bear();
		bear.start();
		for(int i = 1; i <= honeybees; i++){
			Honeybee bee = new Honeybee(i);
			bee.start();
		}

	}

}
