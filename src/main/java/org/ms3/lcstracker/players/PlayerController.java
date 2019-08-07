package org.ms3.lcstracker.players;

import java.util.List;

import org.ms3.lcstracker.teams.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/players")
public class PlayerController {

	@Autowired
	private PlayerRepository pr;

	@RequestMapping("/")
	public String basicGreeting(){
		return "Welcome to the players page.";
	}

	@GetMapping()
	public List<Player> getPlayers(@RequestBody String teamTag) {
		if (teamTag == "") {
			return pr.findAll();
		} else {
			return pr.findByTag(teamTag);
		}
	}
	
	@PostMapping()
	@ResponseStatus(HttpStatus.ACCEPTED)
	public void postPlayers(@RequestBody List<Player> pArray) {
		for (Player p: pArray) {
			pr.save(p);
		}
	}
	
	@GetMapping("/{pId}")
	public Player getPlayer(@PathVariable long pId) {
		return pr.findById(pId).orElse(null);
	}
	
	@PutMapping("/{pId}")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public void updatePlayer(long pId, Player p) {
		Player p1 = (Player) pr.findById(pId).orElse(null);
		if (p1 == null){
			//fail here, the player doesn't exist in the database
		} else {
			p = updateEach(p,p1);
			pr.deleteById(pId);
			pr.save(p);
		}
	}
	
	@DeleteMapping("/{pId}")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public void deletePlayer(@PathVariable long pId) {
		pr.deleteById(pId);
	}
	
	private Player updateEach(Player to, Player from) {
		String ign, team, tag, role;
		if ((ign = to.getIgn()) == null)
			ign = from.getIgn();
		if ((team = to.getTeam()) == null)
			team = from.getTeam();
		if ((tag = to.getTag()) == null)
			tag = from.getTag();
		if ((role = to.getRole()) == null)
			role = from.getRole();

		Player toReturn = new Player(ign, team, tag, role);
		toReturn.setId(from.getId());
		return toReturn;

	}
}
