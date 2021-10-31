package hu.me.iit.webalk.fourth.Impl;

public class BelsoEgesuMotor implements hu.me.iit.webalk.fourth.Motor {
	private final int urtartalom;
	private final int loero;
	
	public BelsoEgesuMotor(int urtartalom, int loero) {
		this.urtartalom = urtartalom;
		this.loero = loero;
	}
	
	public BelsoEgesuMotor() {
		this.urtartalom = 1000;
		this.loero = 50;
	}
	
	@Override
	public String toString() {
		return String.format("Motor űrtartalma: "+urtartalom+" lóereje: "+ loero);
	}

	
}
