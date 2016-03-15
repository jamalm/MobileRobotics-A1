import lejos.robotics.subsumption.*;
import lejos.nxt.*;
import lejos.robotics.navigation.DifferentialPilot;

import lejos.nxt.LCD;
import lejos.nxt.SensorPort;
import lejos.nxt.TouchSensor;

// Move forward until detecting a light surface underneath


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
	
	public LightDetect(String test){
		testValue();
	}
	
	//Methods
	public void action() {
		//implement actions here
		suppressed = false;
		
		//Stop
		pilot.stop();
		
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
		return light.getLightValue() > 45;
	}
}

