import lejos.subsumption.Arbitrator;
import lejos.subsumption.Behavior;

public class Assignment {
	
	public static void main(String [] args) {
		
		//set up behaviours
		Behavior step1 = new Clap();
		Behavior step2 = new LightDetect();
		Behavior step3 = new SonarDetect();
		Behavior step4 = new HitWall();
		
		//behaviour list
		Behavior [] steps = {step4, step3, step2 ,step1};
		
		//arbitrator instance to run behaviours
		Arbitrator control = new Arbitrator(steps);
		control.start();
	}
}
