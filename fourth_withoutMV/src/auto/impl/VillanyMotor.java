package auto.impl;

import auto.Motor;

public class VillanyMotor implements Motor{
	private final int teljesitmeny;
	private final int feszultseg;
	
	public VillanyMotor(int teljesitmeny, int feszultseg) {
		super();
		this.teljesitmeny = teljesitmeny;
		this.feszultseg = feszultseg;
	}

	@Override
	public String toString() {
		return "VillanyMotor [teljesitmeny=" + teljesitmeny + ", feszultseg=" + feszultseg + "]";
	}
	
	

}
