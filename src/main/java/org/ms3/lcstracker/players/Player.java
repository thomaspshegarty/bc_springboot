package org.ms3.lcstracker.players;


import lombok.Data;
import javax.persistence.*;

@Entity
@Data
@Table(name="players")
public class Player {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@Column
	private String ign;
	@Column
	private String team;
	@Column
	private String tag;
	@Column
	private String role;

	Player () {}

	public Player(String ign, String team, String tag, String role) {
		this.ign = ign;
		this.team = team;
		this.tag = tag;
		this.role = role;
	}

}
