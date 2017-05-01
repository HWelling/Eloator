package de.clearwave.challanger.eloator.calculate;

import de.clearwave.challanger.eloator.domain.KNumber;
import de.clearwave.challanger.eloator.domain.WinningPoints;

public class ElonumberCalculator {
	
	public static long calcElonumber(double eloA, double eloB, KNumber k,
			WinningPoints w) {

		double a = w.getValue() - calcExpected(eloA, eloB);
		double d = k.getValue() * a;
		double newEloA = eloA + d;

		return Math.round(newEloA);
	}

	public static double calcExpected(double eloA, double eloB) {

		double diff = eloB - eloA;
		
		if(diff > 400)
		{
			diff = 400;
		} else if(diff < -400)
		{
			diff = -400;
		}
		
		double x = Math.pow(10, diff / 400);
		double expA = 1 / (1 + x);

		return expA;
	}

}
