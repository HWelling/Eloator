package de.clearwave.challanger.eloator.domain;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import de.clearwave.challanger.eloator.domain.exceptions.NoValueForStringException;

public class WinningPointsTest {

	@Test
	public void testDefaults() throws NoValueForStringException
	{
		assertThat(WinningPoints.doubleValueOf("WIN"), is(1.0));
		assertThat(WinningPoints.doubleValueOf("DEFEAT"), is(0.0));
	}
}
