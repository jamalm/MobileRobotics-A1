import lejos.robotics.subsumption.*;
import lejos.nxt.*;

public class Assignment {
	
	public static void main(String [] args) {
		
		//set up behaviours
		Behavior step1 = new Clap();
		Behavior step2 = new LightDetect();
		Behavior step3 = new SonarDetect();
		Behavior step4 = new HitWall();
		
		//behaviour list
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
