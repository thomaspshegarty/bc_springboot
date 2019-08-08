package org.ms3.lcstracker.teams;

import javax.persistence.*;

import lombok.Data;

@Entity
@Data
@Table(name="teams")
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
	private int wins = -1;
	@Column
	private int losses = -1;

	Team() {}

	public Team(String name, String tag, String region, int wins, int losses) {
		this.name = name;
		this.tag = tag;
		this.region = region;
		this.wins = wins;
		this.losses = losses;
	}
}
