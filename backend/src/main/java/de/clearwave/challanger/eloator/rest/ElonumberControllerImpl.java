package de.clearwave.challanger.eloator.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import de.clearwave.challanger.eloator.calculate.ElonumberCalculator;
import de.clearwave.challanger.eloator.domain.KNumber;
import de.clearwave.challanger.eloator.domain.WinningPoints;

@RestController
public class ElonumberControllerImpl implements ElonumberController {
	
	private long getElonumber(double eloA, double eloB, KNumber k, WinningPoints w) {
		return ElonumberCalculator.calcElonumber(eloA, eloB, k, w);
	}

	@Override
	@RequestMapping("/elo/calc")
	public long getElonumber(@RequestParam("a") double eloA,@RequestParam("b") double eloB,@RequestParam("k") String kNumber,@RequestParam("w") String winningPoints) {
		return getElonumber(eloA, eloB, KNumber.valueOf(kNumber), WinningPoints.valueOf(winningPoints));
	}
}
