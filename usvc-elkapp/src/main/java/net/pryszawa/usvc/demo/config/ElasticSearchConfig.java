package net.pryszawa.usvc.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@Configuration
@EnableElasticsearchRepositories(basePackages = { "net.pryszawa.usvc.demo.repository" })
public class ElasticSearchConfig {
}
