package io.github.talmeidas.battle.infra;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.cosium.spring.data.jpa.entity.graph.repository.support.EntityGraphJpaRepositoryFactoryBean;


@EnableJpaRepositories(basePackageClasses = BattleApplication.class, repositoryFactoryBeanClass = EntityGraphJpaRepositoryFactoryBean.class)
@SpringBootApplication
public class BattleApplication {

    public static void main(final String[] args) {
        SpringApplication.run(BattleApplication.class, args);
    }
}
