
public class BlackOrWhite extends Robotabor{
	private static float cerna;
	private static float bila;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		init(Sensor.NONE, Sensor.NONE, Sensor.LIGHT, Sensor.NONE);
		light1.setFloodlight(true);
		getButton();

		nastaveniBarev();

		while(true){
			if(jsemNaCerne()){
				print("Cerna-" + cerna + "\n");
			}
			else{
				print("Bila-" + bila + "\n");
			}

			getButton();
		}
	}

	private static void nastaveniBarev() {
		// TODO Auto-generated method stub
		print("Mereni:\n Cerna: ");
		getButton();
		cerna = light1.getNormalizedLightValue();
		print(cerna + "\n");

		print(" Bila: ");
		getButton();
		bila = light1.getNormalizedLightValue();
		print(bila + "\n");
	}

	private static boolean jsemNaCerne() {
		// TODO Auto-generated method stub
		float rozdil = bila - cerna;
		return rozdil < 300;
	}
}
