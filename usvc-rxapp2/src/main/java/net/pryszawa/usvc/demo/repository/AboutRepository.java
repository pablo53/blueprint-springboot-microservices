package net.pryszawa.usvc.demo.repository;

import net.pryszawa.usvc.demo.model.About;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface AboutRepository extends ReactiveCrudRepository<About, Long> {

    @Query("SELECT * FROM abouts")
    Flux<About> findAllAbouts();

}
