package org.ms3.lcstracker.players;

import org.springframework.beans.factory.annotation.Autowired;
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
    public void postPlayers(List<Player> pArray) {
        List<Player> checkP = pr.saveAll(pArray);
        if (checkP.equals(pArray)) {
            //then the addition was successful
        } else {
            //addition wasn't successful
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

    public void updatePlayer(long pId, Player p){
        Player p1 = (Player) pr.findById(pId).orElse(null);
        p1 = updateEach(p,p1);
        pr.save(p1);
    }

    //delete one player
    public void deletePlayer(long pId) {
        pr.deleteById(pId);
    }

}
