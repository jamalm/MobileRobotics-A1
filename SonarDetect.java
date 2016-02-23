import lejos.subsumption.Behavior;
import lejos.subsumption.Arbitrator;
import lejos.nxt.*;
import lejos.robotics.navigation.DifferentialPilot;

public class SonarDetect implements Behavior () {
	//fields
	private UltrasonicSensor sonar;
	private boolean suppressed = false;
	private DifferentialPilot pilot;
	
	//constructor 
	public SonarDetect(SensorPort port) {
		sonar = new UltrasonicSensor(port);
	}
	
	//Methods
	
	public void action() {
		//implement actions here
		suppressed = false;
		
		//Stop and turn 180 degs
		Motor.A.stop();
		Motor.B.stop();
		Motor.A.rotate(-180, true);
		Motor.B.rotate(-180, true);
		
		//move forward 20 units and stop
		
	}
	
	public suppress() {
		//implement suppression here
		suppressed = true;
	}
	
	public takeControl() {
		return sonar.getDistance() < 25;
	}

}
