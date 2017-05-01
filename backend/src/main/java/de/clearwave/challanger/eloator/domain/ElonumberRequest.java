package de.clearwave.challanger.eloator.domain;

public class ElonumberRequest {
	private PlayerPerson personA;
	private PlayerPerson personB;
	
	private long pointsA;
	private long pointsB;
	
	public ElonumberRequest() {
		// TODO Auto-generated constructor stub
	}

	public PlayerPerson getPersonA() {
		return personA;
	}

	public void setPersonA(PlayerPerson personA) {
		this.personA = personA;
	}

	public PlayerPerson getPersonB() {
		return personB;
	}

	public void setPersonB(PlayerPerson personB) {
		this.personB = personB;
	}

	public long getPointsA() {
		return pointsA;
	}

	public void setPointsA(long pointsA) {
		this.pointsA = pointsA;
	}

	public long getPointsB() {
		return pointsB;
	}

	public void setPointsB(long pointsB) {
		this.pointsB = pointsB;
	}
	
	
}
