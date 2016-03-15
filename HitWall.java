import lejos.robotics.subsumption.*;
import lejos.nxt.*;
import lejos.robotics.navigation.DifferentialPilot;

import lejos.nxt.LCD;
import lejos.nxt.SensorPort;
import lejos.nxt.TouchSensor;

/* 
 * Move forward until the touch sensor causes the robot to stop
 * Print stop
 * 
 * @author Jamal Mahmoud
 * @author Minni Hiltunen
 */

public class HitWall implements Behavior{

	//fields
	private boolean suppressed = false;
	private DifferentialPilot pilot;
	private TouchSensor touch;
	
	//constructor 
	public HitWall() {
		touch = new TouchSensor(SensorPort.S1);
		pilot = new DifferentialPilot(2.25f ,5.5f, Motor.A, Motor.B);
	}
	
	//Methods
	public void action() {
		//implement actions here
		suppressed = false;
		
		//Stop and print "Stop" on the screen
		pilot.stop();
		LCD.drawString("Stop",0,0);
		
		//waits to be suppressed
		while(!suppressed) {
			Thread.yield();
		}
	}
	
	//allows behavior to be suppressed
	public void suppress() {
		//implement suppression here
		suppressed = true;
	}

	
	//allows behavior to take control	
	public boolean takeControl() {
		//returns true if touch sensor is pressed
		return touch.isPressed();
	}

}
