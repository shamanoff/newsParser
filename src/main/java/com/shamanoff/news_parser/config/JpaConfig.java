package com.shamanoff.news_parser.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

@Configuration
@EnableJpaRepositories(basePackages = "com.shamanoff.news_parser.repository")
public class JpaConfig {

  /*  @Value("${jdbc.driver}")
    private String driver;
    @Value("${jdbc.username}")
    private String username;*/

    @Autowired
    private Environment env;

    @Bean
    public DataSource dataSource() {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(env.getProperty("jdbc.url"));
        config.setUsername(env.getProperty("jdbc.username"));
        config.setPassword(env.getProperty("jdbc.password"));
        config.setJdbcUrl(env.getProperty("jdbc.url"));
//        config.setJdbcUrl("jdbc:postgresql://localhost:5432/news");

     /*   config.setUsername(username);
        config.setPassword("azart1976");
        config.setDriverClassName(driver);*/

        return new HikariDataSource(config);
    }

    @Bean
    public EntityManagerFactory entityManagerFactory(@Autowired DataSource dataSource) {

        LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
        factoryBean.setDataSource(dataSource);
        factoryBean.setPackagesToScan("com.shamanoff.news_parser.model");
        factoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        factoryBean.afterPropertiesSet();
        return factoryBean.getObject();
    }


}
