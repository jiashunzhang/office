 package cn.edu.hebut.jszhang;

import javax.sql.DataSource;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
  * AppConfig
  */
@Configuration
public class AppConfig {

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.druid")
    DataSource dataSource() {
        return DruidDataSourceBuilder.create().build();
    }
 }