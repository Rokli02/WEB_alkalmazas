package auto.impl;

import auto.Motor;

public class BelsoEgesuMotor implements Motor {
	private final int urtartalom;
	private final int loero;
	private final int motorSzam = 1;
	
	public BelsoEgesuMotor(int urtartalom, int loero) {
		this.urtartalom = urtartalom;
		this.loero = loero;
	}

	public int getUrtartalom() {
		return urtartalom;
	}

	public int getLoero() {
		return loero;
	}

	public int motorSzama() {
		return motorSzam;
	}

	@Override
	public String toString() {
		return String.format("Motor ûrtartalma: "+urtartalom+" és lóereje:"+ loero);
	}

	
}
