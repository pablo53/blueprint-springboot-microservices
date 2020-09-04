package net.pryszawa.usvc.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EchoController {

    @GetMapping("/echo/{message}")
    public ResponseEntity<String> getEcho(@PathVariable("message") String message) {
        return ResponseEntity.ok(message);
    }

}
