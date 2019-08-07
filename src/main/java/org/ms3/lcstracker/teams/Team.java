package org.ms3.lcstracker.teams;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Team {

	@Id
	@GeneratedValue
	private Long id;
	@Column
	private String name;
	@Column
	private String tag;
	@Column
	private String region;
	@Column
	private int wins;
	@Column
	private int losses;

	Team() {}

	public Team(String name, String tag, String region, int wins, int losses) {
		this.name = name;
		this.tag = tag;
		this.region = region;
		this.wins = wins;
		this.losses = losses;
	}
}
