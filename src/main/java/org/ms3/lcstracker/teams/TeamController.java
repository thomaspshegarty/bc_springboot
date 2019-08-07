package org.ms3.lcstracker.teams;

import org.springframework.beans.factory.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value="/teams")
public class TeamController {

    @Autowired
    private TeamRepository tr;

    TeamController(TeamRepository tr) {
        this.tr = tr;
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void addTeams(List<Team> tArray) {
        for (Team t : tArray) {
            tr.save(t);
        }
    }

    @GetMapping()
    public List<Team> getTeams(String region) {
        return tr.findByRegion(region);
    }

    @GetMapping("/{tId}")
    public Team getTeam(Long tId) {
        return (Team) tr.findById(tId).orElse(null);
    }

    @PutMapping("/{tId}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void updateTeam(Long tId, Team t) {
        Team t1 = (Team) tr.findById(tId).orElse(null);
        t = updateEach(t, t1);
        tr.deleteById(tId);
        tr.save(t);
    }

    @DeleteMapping("/{tId}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deleteTeam(Long tId) {
        tr.deleteById(tId);
    }

    private Team updateEach(Team to, Team from) {
        String name, region, teamTag;
        int wins, losses;
        if ((name = to.getName()) == null)
            name = from.getName();
        if ((region = to.getRegion()) == null)
            region = from.getRegion();
        if ((teamTag = to.getTag()) == null)
            teamTag = from.getTag();
        if ((wins = to.getWins()) == -1)
            wins = from.getWins();
        if ((losses = to.getLosses()) == -1)
            losses = from.getLosses();

        Team toReturn = new Team(name, teamTag, region, wins, losses);
        toReturn.setId(to.getId());
        return toReturn;


    }

}