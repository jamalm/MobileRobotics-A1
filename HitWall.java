import lejos.robotics.subsumption.*;
import lejos.nxt.*;
import lejos.robotics.navigation.DifferentialPilot;

import lejos.nxt.LCD;
import lejos.nxt.SensorPort;
import lejos.nxt.TouchSensor;

// Move forward until the touch sensor causes the robot to stop
// Print stop on screen

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
		
		while(!suppressed) {
			Thread.yield();
		}
	}
	
	public void suppress() {
		//implement suppression here
		suppressed = true;
	}
	
	public boolean takeControl() {
		return touch.isPressed();
	}

}
