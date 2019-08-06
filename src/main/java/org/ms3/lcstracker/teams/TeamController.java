package org.ms3.lcstracker.teams;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

@RestController
@RequestMapping(value="/teams")
public class TeamController {

	@PostMapping()
	@ResponseStatus(HttpStatus.ACCEPTED)
	public void addTeams(Team[] tArray) {
		//add teams to collection
	}
	
	@GetMapping()
	public Team[] getTeams(String region) {
		//return teams from region
		return null;
	}
	
	@GetMapping("/{tId}")
	public Team getTeam(int tId) {
		//return team by id
		return null;
	}
	
	@PutMapping("/{tId}")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public void updateTeam(int tId, Team t) {
		//update tId with info in t
	}
	
	@DeleteMapping("/{tId")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public void deleteTeam(int tId) {
		//delete team tId
	}
	
}
