package de.clearwave.challanger.eloator.rest;

import de.clearwave.challanger.eloator.domain.ElonumberRequest;
import de.clearwave.challanger.eloator.domain.MatchResult;

public interface ElonumberController {

//	public long getElonumber(double eloA, double eloB, String kNumber, String winningPoints);
//
//	public String getElonumberAsJson(double eloA, double eloB, String kNumber, String winningPoints);
//	
//	public MatchResult getResult(double eloA, double eloB, String kNumber, String winningPoints);
	
//	public MatchResult getResult(PlayerPerson personA, PlayerPerson personB, long pointsA, long pointsB);
	
	public MatchResult getResult(ElonumberRequest request);
}
