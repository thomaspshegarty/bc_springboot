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
    public ResponseEntity getTeams(@RequestParam("region") String region) {
        List<Team> tRet = trs.getTeams(region);
        if (tRet == null) {
            return new ResponseEntity("Could not find any team in the region",HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity(tRet,HttpStatus.OK);
        }

    }

    @GetMapping("/{tId}")
    public ResponseEntity<Team> getTeam(@PathVariable Long tId) {
        Team t1 = trs.getTeam(tId);
        if (t1 == null) {
            return new ResponseEntity("Could not find team of given id",HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity(t1,HttpStatus.OK);
        }
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