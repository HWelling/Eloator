package de.clearwave.challanger.eloator.service;

import static org.easymock.EasyMock.*;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.springframework.test.util.ReflectionTestUtils;

import de.clearwave.challanger.eloator.domain.MatchResult;
import de.clearwave.challanger.eloator.domain.PlayerPerson;
import de.clearwave.challanger.eloator.service.ElonumberServiceImpl;
import de.clearwave.challanger.eloator.service.PlayerPersonService;

public class ElonumberServiceTest {
	
	private ElonumberServiceImpl service;
	private PlayerPersonService ppService;
	
	private PlayerPerson a;
	private PlayerPerson b;
	
	@Before
	public void setUp()
	{
		service = new ElonumberServiceImpl();
		ppService = createMock(PlayerPersonService.class);
		ReflectionTestUtils.setField(service, "playerPersonService", ppService);
		
		a = new PlayerPerson("John", "Doe");
		a.setJouth(false);
		a.setEloNumber(2806);
		
		b = new PlayerPerson("Foo", "Bar");
		b.setJouth(false);
		b.setEloNumber(2577);
	}
	
	@Test
	public void testCalculationTopPlayer()
	{
		MatchResult result = service.getResult(a, b, 0, 1);
		
		assertEquals(2798, result.getEloPlayerOne());
		assertEquals(2585, result.getEloPlayerTwo());
	}
	
	@Test
	public void testCalculationNormal()
	{
		expect(ppService.getMatchcountFor(anyObject(PlayerPerson.class))).andReturn(31l).times(2);
		replay(ppService);
		
		MatchResult result = service.getResult(a, b, 0, 1);
		
		a.setEloNumber(2000);
		b.setEloNumber(1800);
		result = service.getResult(a, b, 0, 1);
		
		assertEquals(1985, result.getEloPlayerOne());
		assertEquals(1815, result.getEloPlayerTwo());
		
		verify(ppService);
	}
	
	@Test
	public void testCalculationLess30Matches()
	{
		reset(ppService);
		expect(ppService.getMatchcountFor(anyObject(PlayerPerson.class))).andReturn(0l).times(2);
		replay(ppService);
		
		MatchResult result = service.getResult(a, b, 0, 1);
		
		a.setEloNumber(2000);
		b.setEloNumber(1800);
		result = service.getResult(a, b, 0, 1);
		
		assertEquals(1970, result.getEloPlayerOne());
		assertEquals(1830, result.getEloPlayerTwo());
		verify(ppService);
	}
}
