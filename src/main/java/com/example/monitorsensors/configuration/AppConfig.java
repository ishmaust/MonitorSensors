package com.example.monitorsensors.configuration;

import java.util.Properties;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class AppConfig {

  private final Environment environment;

  @Autowired
  public AppConfig(Environment environment) {
    this.environment = environment;
  }

  @Bean
  public SessionFactory sessionFactory() {
    Properties hibernateProperties = new Properties();
    hibernateProperties.put("hibernate.connection.url", environment.getRequiredProperty("spring.datasource.url"));
    hibernateProperties.put("hibernate.connection.username", environment.getRequiredProperty("spring.datasource.username"));
    hibernateProperties.put("hibernate.connection.password", environment.getRequiredProperty("spring.datasource.password"));


    Configuration configuration =  new Configuration().addProperties(hibernateProperties).configure("hibernate.cfg.xml");

    return configuration.buildSessionFactory();
  }

}
