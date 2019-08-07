import static org.assertj.core.api.Assertions.assertThat;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.ms3.lcstracker.LcsTrackerAPI;
import org.ms3.lcstracker.players.Player;
import org.ms3.lcstracker.players.PlayerController;
import org.ms3.lcstracker.teams.PlayerRepository;
import org.ms3.lcstracker.teams.TeamController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes= LcsTrackerAPI.class)
@FixMethodOrder(MethodSorters.DEFAULT)
public class PlayerRepoTest {

    @Autowired
    private PlayerRepository pr;

    @Autowired
    private PlayerController pc;

    private List<Player> pArray;

    @Test
    public void addPlayers() throws Exception {
        Player doubleLift = new Player("DoubleLift", "Team Liquid", "TL", "adc");
        Player brokenBlade = new Player("BrokenBlade", "Team Solo Mid", "TSM", "top");
        Player faker = new Player("Faker", "South Korea Telecom", "SKT", "mid");

        pArray = new ArrayList<Player>();

        pArray.add(doubleLift);
        pArray.add(brokenBlade);
        pArray.add(faker);

        pc.postPlayers(pArray);
        System.out.println(pc.getPlayers(""));

    }

    @Test
    public void updatePlayer() throws Exception {
        Player damonte = new Player("Damonte", "Clutch Gaming", "CG", "mid");
        pArray = new ArrayList<Player>();

        pArray.add(damonte);

        pc.postPlayers(pArray);
        Player dingomonte = new Player("Dingomonte", "Clutch Gaming", "CG", "mid");

        pc.updatePlayer(damonte.getId(),dingomonte);

        System.out.println(pc.getPlayers(""));
    }

}
