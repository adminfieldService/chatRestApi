package com.spinku.userRestApi;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.stream.Collectors;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableWebSecurity
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "userEntityManager",
        transactionManagerRef = "userTransactionManager",
        basePackages = "com.spinku.userRestApi.repo.user")
public class UserSourceConfig {

    @Autowired
    private Environment env;

    @Bean
    @ConfigurationProperties(prefix = "bar.datasource")
    public DataSource postgresqlDataSource() {
        /*
		 * return DataSourceBuilder .create() .build();
         */
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(env.getProperty("bar.datasource.driver-class-name"));
        dataSource.setUrl(env.getProperty("bar.datasource.url"));
        dataSource.setUsername(env.getProperty("bar.datasource.username"));
        dataSource.setPassword(env.getProperty("bar.datasource.password"));

        return dataSource;
    }

    @Bean(name = "userEntityManager")
    public LocalContainerEntityManagerFactoryBean postgresqlEntityManagerFactory(EntityManagerFactoryBuilder builder) {
        return builder.dataSource(postgresqlDataSource()).properties(hibernateProperties())
                .packages("com.spinku.userRestApi.entity.user").persistenceUnit("user_PU").build();//com.spinku.userRestApi.entity.user
    }

    @Bean(name = "userTransactionManager")
    public PlatformTransactionManager postgresqlTransactionManager(
            @Qualifier("userEntityManager") EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }

    private Map<String, ?> hibernateProperties() {

        Resource resource = new ClassPathResource("hibernate.properties");

        try {
            Properties properties = PropertiesLoaderUtils.loadProperties(resource);

            return properties.entrySet().stream()
                    .collect(Collectors.toMap(e -> e.getKey().toString(), e -> e.getValue()));
        } catch (IOException e) {
//			return new HashMap<String, Object>();
            return new HashMap<>();
        }
    }
}
