package auto;

public class Main {

	public static void main(String[] args) {
		Motor motor16 = new auto.impl.BelsoEgesuMotor(1600, 180);
		
		Auto opelAstra = new Auto(get4kerek(), motor16, "Opel Astra");
		
		System.out.println(opelAstra);
		
	}
	
	private static Kerek[] get4kerek() {
		Kerek[] kerekek = new Kerek[4];
		for (int i = 0; i < kerekek.length; i++) {
			kerekek[i] = new auto.impl.Kerek("noname", 205, 15, 95);
		}
		
		return kerekek;
	}

}
