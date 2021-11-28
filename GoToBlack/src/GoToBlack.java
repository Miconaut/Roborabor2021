
public class GoToBlack extends Robotabor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		init(Sensor.NONE, Sensor.NONE, Sensor.LIGHT, Sensor.NONE);
		initBuggy(56, 110);

		buggy.speed(100);

		getButton();
		dojedKCerne();
	}

	private static void dojedKCerne() {
		// TODO Auto-generated method stub
		light1.setFloodlight(true);

		buggy.forward();
		while (jsemNaBile());
		buggy.stop();
	}

	private static boolean jsemNaBile() {
		// TODO Auto-generated method stub
		int svetlo = light1.getNormalizedLightValue();
		return svetlo > 400;
	}

}
