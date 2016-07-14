package hiberbank.db;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

@Component
public class DataSourceValidator {
    @PersistenceContext
    private EntityManager entityManager;
    
    private Logger logger = LogManager.getLogger(DataSourceValidator.class);

	public void validateSchema() {
		logger.info("Validating schema");
		logger.info("#####################################################");
		entityManager.flush();
	}
}
