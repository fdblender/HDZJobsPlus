package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import model.HdzApplicant;
import model.HdzTest;
import model.HdzJobquestion;
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
	
	// TO DO: TEST THIS METHOD TO GET PENDING TESTS FROM JOBQUESTIONS TABLE
	// This method returns the first question for the given position and interview type
	public static HdzJobquestion getPendingTests(String positionid, String interviewtype){
		 EntityManager em = DBUtil.getEmfFactory().createEntityManager();
		 HdzJobquestion question = null;
	        String qString = "select a from HdzJobquestion a "
	                + "where a.HdzPosition.positionid = :positionid  and a.interviewtype= :interviewtype ";
	        
	        try{
	            TypedQuery<HdzJobquestion> query = em.createQuery(qString,HdzJobquestion.class);
	            query.setParameter("positionid",positionid);
	            query.setParameter("interviewtype", interviewtype);
	            question = query.getSingleResult();
	        }catch (Exception e){
	            e.printStackTrace();
	        }finally{
	            em.close();
	        }
	        return question;
	}
	        
}
