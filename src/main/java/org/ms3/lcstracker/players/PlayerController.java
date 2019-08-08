package org.ms3.lcstracker.players;

import java.util.List;

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

	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity getPlayers(@RequestParam("tag") String teamTag) {
		List<Player> tRet = prs.getPlayers(teamTag);
		if (tRet == null) {
			return new ResponseEntity("Could not locate any players with that team tag.",HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity(prs.getPlayers(teamTag),HttpStatus.OK);
		}
	}
	
	@PostMapping()
	@ResponseStatus(HttpStatus.ACCEPTED)
	public void postPlayers(@RequestBody List<Player> pArray) {
		prs.postPlayers(pArray);
	}
	
	@GetMapping("/{pId}")
	public ResponseEntity getPlayer(@PathVariable long pId) {
		Player p1 = prs.getPlayer(pId);
		if (p1 == null) {
			return new ResponseEntity("Could not locate any players with that player ID", HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity(prs.getPlayer(pId), HttpStatus.OK);
		}
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
