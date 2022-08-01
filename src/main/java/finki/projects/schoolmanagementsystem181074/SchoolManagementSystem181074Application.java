package finki.projects.schoolmanagementsystem181074;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@ServletComponentScan
public class SchoolManagementSystem181074Application {

    public static void main(String[] args) {
        SpringApplication.run(SchoolManagementSystem181074Application.class, args);
    }

}
