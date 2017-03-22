package de.clearwave.challanger.eloator.domain;

import de.clearwave.challanger.eloator.domain.exceptions.NoValueForStringException;

public enum KNumber {
	STANDARD(20),
	TOPPLAYER(10),
	LESS30MATCHES(30),
	JOUTH(40);
	
	private double value;
	
	private KNumber(double value) {
		this.value = value;
	}

	public double getValue() {
		return value;
	}
	
	public KNumber valueOf(double n) {
		for (KNumber x : KNumber.values()) {
			if (n == x.getValue()) {
				return x;
			}
		}
		return null;
	}

	public double doubleValueOf(String n) throws NoValueForStringException {
		for (KNumber x : KNumber.values()) {
			if (n.equals(x.name())) {
				return x.getValue();
			}
		}
		throw new NoValueForStringException();
	}
}
