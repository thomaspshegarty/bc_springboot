package org.ms3.lcstracker.teams;

import org.springframework.beans.factory.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value="/teams")
public class TeamController {

    @Autowired
    private TeamRepoService trs;

    TeamController(TeamRepoService trs) {
        this.trs = trs;
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void addTeams(@RequestBody List<Team> tArray) {
        trs.addTeams(tArray);
    }

    @GetMapping()
    public ResponseEntity<List<Team>> getTeams(@RequestBody String region) {
        return new ResponseEntity<>(trs.getTeams(region),HttpStatus.OK);
    }

    @GetMapping("/{tId}")
    public ResponseEntity<Team> getTeam(@PathVariable Long tId) {

        return new ResponseEntity<>(trs.getTeam(tId), HttpStatus.OK);
    }

    @PutMapping("/{tId}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void updateTeam(@PathVariable Long tId, @RequestBody Team t) {
        trs.updateTeam(tId,t);
    }

    @DeleteMapping("/{tId}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deleteTeam(@PathVariable Long tId) {
        trs.deleteTeam(tId);
    }

}