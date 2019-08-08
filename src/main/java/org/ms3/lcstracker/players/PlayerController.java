package org.ms3.lcstracker.players;

import java.util.List;

import org.ms3.lcstracker.teams.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/players")
public class PlayerController {

	@Autowired
	private PlayerRepoService prs;

	PlayerController(PlayerRepoService prs) { this.prs = prs; }

	@RequestMapping("/")
	public String basicGreeting(){
		return "Welcome to the players page.";
	}

	@GetMapping()
	public ResponseEntity<List<Player>> getPlayers(@RequestBody String teamTag) {
		return new ResponseEntity<List<Player>>(prs.getPlayers(teamTag),HttpStatus.OK);
	}
	
	@PostMapping()
	@ResponseStatus(HttpStatus.ACCEPTED)
	public void postPlayers(@RequestBody List<Player> pArray) {
		prs.postPlayers(pArray);
	}
	
	@GetMapping("/{pId}")
	public ResponseEntity<Player> getPlayer(@PathVariable long pId) {
		return new ResponseEntity<>(prs.getPlayer(pId),HttpStatus.OK);
	}
	
	@PutMapping("/{pId}")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public void updatePlayer(@PathVariable long pId, @RequestBody Player p) {
		prs.updatePlayer(pId,p);
	}
	
	@DeleteMapping("/{pId}")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public void deletePlayer(@PathVariable long pId) {
		prs.deletePlayer(pId);
	}
	

}
