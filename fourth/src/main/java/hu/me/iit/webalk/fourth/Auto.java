package hu.me.iit.webalk.fourth;

public class Auto {
	private final Motor motor;
	private final Kerek[] kerekek;
	private final String tipus;
	
	public Auto(Motor motor, Kerek[] kerekek, String tipus) {
		this.motor = motor;
		this.kerekek = kerekek;
		this.tipus = tipus;
	}
	
	@Override
	public String toString() {
		return "Az autó típusa: "+tipus+
			 "\nAz autó motorja: "+motor.toString()+
			 "\nAz autó kereke: "+kerekek[0].toString();
	}
}
