import lejos.robotics.subsumption.*;
import lejos.nxt.*;
import lejos.robotics.navigation.DifferentialPilot;

import lejos.nxt.LCD;
import lejos.nxt.SensorPort;
import lejos.nxt.SoundSensor;

// wait for clap and print clap
// Move forward


public class Clap implements Behavior{
	//fields
	private boolean suppressed = false;
	private DifferentialPilot pilot;
	private SoundSensor sound;
	
	//constructor 
	public Clap() {
		sound = new SoundSensor(SensorPort.S2);
		pilot = new DifferentialPilot(2.25f ,5.5f, Motor.A, Motor.B);
	}

	
	//Methods
	public void action() {
		//implement actions here
		suppressed = false;
		
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
		return sound.readValue() > 60;
	}

}