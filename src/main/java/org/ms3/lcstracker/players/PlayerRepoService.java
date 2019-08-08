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
    private Player updateEach(Player to, Player from) {
        String ign, team, tag, role;
        if ((ign = to.getIgn()) == null)
            ign = from.getIgn();
        if ((team = to.getTeam()) == null)
            team = from.getTeam();
        if ((tag = to.getTag()) == null)
            tag = from.getTag();
        if ((role = to.getRole()) == null)
            role = from.getRole();

        Player toReturn = new Player(ign, team, tag, role);
        toReturn.setId(from.getId());
        return toReturn;

    }

    public void updatePlayer(long pId, Player p){
        Player p1 = (Player) pr.findById(pId).orElse(null);
        if (p1 == null){
            //fail here, the player doesn't exist in the database
        } else {
            p = updateEach(p,p1);
            pr.deleteById(pId);
            pr.save(p);
        }
    }

    //delete one player
    public void deletePlayer(long pId) {
        pr.deleteById(pId);
    }

}
