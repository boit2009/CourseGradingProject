package coursegradingproject.application;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.persistence.Entity;

@SpringBootApplication
@ComponentScan(basePackages = {"coursegradingproject"})
@EntityScan(basePackages = {"coursegradingproject.client"})
@EnableJpaRepositories(basePackages = {"coursegradingproject.client"})
public class CourseGradingProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(CourseGradingProjectApplication.class, args);
    }
}
