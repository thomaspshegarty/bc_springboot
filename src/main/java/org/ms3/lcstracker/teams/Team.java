package org.ms3.lcstracker.teams;

public class Team {

	private Long id;
	private String name;
	private String tag;
	private String region;
	private int wins;
	private int losses;
	
	public Team(String name, String tag, String region, int wins, int losses) {
		this.name = name;
		this.tag = tag;
		this.region = region;
		this.wins = wins;
		this.losses = losses;
	}
	
	public Long getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public String getTag() {
		return tag;
	}
	
	public String getRegion() {
		return region;
	}
	
	public int getWins() {
		return wins;
	}
	
	public int getLosses() {
		return losses;
	}
}
