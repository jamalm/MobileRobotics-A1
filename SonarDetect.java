import lejos.robotics.subsumption.*;

import lejos.nxt.*;
import lejos.robotics.navigation.DifferentialPilot;

/*
 * Sonar detects a surface in front of it and follows a list of actions
 * 
 * @author Jamal Mahmoud - C13730921
 * @author Minni Hiltunen - D15123113
 */

public class SonarDetect implements Behavior{
	
	//fields
	private UltrasonicSensor sonar;
	private boolean suppressed = false;
	private DifferentialPilot pilot;
	
	//constructor 
	public SonarDetect() {
		sonar = new UltrasonicSensor(SensorPort.S4);
		pilot = new DifferentialPilot(2.25f ,5.5f, Motor.A, Motor.B);
	}

	//Methods
	
	public void action() {
		//implement actions here
		suppressed = false;
		
		
		//Stop and turn 180 degs
		pilot.stop();
		pilot.rotate(-180);
		
		//move forward 20 units and stop
		pilot.travel(20);
		pilot.stop();
		
		//turn 90 degs to the right 
		pilot.rotate(90);
		
		//move forward again
		pilot.forward();
		
		//wait to be suppressed
		while(!suppressed){
			Thread.yield();
		}
	}
	
	// allows behavior to be suppressed
	public void suppress() {
		//implement suppression here
		suppressed = true;
	}
	
	//Allows behavior to take control
	public boolean takeControl() {
		//returns true if object is less than 35 units distance from sonar
		return sonar.getDistance() < 35;
	}

}
