import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.ms3.lcstracker.LcsTrackerAPI;
import org.ms3.lcstracker.teams.TeamController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes= LcsTrackerAPI.class)
public class TeamUnitTest {

    @Autowired
    private TeamController tc;

    @Test
    public void contextLoads() throws Exception {
        System.out.println(tc.getTeam((long) 1));
    }
}
