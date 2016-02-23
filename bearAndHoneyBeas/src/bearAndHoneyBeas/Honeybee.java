package bearAndHoneyBeas;

//This class represents a honeybee
//Extends Thread
public class Honeybee extends Thread{
	int ID;

	//Constructor that gives an instance of a bee an ID
	public Honeybee(int i) {
		ID = i;
	}

	@Override
	public void run() {
		getHoney();
	}

	//An instance of a bee allways collects honey
	private void getHoney() {
		while(true){
			try {
				BearMain.lock.acquire();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//checks if it is ok to bring honey to the pot
			if(BearMain.pot==BearMain.max){
				System.out.println("waky waky");
				//signaling bear
				BearMain.signalBear.release();
				try {
					//waiting to get signal from bear that pot is empty again
					BearMain.signalBear.acquire();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//brings honey to pot
				BearMain.pot++;
				System.out.println("honeybee "+ID + " gathered one portion of honey");
				System.out.println("pot is filled with "+ BearMain.pot+ " portions");
				BearMain.lock.release();
			}
			else{
				//brings honey to pot
				BearMain.pot++;
				System.out.println("honeybee "+ID + " gathered one portion of honey");
				System.out.println("pot is filled with "+ BearMain.pot+ " portions");
				BearMain.lock.release();
			}
		}
		
	}


}
