package org.ms3.lcstracker.teams;

import org.springframework.web.bind.annotation.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

/*
 * These methods need to return response entities
 * to communicate with the HTTP request correctly
 * therefore I should outsource the actual functionality to 
 * the TeamService class
 */

@RestController
@RequestMapping(value="/teams")
public class TeamController {
	
	@Autowired
	private TeamService ts;

	@PostMapping()
	@ResponseStatus(HttpStatus.ACCEPTED)
	public void addTeams(List<Team> tArray) {
		//add teams to collection
	}
	
	@GetMapping()
	public List<Team> getTeams(String region) {
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
