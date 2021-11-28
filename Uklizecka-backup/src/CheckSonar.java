
public class CheckSonar extends Robotabor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*init(Sensor.SONAR, Sensor.NONE, Sensor.NONE, Sensor.NONE);

		while(true){
			print(sonar.getDistance() + "\n");
			getButton();
		}*/
		
		init();
		initBuggy(56, 110);
		while(true){
			buggy.turn(-5);
		}
	}

}
