import lejos.robotics.subsumption.*;
import lejos.nxt.*;
import lejos.robotics.navigation.DifferentialPilot;

import lejos.nxt.LCD;
import lejos.nxt.SensorPort;
import lejos.nxt.TouchSensor;



/*
 * Move forward until detecting a light surface underneath
 * 
 * @author Jamal Mahmoud - C13730921
 * @author Minni Hiltunen - D15123113
 */

public class LightDetect implements Behavior{

	//fields
	private boolean suppressed = false;
	private LightSensor light;
	private DifferentialPilot pilot;
	
	//constructor 
	public LightDetect() {
		light = new LightSensor(SensorPort.S3);
		pilot = new DifferentialPilot(2.25f ,5.5f, Motor.A, Motor.B);
	}
	
	//Methods
	public void action() {
		//implement actions here
		suppressed = false;
		
		//Stop
		pilot.stop();
		
		// Turn 90 degrees to the left
		pilot.rotate(-90);
		//move forward again
		pilot.forward();
		
		//wait to be suppressed
		while(!suppressed){
			Thread.yield();
		}
	}
	
	//suppress behavior
	public void suppress() {
		//implement suppression here
		suppressed = true;
	}
	
	//let behavior take control
	public boolean takeControl() {
		//return true if light units go over 45
		return light.getLightValue() > 45;
	}
}

