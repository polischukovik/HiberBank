package ua.kyiv.polischukovik.HiberBank;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DBTools {
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("HiberBank");
	private static EntityManager em = emf.createEntityManager();
	
	private DBTools(){
		
	}

	public static void writeObject(Customer cust) {
		Logging.log.info("Attempting to persist object " + cust);
		em.getTransaction().begin();
		try{
			em.persist(cust);
			em.getTransaction().commit();
			Logging.log.info("Object was successfully written to DB");
		}catch(Exception e){
			em.getTransaction().rollback();
			Logging.log.info("Failed to write object to DB");
		}
	}
}
