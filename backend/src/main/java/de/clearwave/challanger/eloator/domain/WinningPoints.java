package de.clearwave.challanger.eloator.domain;

import de.clearwave.challanger.eloator.domain.exceptions.NoValueForStringException;

public enum WinningPoints {
	WIN(1), DEFEAT(0), DRAW(0.5);

	private double value;

	WinningPoints(double value) {
		this.value = value;
	}

	public double getValue() {
		return value;
	}

	public WinningPoints valueOf(double n) {
		for (WinningPoints x : WinningPoints.values()) {
			if (n == x.getValue()) {
				return x;
			}
		}
		return null;
	}

	public double doubleValueOf(String n) throws NoValueForStringException {
		for (WinningPoints x : WinningPoints.values()) {
			if (n.equals(x.name())) {
				return x.getValue();
			}
		}
		throw new NoValueForStringException();
	}
}
