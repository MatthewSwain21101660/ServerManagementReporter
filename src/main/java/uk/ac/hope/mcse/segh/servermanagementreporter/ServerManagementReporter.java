package uk.ac.hope.mcse.segh.servermanagementreporter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@EnableAsync
public class ServerManagementReporter {

    public static void main(String[] args) {
        SpringApplication.run(ServerManagementReporter.class, args);
    }

}