package de.clearwave.challanger.eloator.calculate;

import org.junit.Test;
import static org.junit.Assert.*;

import de.clearwave.challanger.eloator.domain.KNumber;
import de.clearwave.challanger.eloator.domain.WinningPoints;

public class ElonumberCalculatorTest {
	
	@Test
	public void testCalculation01() {
		
		double eloA = 2806;
		double eloB = 2577;
		
		double expectedResultA = 2798;
		
		double actualyResultA = ElonumberCalculator.calcElonumber(eloA, eloB, KNumber.TOPPLAYER, WinningPoints.DEFEAT);
		
		assertEquals(expectedResultA, actualyResultA,0);
	}
	
	@Test
	public void testCalculation02() {
		
		double eloA = 2806;
		double eloB = 2577;
		
		double expectedResultB = 2585;
		
		double actualyResultB = ElonumberCalculator.calcElonumber(eloB, eloA, KNumber.TOPPLAYER, WinningPoints.WIN);
		
		assertEquals(expectedResultB, actualyResultB,0);
	}
	
	@Test 
	public void testExpectedCalculation() {
		double eloA = 2806;
		double eloB = 2577;
		double expectedResultA = 0.789;
		
		double actualyResultA = ElonumberCalculator.calcExpected(eloA, eloB);
		assertEquals(expectedResultA, actualyResultA,0.001);
		
	}
	
}
