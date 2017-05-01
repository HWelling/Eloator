package de.clearwave.challanger.eloator.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.clearwave.challanger.eloator.calculate.ElonumberCalculator;
import de.clearwave.challanger.eloator.domain.KNumber;
import de.clearwave.challanger.eloator.domain.MatchResult;
import de.clearwave.challanger.eloator.domain.PlayerPerson;
import de.clearwave.challanger.eloator.domain.WinningPoints;

@Service
public class ElonumberServiceImpl implements ElonumberService {
	
	@Autowired
	private PlayerPersonService playerPersonService;
	
	@Override
	public MatchResult getResult(PlayerPerson a, PlayerPerson b, long pointsA, long pointsB) 
	{
		MatchResult result = new MatchResult();
		
		WinningPoints wA = getWinningPoints(pointsA, pointsB);
		WinningPoints wB = getWinningPoints(pointsB, pointsA);
		
		long eloPlayerOne = ElonumberCalculator.calcElonumber(a.getEloNumber(), b.getEloNumber(), getK(a), wA);
		long eloPlayerTwo = ElonumberCalculator.calcElonumber(b.getEloNumber(), a.getEloNumber(), getK(b), wB);
		result.setEloPlayerOne(eloPlayerOne);
		result.setEloPlayerTwo(eloPlayerTwo);
		
		return result;
	}
	
	private WinningPoints getWinningPoints(long pointsA, long pointsB)
	{
		long diff = pointsA - pointsB;
		
		if(diff > 0)
		{
			return WinningPoints.WIN;
		} else if (diff < 0)
		{
			return WinningPoints.DEFEAT;
		} else 
		{
			return WinningPoints.DRAW;
		}
	}

	private KNumber getK(PlayerPerson player)
	{
		if(player.getEloNumber() > 2400)
		{
			return KNumber.TOPPLAYER;
		} 
		else if(player.isJouth())
		{
			return KNumber.JOUTH;
		}
		else if(playerPersonService.getMatchcountFor(player)<30)
		{
			return KNumber.LESS30MATCHES;
		}

		return KNumber.STANDARD;
	}
}
