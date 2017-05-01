package de.clearwave.challanger.eloator.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import de.clearwave.challanger.eloator.domain.MatchResult;
import de.clearwave.challanger.eloator.domain.PlayerPerson;
import de.clearwave.challanger.eloator.service.ElonumberService;

@RestController
@CrossOrigin(origins = "*")
public class ElonumberControllerImpl implements ElonumberController {
	
	@Autowired
	private ElonumberService service;

	@Override
	@RequestMapping("/elo/calc/result")
	public MatchResult getResult(PlayerPerson personA, PlayerPerson personB, long pointsA, long pointsB) {
		return service.getResult(personA, personB, pointsA, pointsB);
	}
	
//	private long getElonumber(double eloA, double eloB, KNumber k, WinningPoints w) {
//		return ElonumberCalculator.calcElonumber(eloA, eloB, k, w);
//	}
//
//	@Override
//	@RequestMapping("/elo/calc")
//	public String getElonumberAsJson(@RequestParam("a") double eloA,@RequestParam("b") double eloB,@RequestParam("k") String kNumber,@RequestParam("w") String winningPoints) {
//		String json = "{\"Text\":\"%s\"}";
//		
//		return String.format(json, getElonumber(eloA, eloB, kNumber, winningPoints));
//	}
//	
//	@Override
//	@RequestMapping("/elo/calc/long")
//	public long getElonumber(@RequestParam("a") double eloA,@RequestParam("b") double eloB,@RequestParam("k") String kNumber,@RequestParam("w") String winningPoints) {
//		return getElonumber(eloA, eloB, KNumber.valueOf(kNumber), WinningPoints.valueOf(winningPoints));
//	}
//
//	@Override
//	@RequestMapping("/elo/calc/result")
//	public MatchResult getResult(@RequestParam("a") double eloA,@RequestParam("b") double eloB,@RequestParam("k") String kNumber,@RequestParam("w") String winningPoints) {
//
//		MatchResult result = new MatchResult();
//		
//		result.setEloPlayerOne(getElonumber(eloA, eloB, kNumber, winningPoints));
//		
//		WinningPoints otherWinningPoints = WinningPoints.valueOf(winningPoints);
//		if(otherWinningPoints == WinningPoints.DEFEAT)
//		{
//			otherWinningPoints = WinningPoints.WIN;
//		} else if (otherWinningPoints == WinningPoints.WIN)
//		{
//			otherWinningPoints = WinningPoints.DEFEAT;
//		}
//		
//		result.setEloPlayerTwo(getElonumber(eloB, eloA, kNumber, otherWinningPoints.name()));
//		
//		return result;
//	}
}
