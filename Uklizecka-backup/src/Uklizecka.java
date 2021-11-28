
public class Uklizecka extends Robotabor {

	private static int followingSpeed = 60;
	private static int cleanSpeed = 120;
	private static int cleanerSpeed = 50;
	private static int calibrateSpeed = 20;

	private static int cleanDistance = 15;
	private static int plateDistance = 390;

	private static int startTime;
	private static int stopTime = 295000;

	private static int time = 0; // 0=jedu, 1=prekazka, 2=konec

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		initialise();
		calibrateFollower();

		beep();
		getButton();

		checkSonar();

		beep();
		getButton();

		startTime = elapsedMilliseconds();

		while((elapsedMilliseconds() - startTime) < stopTime){
			if(time == 0){
				followLine();
			}
			else if(time == 1){
				cleaner(90);
				clean();
				cleaner(0);

				//buggy.turn(-10);
				buggy.go(-plateDistance/2);

				time = 0;
			}
			else if(time == 2){
				break;
			}
		}

		follower.stopFollowing();
		buggy.stop();
	}

	private static void clean(){
		if(elapsedMilliseconds() - startTime > (stopTime - 7000)) time = 2;
		else{
			buggy.speed(cleanSpeed);
			buggy.go(1*plateDistance/5);
			motA.flt(false);
			buggy.go(4*plateDistance/5);
			buggy.go(5);

			time = 0;
		}
	}

	private static void cleaner(int angle){
		if(elapsedMilliseconds() - startTime > (stopTime - 5000)) time = 2;
		else{
			//buggy.turn(10);
			buggy.go(10);
			motA.setSpeed(cleanerSpeed);
			motA.rotateTo(angle);
			beep();
		}
	}

	private static void followLine(){
		buggy.go(10);
		buggy.speed(followingSpeed);
		buggy.forward();
		follower.startFollowing(0.9f,0.1f,0.01f);

		while(sonar1.getDistance() > cleanDistance){
			follower.follow();

			if(sonar1.getDistance() > cleanDistance) time = 1;
			if(elapsedMilliseconds() - startTime > stopTime){
				time = 2;
				break;
			}
			else continue;
		}

		beep();

		follower.stopFollowing();
		buggy.go(15);
		buggy.stop();
	}

	private static void checkSonar(){ // this
		print("Check sonar:\n");
		getButton();

		for(int i = 0; i < 6; i++){
			if(sonar1.getDistance() > 10){
				beep();
				print("GOOD.\n");// this
			}
			else print("NO SONAR!!!\n");
		}

		print("Let's go!");
	}

	private static void calibrateFollower(){
		print("Calibrate follower.\n");
		getButton();
		buggy.speed(calibrateSpeed);

		follower.calibrateBuggy(60);
	}

	private static void initialise(){
		init(Sensor.SONAR, Sensor.LIGHT, Sensor.NONE, Sensor.NONE);
		initBuggy(85, 165);
		light1.setFloodlight(true);

		initFollower(light1);
	}

}
