package auto.impl;

public class Kerek implements auto.Kerek {
	private final String tipus;
	private final int szelesseg;
	private final int atmero;
	private final int kopenyMagassag;
	
	public Kerek(String tipus, int szelesseg, int atmero, int kopenyMagassag) {
		super();
		this.tipus = tipus;
		this.szelesseg = szelesseg;
		this.atmero = atmero;
		this.kopenyMagassag = kopenyMagassag;
	}

	public String getTipus() {
		return tipus;
	}

	public int getSzelesseg() {
		return szelesseg;
	}

	@Override
	public String toString() {
		return String.format("Kerék típusa: "+tipus+", adatai: "+szelesseg+
				"/"+atmero+" R "+ kopenyMagassag);
	}

	
}
