package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import model.HdzApplicant;
import model.HdzTest;
import util.DBUtil;

public class PendingTestsDao {
	
	public static void insert(HdzTest applicant) {
		EntityManager em = DBUtil.getEmfFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		try {
			trans.begin();
			em.persist(applicant);
			trans.commit();
		} catch (Exception e) {
			trans.rollback();
		} finally {
			em.close();
		}
	}
	
	// TO DO: CODE THIS TO GET THE PENDING TESTS FROM JOBQUESTIONS TABLE
	public static HdzApplicant getPendingTests(String firstname, String lastname){
		 EntityManager em = DBUtil.getEmfFactory().createEntityManager();
	        HdzApplicant applicant = null;
	        String qString = "select a from HdzApplicant a "
	                + "where a.firstname = :firstname  and a.lastname= :lastname ";
	        
	        try{
	            TypedQuery<HdzApplicant> query = em.createQuery(qString,HdzApplicant.class);
	            query.setParameter("firstname",firstname);
	            query.setParameter("lastname", lastname);
	             applicant= query.getSingleResult();
	        }catch (Exception e){
	            e.printStackTrace();
	        }finally{
	            em.close();
	        }
	        return applicant;
	        
}
