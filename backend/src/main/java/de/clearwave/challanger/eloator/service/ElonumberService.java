package de.clearwave.challanger.eloator.service;

import de.clearwave.challanger.eloator.domain.MatchResult;
import de.clearwave.challanger.eloator.domain.PlayerPerson;

public interface ElonumberService {

	MatchResult getResult(PlayerPerson a, PlayerPerson b, long pointsA, long pointsB);
	
}
