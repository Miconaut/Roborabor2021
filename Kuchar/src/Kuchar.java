
public class Kuchar extends Robotabor {

	private static int foodDiameter = 70; // check
	private static int firstFood; // measure
	private static int endUnload = 390; // check
	private static int plusDistanceBetween; // measure

	private static int angle = 45;
	private static int unLoadSpeed = 100;
	private static int getFoodSpeed = 30;
	private static int sleep = 5000;


	public static void main(String[] args) {
		// TODO Auto-generated method stub

		initialise();

		while(/*time <= 5min*/ true){
			go("backwards");
			goToUnload();
			unLoadFood();
			getFood();
			go("forward");
		}
	}

	private static void getFood(){
		buggy.speed(getFoodSpeed);

		for(int i = 0; i < 4; i++){
			for(int y = 0; y < 4; y++){
				buggy.go(firstFood);
				firstFood += plusDistanceBetween;
			}
			plusDistanceBetween += foodDiameter;
		}

		buggy.stop();
	}

	private static void unLoadFood(){
		motA.setSpeed(unLoadSpeed);
		motA.rotate(angle);
		sleepMilliseconds(sleep);
		motA.rotate(-angle);
	}

	private static void goToUnload(){
		buggy.speed(getFoodSpeed);
		buggy.go(endUnload);
	}

	private static void go(String orientation){
		if(orientation == "backward"){
			while(!touch1.isPressed()){
				buggy.backward();
			}
		}
		else if(orientation == "forward"){
			while(!touch2.isPressed()){
				buggy.forward();
			}
		}
		else{
			print("Posralas to, zkkontroluj si ty debilni stringy!!!");
			}

		buggy.stop();
		}

	private static void initialise(){
		init(Sensor.TOUCH, Sensor.TOUCH, Sensor.SONAR, Sensor.NONE); // CHECK!!!
		initBuggy(56, 110); //CHECK!!!
	}
}
