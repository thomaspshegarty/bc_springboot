import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.ms3.lcstracker.LcsTrackerAPI;
import org.ms3.lcstracker.players.Player;
import org.ms3.lcstracker.teams.PlayerRepository;
import org.ms3.lcstracker.teams.TeamController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes= LcsTrackerAPI.class)
public class PlayerRepoTest {

    @Autowired
    private PlayerRepository pr;

    @Test
    public void addPlayers() throws Exception {
        pr.save(new Player("BrokenBlade","Team Solo Mid","TSM","top"));
        pr.save(new Player("Wunder","G2 Esports","G2","top"));
        System.out.println(pr.findByTag("TSM"));
    }
}
