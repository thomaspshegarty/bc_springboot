package org.ms3.lcstracker.teams;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamRepoService {

    @Autowired
    private TeamRepository tr;

    TeamRepoService (TeamRepository tr) {this.tr = tr;}

    //get teams

    public List<Team> getTeams(String region) {
        if (region.equals("")) {
            return tr.findAll();
        } else {
            return tr.findByRegion(region);
        }
    }

    //post teams

    public void addTeams(List<Team> tArray) {
        for (Team t: tArray) {
            tr.save(t);
        }
    }

    //get one team
    public Team getTeam(long tId) {
        return (Team) tr.findById(tId).orElse(null);
    }

    //update one team

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
        toReturn.setId(from.getId());
        return toReturn;

    }

    public void updateTeam(long tId, Team t) {
        Team t1 = (Team) tr.findById(tId).orElse(null);
        t = updateEach(t, t1);
        tr.deleteById(tId);
        tr.save(t);
    }

    //delete one team

    public void deleteTeam(long tId) {
        tr.deleteById(tId);
    }

}
