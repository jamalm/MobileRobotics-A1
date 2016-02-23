import lejos.subsumption.Arbitrator;
import lejos.subsumption.Behaviour;

public class Assignment {
	
	public static void main(String [] args) {
		
		//set up behaviours
		Behaviour step1 = new Clap();
		Behaviour step2 = new LightDetect();
		Behaviour step3 = new SonarDetect();
		Behaviour step4 = new HitWall();
		
		//behaviour list
		Behaviour [] steps = {step4, step3, step2 ,step1};
		
		//arbitrator instance to run behaviours
		Arbitrator control = new Arbitrator(steps);
		control.start();
	}
}
