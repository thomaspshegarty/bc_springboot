package org.ms3.lcstracker.players;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/*
 * These methods need to return response entities
 * to communicate with the HTTP request correctly
 * therefore I should out-source the actual functionality to 
 * the PlayerService class
 */


@RestController
@RequestMapping("/players")
public class PlayerController {
	
	@GetMapping()
	public List<Player> getPlayers(String teamTag) {
		//get all players on teamTag team
		return null;
	}
	
	@PostMapping()
	@ResponseStatus(HttpStatus.ACCEPTED)
	public void postPlayers(List<Player> pArray) {
		//Pass these players into PlayerController
	}
	
	@GetMapping("/{pId}")
	public Player getPlayer(int pId) {
		return null;
	}
	
	@PutMapping("/{pId}")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public void updatePlayer(int pId, Player p) {
		//update info of pId player
	}
	
	@DeleteMapping("/{pId}")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public void deletePlayer(int pId) {
		//remove pId player from db
	}
	
	
}
