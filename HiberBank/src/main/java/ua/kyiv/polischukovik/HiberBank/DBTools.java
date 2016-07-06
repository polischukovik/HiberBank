package ua.kyiv.polischukovik.HiberBank;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

public class DBTools implements DBInterface {

	@Autowired
	private EntityManagerFactory emf;

	@Autowired
	private Logger log;
	
	public void writeObject(Object o) {
		EntityManager em = emf.createEntityManager();
		
		log.info("Attempting to persist object " + o );
		
		em.getTransaction().begin();
		try{
			em.persist(o);
			em.getTransaction().commit();
			log.info("Object " + o + " was successfully written to DB");
		}catch(Exception e){
			log.error(e.getMessage());
			e.printStackTrace();
			em.getTransaction().rollback();
			log.info("Failed to write object to DB");
		}
		em.close();
	}

	public void deleteObject(int id) {
		// TODO Auto-generated method stub
		
	}
	
	public <T> T findObjectById(int id, Class<T> clazz) {
		EntityManager em = emf.createEntityManager();
		return clazz.cast(em.find(clazz.getClass(), id));	
	}	

	public <T> List<T> findObjectsByName(String string, String queryString, Class<T> clazz) {
		EntityManager em = emf.createEntityManager();
		Query  query = em.createNamedQuery(queryString, clazz.getClass());
		query.setParameter("P1", string);
		return  (List<T>) query.getResultList();
	}	
}
