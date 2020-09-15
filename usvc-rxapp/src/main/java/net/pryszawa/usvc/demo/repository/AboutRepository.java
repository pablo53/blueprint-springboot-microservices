package net.pryszawa.usvc.demo.repository;

import net.pryszawa.usvc.demo.model.About;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AboutRepository extends ReactiveMongoRepository<About, String> {
}
