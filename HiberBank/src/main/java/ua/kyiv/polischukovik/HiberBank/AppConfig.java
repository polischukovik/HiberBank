package ua.kyiv.polischukovik.HiberBank;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
@Component("ua.kyiv.polischukovik")
public class AppConfig {
	
	@Bean
	public EntityManagerFactory entityManagerFactory() {
		return Persistence.createEntityManagerFactory("HiberBank-persistance-unit");
	}
	
	@Bean
	public DBInterface dbInterface(){
		return new DBTools();
	}
	
	@Bean
	public CustController custController(){
		return new CustController();
	}
	
	@Bean
	public Logger logger(){
		return LogManager.getLogger(Logging.class);
	}
}
