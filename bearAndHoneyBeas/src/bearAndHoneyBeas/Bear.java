package bearAndHoneyBeas;

//This class represents a bear that sleeps and eats
//extends Thread
public class Bear extends Thread{

	@Override
	public void run() {
		goToSleep();	
	}

	//This method represents when the bear empties the pot 
	private void eatPot() {
		BearMain.pot = 0;
		System.out.println("Yummy!");
		System.out.println("bear ate the pot and now goes to sleep");
		System.out.println();
		BearMain.signalBear.release();
		goToSleep();
	}
	
	//this method represents when the bear sleeps
	private void goToSleep() {
		try {
			BearMain.signalBear.acquire();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		eatPot();
	}
	

}
