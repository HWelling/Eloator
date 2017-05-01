package de.clearwave.challanger.eloator.domain;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import de.clearwave.challanger.eloator.domain.exceptions.NoValueForStringException;

public class KNumberTest {
	@Test
	public void testDefaults() throws NoValueForStringException
	{
		assertThat(KNumber.doubleValueOf("JOUTH"), is(40.0));
		assertThat(KNumber.doubleValueOf("STANDARD"), is(20.0));
	}
}
