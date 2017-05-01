package de.clearwave.challanger.eloator.domain;

import de.clearwave.challanger.eloator.domain.exceptions.NoValueForStringException;

public enum KNumber {
	STANDARD(20),
	TOPPLAYER(10),
	LESS30MATCHES(40),
	JOUTH(40);
	
	private double value;
	
	private KNumber(double value) {
		this.value = value;
	}

	public double getValue() {
		return value;
	}
	
	public static double doubleValueOf(String n) throws NoValueForStringException {
		for (KNumber x : KNumber.values()) {
			if (n.equals(x.name())) {
				return x.getValue();
			}
		}
		throw new NoValueForStringException();
	}
}
