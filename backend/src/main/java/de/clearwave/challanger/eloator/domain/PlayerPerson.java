package de.clearwave.challanger.eloator.domain;

public class PlayerPerson extends Person {

	private long eloNumber;
	
	public PlayerPerson(String name, String lastName) {
		super(name, lastName);
	}

	public long getEloNumber() {
		return eloNumber;
	}

	public void setEloNumber(long eloNumber) {
		this.eloNumber = eloNumber;
	}

}
