package org.ms3.lcstracker.teams;

import org.springframework.beans.factory.annotation.Autowired;
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

    private Team updateEach(Team newInfo, Team oldTeam) {

        if(newInfo.getName() != null) {
            oldTeam.setName(newInfo.getName());
        }
        if(newInfo.getTag() != null) {
            oldTeam.setTag(newInfo.getTag());
        }
        if(newInfo.getRegion() != null) {
            oldTeam.setRegion(newInfo.getRegion());
        }
        if(newInfo.getWins() != -1) {
            oldTeam.setWins(newInfo.getWins());
        }
        if(newInfo.getLosses() != -1){
            oldTeam.setLosses(newInfo.getLosses());
        }
        return oldTeam;
    }

    public void updateTeam(long tId, Team newInfo) {
        Team oldTeam = (Team) tr.findById(tId).orElse(null);
        oldTeam = updateEach(newInfo, oldTeam);
        tr.save(oldTeam);
    }

    //delete one team

    public void deleteTeam(long tId) {
        tr.deleteById(tId);
    }

}
