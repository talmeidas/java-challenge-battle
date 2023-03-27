package io.github.talmeidas.battle.entrypoint.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackageClasses = {BattleApplication.class})
public class BattleApplication {
    public static void main(final String[] args) {
        SpringApplication.run(BattleApplication.class);
    }
}
