package hiberbank.config;

import java.util.Properties;
import java.util.logging.Logger;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.apache.logging.log4j.LogManager;
import org.hibernate.jpa.HibernatePersistenceProvider;
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
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import hiberbank.service.CustomerService;

@Configuration
@ComponentScan({ "hiberbank.service" })
@EnableTransactionManagement
@PropertySource("classpath:/app.properties")
@EnableJpaRepositories("hiberbank.repository")
public class SpringRootConfig {
	
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
        entityManagerFactoryBean.setPersistenceProviderClass(HibernatePersistenceProvider.class);
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
    
    @Bean
    public org.apache.logging.log4j.Logger getLogger(){
    	return  LogManager.getLogger(getClass());
    			
    }
    
    @Bean
    public CommonsMultipartResolver multipartResolver() {
        return new CommonsMultipartResolver();
    }
 
    private Properties getHibernateProperties() {
        Properties properties = new Properties();
        properties.put(PROPERTY_HIBERNATE_DIALECT, env.getRequiredProperty(PROPERTY_HIBERNATE_DIALECT));
        properties.put(PROPERTY_HIBERNATE_SHOW_SQL, env.getRequiredProperty(PROPERTY_HIBERNATE_SHOW_SQL));
        properties.put(PROPERTY_HIBERNATE_HBM2DDL_AUTO, env.getRequiredProperty(PROPERTY_HIBERNATE_HBM2DDL_AUTO));
 
        return properties;
    }
    
}