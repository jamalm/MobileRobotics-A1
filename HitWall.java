import lejos.subsumption.Behavior;
import lejos.subsumption.Arbitrator;
import lejos.nxt.*;

import lejos.nxt.LCD;
import lejos.nxt.SensorPort;
import lejos.nxt.TouchSensor;

// Move forward until the touch sensor causes the robot to stop
// Print stop on screen

public class HitWall implements Behavior () {
	//fields
	
	
	//constructor 
	public HitWall(SensorPort port) {
		TouchSensor touch = new TouchSensor(SensorPort.S1);
		while (!touch.isPressed()) {
			
		}
	}
	
	//Methods
	public void action() {
		//implement actions here
		suppressed = false;
		
		//Stop and print "Stop" on the screen
		Motor.A.stop();
		Motor.B.stop();
		LCD.drawString("Stop");
	}
	
	public void suppress() {
		//implement suppression here
		suppressed = true;
	}
	
	public boolean takeControl() {
		return touch.isPressed();
	}

}
