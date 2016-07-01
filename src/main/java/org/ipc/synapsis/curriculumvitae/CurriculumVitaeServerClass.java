package org.ipc.synapsis.curriculumvitae;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@EnableEurekaClient
@EnableJpaRepositories(basePackages = {"org.ipc.synapsis.curriculumvitae.repository"})
public class CurriculumVitaeServerClass {

    public static void main(final String[] args) {
        SpringApplication.run(CurriculumVitaeServerClass.class, args);
    }

}
