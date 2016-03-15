import lejos.robotics.subsumption.*;
import lejos.nxt.*;
import lejos.robotics.navigation.DifferentialPilot;

import lejos.nxt.LCD;
import lejos.nxt.SensorPort;
import lejos.nxt.SoundSensor;

/*
 * Behavior class to listen for a clap and then move forward 
 * 
 * @author Jamal Mahmoud - C13730921
 * @author Minni Hiltunen - D15123113
 */


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

	//called after behavior takes control
	public void action() {
		//implement actions here
		suppressed = false;
		
		//move forward
		pilot.forward();
		
		//waits to be suppressed
		while(!suppressed){
			Thread.yield();
		}
	}
	
	//used to suppress the action/behavior
	public void suppress() {
		//implement suppression here
		suppressed = true;
	}
	
	//method to take control of the robot
	public boolean takeControl() {
		//if sound units go over 60, takes control
		return sound.readValue() > 60;
	}

}
