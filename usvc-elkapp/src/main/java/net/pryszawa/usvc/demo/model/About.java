package net.pryszawa.usvc.demo.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "about")
@Getter
@Setter
public class About {

    @Id
    private String id;

    private String description;

}
