package net.pryszawa.usvc.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication(scanBasePackages = { "net.pryszawa.usvc.demo" })
public class MainRxApp2 {

    public static void main(String[] args) {
        SpringApplication.run(MainRxApp2.class, args);
    }

}
