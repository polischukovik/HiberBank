package hiberbank.config;

import org.hibernate.ejb.HibernatePersistence;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
@ComponentScan("com.devcolibri.dataexam")
@PropertySource("classpath:app.properties")
@EnableJpaRepositories("com.devcolibri.dataexam.repository")
public class DataConfig {

    private static final String PROPERTY_DATABASE_DRIVER = "db.driver";
    private static final String PROPERTY_DATABASE_PASSWORD = "db.password";
    private static final String PROPERTY_DATABASE_URL = "db.url";
    private static final String PROPERTY_DATABASE_USERNAME = "db.username";
    private static final String PROPERTY_HIBERNATE_DIALECT = "db.hibernate.dialect";
    private static final String PROPERTY_HIBERNATE_SHOW_SQL = "db.hibernate.show_sql";
    private static final String PROPERTY_ENTITYMANAGER_PACKAGES_TO_SCAN = "db.entitymanager.packages.to.scan";
    private static final String PROPERTY_HIBERNATE_HBM2DDL_AUTO = "db.hibernate.hbm2ddl.auto";
    
    @Resource
    private Environment env;
 
    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
 
        dataSource.setDriverClassName(env.getRequiredProperty(PROPERTY_DATABASE_DRIVER));
        dataSource.setUrl(env.getRequiredProperty(PROPERTY_DATABASE_URL));
        dataSource.setUsername(env.getRequiredProperty(PROPERTY_DATABASE_USERNAME));
        dataSource.setPassword(env.getRequiredProperty(PROPERTY_DATABASE_PASSWORD));
 
        return dataSource;
    }
 
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactoryBean.setDataSource(dataSource());
        entityManagerFactoryBean.setPersistenceProviderClass(HibernatePersistence.class);
        entityManagerFactoryBean.setPackagesToScan(env.getRequiredProperty(PROPERTY_ENTITYMANAGER_PACKAGES_TO_SCAN));
 
        entityManagerFactoryBean.setJpaProperties(getHibernateProperties());
 
        return entityManagerFactoryBean;
    }
 
    @Bean
    public JpaTransactionManager transactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
 
        return transactionManager;
    }
 
    private Properties getHibernateProperties() {
        Properties properties = new Properties();
        properties.put(PROPERTY_HIBERNATE_DIALECT, env.getRequiredProperty(PROPERTY_HIBERNATE_DIALECT));
        properties.put(PROPERTY_HIBERNATE_SHOW_SQL, env.getRequiredProperty(PROPERTY_HIBERNATE_SHOW_SQL));
        properties.put(PROPERTY_HIBERNATE_HBM2DDL_AUTO, env.getRequiredProperty(PROPERTY_HIBERNATE_HBM2DDL_AUTO));
 
        return properties;
    }
}
