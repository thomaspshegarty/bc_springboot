package org.ms3.lcstracker.players;

//import javax.persistence.*;

//@Entity
public class Player {
	
	//@Id
	//@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String ign;
	private String team;
	private String teamTag;
	private String role;
	
	public Player(String ign, String team, String teamTag, String role) {
		this.ign = ign;
		this.team = team;
		this.teamTag = teamTag;
		this.role = role;
	}
	
	public Long getId() {
		return id;
	}
	
	public String getIgn() {
		return ign;
	}
	
	public String getTeam() {
		return team;
	}
	
	public String getTeamTag() {
		return teamTag;
	}
	
	public String getRole() {
		return role;
	}

}
