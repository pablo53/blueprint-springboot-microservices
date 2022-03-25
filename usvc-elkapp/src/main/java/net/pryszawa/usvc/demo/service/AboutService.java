package net.pryszawa.usvc.demo.service;

import lombok.RequiredArgsConstructor;
import net.pryszawa.usvc.demo.model.About;
import net.pryszawa.usvc.demo.repository.AboutRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AboutService {

    private final AboutRepository aboutRepository;

    public About addAbout(String description) {
        About about = new About();
        about.setDescription(description);
        return aboutRepository.save(about);
    }

    public List<String> getAbouts() {
        ArrayList<String> descriptions = new ArrayList<>();
        aboutRepository.findAll().forEach(about -> descriptions.add(about.getDescription()));
        return descriptions;
    }

}
