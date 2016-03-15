import lejos.robotics.subsumption.*;
import lejos.nxt.*;
/*
 * Assignment 1 for mobile robotics 
 * Implementing the Behavior API, allow the Arbitrator to carry out behaviors
 * depending on the conditions
 *
 * @author Jamal Mahmoud
 * @author Minni Hiltunen
 */
public class Assignment {
	
	public static void main(String [] args) {
		
		//initialise behaviors
		Behavior step1 = new Clap();
		Behavior step2 = new LightDetect();
		Behavior step3 = new SonarDetect();
		Behavior step4 = new HitWall();
		
		
		//behavior array that will be passed to the arbitrator class
		Behavior [] steps = {step1, step2, step3, step4};
		
		//arbitrator instance to run behaviours
		Arbitrator control = new Arbitrator(steps);
		
		//introduction
		LCD.drawString("Assignment 1",0,0);
		Button.waitForAnyPress();
		LCD.clear();
		
		//start behaviours
		control.start();
	}
}
