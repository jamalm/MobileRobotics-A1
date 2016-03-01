import lejos.subsumption.Behavior;
import lejos.subsumption.Arbitrator;
import lejos.nxt.*;
import lejos.robotics.navigation.DifferentialPilot;

import lejos.nxt.LCD;
import lejos.nxt.SensorPort;
import lejos.nxt.TouchSensor;

// Move forward until detecting a light surface underneath


public class LightDetect implements Behavior () {
	//fields
	
	//constructor 
	public LightDetect(SensorPort port) {
		LightSensor light = new LightSensor(SensorPort.S1);
	}
	
	//Methods
	public void action() {
		//implement actions here
		suppressed = false;
		
		//Stop
		Motor.A.stop();
		Motor.B.stop();
		
		// Turn 90 degrees to the left
		pilot.rotate(-90);
		
		pilot.forward();
		
		while(!suppressed){
			Thread.yield();
		}
	}
	
	public void suppress() {
		//implement suppression here
		suppressed = true;
	}
	
	public boolean takeControl() {
		return light.getLightValue() > 45
	}

}
