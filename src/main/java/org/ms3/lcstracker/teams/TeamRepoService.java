package org.ms3.lcstracker.teams;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    public ResponseEntity addTeams(List<Team> tArray) {
        List<Team> retVal = tr.saveAll(tArray);
        if (retVal.equals(tArray)) {
            return new ResponseEntity("Successful DB modification",HttpStatus.ACCEPTED);
        } else {
            return new ResponseEntity("Unsuccessful DB modification",HttpStatus.BAD_REQUEST);
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

    public ResponseEntity updateTeam(long tId, Team newInfo) {
        try {
            Team oldTeam = (Team) tr.findById(tId).orElse(null);

            oldTeam = updateEach(newInfo, oldTeam);
            Team checkTeam = tr.save(oldTeam);
            if (checkTeam.equals(oldTeam)) {
                return new ResponseEntity("Successful update of team info", HttpStatus.ACCEPTED);
            } else {
                return new ResponseEntity("Failed to update team info", HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
            return new ResponseEntity("No team with that ID to update",HttpStatus.NOT_FOUND);
        }
    }

    //delete one team

    public void deleteTeam(long tId) {
        tr.deleteById(tId);
    }

}
