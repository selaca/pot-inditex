package com.inditex.pot.slc.infraestructure.dbsql.spring.config;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(
    basePackages = "com.inditex.pot.slc.infraestructure.dbsql.spring.repository")
@EntityScan(
    basePackages = "com.inditex.pot.slc.infraestructure.dbsql.spring.entities")
@ConfigurationProperties("spring.datasource")
@EnableJpaAuditing
public class DBSQLConfig {}
