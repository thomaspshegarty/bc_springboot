package org.ms3.lcstracker.teams;

import org.springframework.beans.factory.annotation.*;
import org.springframework.http.HttpStatus;
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
    public List<Team> getTeams(@RequestBody String region) {
        return trs.getTeams(region);
    }

    @GetMapping("/{tId}")
    public Team getTeam(@PathVariable Long tId) {
        return trs.getTeam(tId);
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