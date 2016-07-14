package hiberbank.config;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.sql.DataSource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
	
    private Logger logger = LogManager.getLogger(SpringRootConfig.class);
	
	private static final String PROPERTY_DB_ENGINE = "db.engine";
	
	private static final String PROPERTY_DATABASE_DRIVER = "db.driver";
    private static final String PROPERTY_DATABASE_PASSWORD = "db.password";
    private static final String PROPERTY_DATABASE_URL = "db.url";
    private static final String PROPERTY_DATABASE_USERNAME = "db.username";
    private static final String PROPERTY_HIBERNATE_DIALECT = "db.hibernate.dialect";
    private static final String PROPERTY_HIBERNATE_SHOW_SQL = "db.hibernate.show_sql";
    private static final String PROPERTY_ENTITYMANAGER_PACKAGES_TO_SCAN = "hiberbank.domain";
    private static final String PROPERTY_HIBERNATE_HBM2DDL_AUTO = "db.hibernate.hbm2ddl.auto";
    
    @Resource
    private Environment env;

    
    @Bean
    public DataSource dataSource() {
    	Map<String, String> map = new HashMap<>();
    	
    	logger.info("Retrieveing DataSource properties...");
    	map.put(PROPERTY_DATABASE_DRIVER, env.getRequiredProperty(PROPERTY_DATABASE_DRIVER + "." + env.getRequiredProperty(PROPERTY_DB_ENGINE)));
    	map.put(PROPERTY_DATABASE_URL, env.getRequiredProperty(PROPERTY_DATABASE_URL));
    	map.put(PROPERTY_DATABASE_USERNAME, env.getRequiredProperty(PROPERTY_DATABASE_USERNAME));
    	map.put(PROPERTY_DATABASE_PASSWORD, env.getRequiredProperty(PROPERTY_DATABASE_PASSWORD));
    	
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        
        logger.info("Setting DataSource properties:");
        logger.info(String.format("\tProperty %s: %s", PROPERTY_DATABASE_DRIVER, map.get(PROPERTY_DATABASE_DRIVER)));
        dataSource.setDriverClassName(map.get(PROPERTY_DATABASE_DRIVER));
        logger.info(String.format("\tProperty %s: %s", PROPERTY_DATABASE_URL, map.get(PROPERTY_DATABASE_URL)));
        dataSource.setUrl( map.get(PROPERTY_DATABASE_URL));
        logger.info(String.format("\tProperty %s: %s", PROPERTY_DATABASE_USERNAME, map.get(PROPERTY_DATABASE_USERNAME)));
        dataSource.setUsername(map.get(PROPERTY_DATABASE_USERNAME));
        logger.info(String.format("\tProperty %s: %s", PROPERTY_DATABASE_PASSWORD, map.get(PROPERTY_DATABASE_PASSWORD)));
        dataSource.setPassword(map.get(PROPERTY_DATABASE_PASSWORD));
        
        return dataSource;
    }
 
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();        
        entityManagerFactoryBean.setDataSource(dataSource());
        entityManagerFactoryBean.setPersistenceProviderClass(HibernatePersistenceProvider.class);
        entityManagerFactoryBean.setPackagesToScan(PROPERTY_ENTITYMANAGER_PACKAGES_TO_SCAN);        
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
    	Map<String, String> map = new HashMap<>();
    	
    	logger.info("Retrieveing Hibernate properties...");
    	map.put(PROPERTY_HIBERNATE_DIALECT, env.getRequiredProperty(PROPERTY_HIBERNATE_DIALECT + "." + env.getRequiredProperty(PROPERTY_DB_ENGINE)));
    	map.put(PROPERTY_HIBERNATE_SHOW_SQL,env.getRequiredProperty(PROPERTY_HIBERNATE_SHOW_SQL));
    	map.put(PROPERTY_HIBERNATE_HBM2DDL_AUTO, env.getRequiredProperty(PROPERTY_HIBERNATE_HBM2DDL_AUTO));
    	
        Properties properties = new Properties();
    	logger.info("Setting Hibernate properties...");
        for(String key: map.keySet()){
        	String value = map.get(key);
        	logger.info(String.format("\tProperty %s: %s", key, value));
        	properties.put(key, value);
        }
        return properties;
    }
    
}