package net.pryszawa.usvc.demo.controller;

import lombok.RequiredArgsConstructor;
import net.pryszawa.usvc.demo.model.About;
import net.pryszawa.usvc.demo.repository.AboutRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/about")
@RequiredArgsConstructor
public class AboutController {

    private final AboutRepository aboutRepository;

    @GetMapping
    Flux<About> getAllAbouts() {
        return aboutRepository.findAllAbouts();
    }

}
