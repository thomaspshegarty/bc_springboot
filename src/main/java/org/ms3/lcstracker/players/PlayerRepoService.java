package org.ms3.lcstracker.players;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerRepoService {

    @Autowired
    private PlayerRepository pr;

    PlayerRepoService(PlayerRepository pr) { this.pr = pr;  }

    //get players
    public List<Player> getPlayers(String tag) {
        if (tag == "") {
            return pr.findAll();
        } else {
            return pr.findByTag(tag);
        }
    }

    //post players
    public ResponseEntity postPlayers(List<Player> pArray) {
        List<Player> checkP = pr.saveAll(pArray);
        if (checkP.equals(pArray)) {
            return new ResponseEntity("Successfully added players", HttpStatus.ACCEPTED);
        } else {
            return new ResponseEntity("Adding players failed", HttpStatus.BAD_REQUEST);
        }
    }

    //get one player
    public Player getPlayer(long pId) {
        return pr.findById(pId).orElse(null);
    }

    //update one player
    private Player updateEach(Player newInfo, Player oldPlayer) {

        if(newInfo.getIgn() != null) {
            oldPlayer.setIgn(newInfo.getIgn());
        }
        if(newInfo.getTag() != null) {
            oldPlayer.setTag(newInfo.getTag());
        }
        if(newInfo.getTeam() != null) {
            oldPlayer.setTeam(newInfo.getTeam());
        }
        if(newInfo.getRole() != null) {
            oldPlayer.setRole(newInfo.getRole());
        }

        return oldPlayer;

    }

    public ResponseEntity updatePlayer(long pId, Player p){
        try {
            Player p1 = (Player) pr.findById(pId).orElse(null);
            p1 = updateEach(p,p1);
            Player testPlayer = pr.save(p1);
            if (testPlayer.equals(p1)) {
                return new ResponseEntity("Successfully updated player info", HttpStatus.ACCEPTED);
            } else {
                return new ResponseEntity("Failed to update player info", HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
            return new ResponseEntity("Player not in the database", HttpStatus.NOT_FOUND);
        }

    }

    //delete one player
    public void deletePlayer(long pId) {
        pr.deleteById(pId);
    }

}
