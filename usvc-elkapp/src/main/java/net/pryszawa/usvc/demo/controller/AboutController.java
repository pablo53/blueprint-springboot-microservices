package net.pryszawa.usvc.demo.controller;

import lombok.RequiredArgsConstructor;
import net.pryszawa.usvc.demo.model.About;
import net.pryszawa.usvc.demo.service.AboutService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/elk")
@RequiredArgsConstructor
public class AboutController {

    private final AboutService aboutService;

    @GetMapping("/echo/{message}")
    public ResponseEntity<String> getEcho(@PathVariable("message") String message) {
        About about = aboutService.addAbout(message);
        return ResponseEntity.ok(about.getId() + ":" + about.getDescription());
    }

    @GetMapping("/history")
    public ResponseEntity<List<String>> getEchoHistory() {
        return ResponseEntity.ok(aboutService.getAbouts());
    }

}
