package org.ms3.lcstracker.teams;


import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class TeamPreloader {

    @Bean
    CommandLineRunner testDatabase(TeamRepository tr) {
        return args -> {
            Team t1 = new Team("Team Solo Mid", "TSM", "NA", 10, 5);
            Team t2 = new Team("G2 Esports", "G2", "EU", 13, 4);

            log.info("Preloading " + tr.save(t1));
            log.info("Preloading " + tr.save(t2));
        };
    }

}
