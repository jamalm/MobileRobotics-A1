import lejos.robotics.subsumption.*;

import lejos.nxt.*;
import lejos.robotics.navigation.DifferentialPilot;

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
		return sonar.getDistance() < 35;
	}

}
