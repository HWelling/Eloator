package de.clearwave.challanger.eloator.domain;

public abstract class Person {
	
	private long id;
	
	private String name;
	private String lastName;
	
	private boolean jouth = false;
	
	public Person(final String name, final String lastName) {
		this.name = name;
		this.lastName = lastName;
	}
	
	public long getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public boolean isJouth() {
		return jouth;
	}

	public void setJouth(boolean jouth) {
		this.jouth = jouth;
	}

}
