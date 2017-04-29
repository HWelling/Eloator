package de.clearwave.challanger.eloator.calculate;

import de.clearwave.challanger.eloator.domain.KNumber;
import de.clearwave.challanger.eloator.domain.WinningPoints;

public class ElonumberCalculator {
	
	// TODO: k für > 2400 => 10; weniger als 30 partien => 40; jugend => 40
	// TODO: elo -elo > 400 => 400 ; elo -elo < -400 => -400

	public static long calcElonumber(double eloA, double eloB, KNumber k,
			WinningPoints w) {

		double a = w.getValue() - calcExpected(eloA, eloB);
		double d = k.getValue() * a;
		double newEloA = eloA + d;

		return Math.round(newEloA);
	}

	public static double calcExpected(double eloA, double eloB) {

		double x = Math.pow(10, (eloB - eloA) / 400);
		double expA = 1 / (1 + x);

		return expA;
	}

}
