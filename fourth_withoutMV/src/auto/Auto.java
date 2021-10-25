package auto;

public class Auto {
	private final Kerek[] kerekek;
	private final Motor motor;
	private final String tipus;
	
	public Auto(Kerek kerekek[], Motor motor, String tipus) {
		this.kerekek = kerekek;
		this.motor = motor;
		this.tipus = tipus;
	}

	@Override
	public String toString() {
		return "Az aut� motorj�nak tulajdons�ga: {"+motor.toString()
				+"},\nkerek�nek tulajdons�ga: {"+kerekek[0].toString()
				+"}, \nt�pusa: "+ tipus;
	}
	
	
}
