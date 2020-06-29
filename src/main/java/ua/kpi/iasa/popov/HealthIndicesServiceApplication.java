package ua.kpi.iasa.popov;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import ua.cmathtutor.startledfrog.repository.RepositoryFactoryBean;

@SpringBootApplication
@EnableJpaRepositories(repositoryFactoryBeanClass = RepositoryFactoryBean.class)
public class HealthIndicesServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(HealthIndicesServiceApplication.class, args);
    }
}