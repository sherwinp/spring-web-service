package dataservice;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Test001{
	public static void main(String[] args){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dataservice");
		EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
 
            Inbound msg = new Inbound();
 
            msg.setMessageId(msg.NewMessageId());
 
            em.persist(msg);
 
            em.getTransaction().commit();
        }
        catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        }
        finally{
            emf.close();
        }
	}
}