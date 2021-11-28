
public class Fractal extends Robotabor{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		init();
		initBuggy(56, 110);
		buggy.speed(400);
		buggy.acceleration(20);
		getButton();
		jedFraktal();
	}

	private static void jedFraktal() {
		// TODO Auto-generated method stub
		for(int i = 0; i < 4; i++){
			jedHranu(200, 90);
			malyCtverec();
		}
	}

	private static void malyCtverec() {
		// TODO Auto-generated method stub
		for(int i = 0; i < 4; i++){
			jedHranu(50, -90);
		}
	}

	private static void jedHranu(int go, int turn) {
		// TODO Auto-generated method stub
		buggy.go(go);
		buggy.turn(turn);
	}

}
