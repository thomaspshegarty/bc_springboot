package org.ms3.lcstracker.players;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class PlayerController {

	@GetMapping("/{pId}")
	public Player getPlayer(int pId) {
		return null;
	}
	
	@PostMapping()
	@ResponseStatus(HttpStatus.ACCEPTED)
	public void postPlayers(Player[] pArray) {
		
	}
	
	
	@RequestMapping("/players")
	public String topPlayers() {
		return "BB number one all time no competition";
	}
	
	
	
}
