package de.clearwave.challanger.eloator.calculate;

import static org.easymock.EasyMock.*;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import de.clearwave.challanger.eloator.domain.MatchResult;
import de.clearwave.challanger.eloator.domain.PlayerPerson;
import de.clearwave.challanger.eloator.service.ElonumberServiceImpl;
import de.clearwave.challanger.eloator.service.PlayerPersonService;

public class ElonumberServiceTest {
	
	private ElonumberServiceImpl service;
	private PlayerPersonService ppService;
	
	@Before
	public void setUp()
	{
		service = new ElonumberServiceImpl();
		ppService = createMock(PlayerPersonService.class);
	}
	
	@Test
	public void testCalculation()
	{
//		expect(ppService.getMatchcountFor(anyObject(PlayerPerson.class))).andReturn(0l).times(3);
//		replay(ppService);
		
		PlayerPerson a = new PlayerPerson("John", "Doe");
		a.setJouth(false);
		a.setEloNumber(2806);
		
		PlayerPerson b = new PlayerPerson("Foo", "Bar");
		b.setJouth(false);
		b.setEloNumber(2577);
		
		MatchResult result = service.getResult(a, b, 0, 1);
		
		assertEquals(2798, result.getEloPlayerOne());
		assertEquals(2585, result.getEloPlayerTwo());
		
//		verify(ppService);
	}
}
