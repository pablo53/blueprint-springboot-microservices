package net.pryszawa.usvc.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class MainConfigServer {

    public static void main(String[] args) {
        SpringApplication.run(MainConfigServer.class, args);
    }

}
