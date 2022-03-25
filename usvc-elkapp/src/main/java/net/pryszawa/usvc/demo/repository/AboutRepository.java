package net.pryszawa.usvc.demo.repository;

import net.pryszawa.usvc.demo.model.About;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface AboutRepository extends ElasticsearchRepository<About, String> {

    List<About> findByDescription(String description);

}
