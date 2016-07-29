package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import model.HdzApplicant;
import model.HdzTest;
import model.HdzJobquestion;
import util.DBUtil;

public class TestsDao {
	
	public static void insertTest(HdzTest test) {
		EntityManager em = DBUtil.getEmfFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		try {
			trans.begin();
			em.persist(test);
			trans.commit();
		} catch (Exception e) {
			trans.rollback();
		} finally {
			em.close();
		}
	}
	
	// This method returns the first question for the given position and interview type
	public static HdzJobquestion getPendingTests(String positionid, String interviewtype){
		 EntityManager em = DBUtil.getEmfFactory().createEntityManager();
		 HdzJobquestion question = null;
	        String qString = "select a from HdzJobquestion a "
	                + "where a.hdzPosition.positionid = :positionid  and a.interviewtype= :interviewtype ";
	        
	        try{
	            TypedQuery<HdzJobquestion> query = em.createQuery(qString,HdzJobquestion.class);
	            query.setParameter("positionid", Long.parseLong(positionid));
	            query.setParameter("interviewtype", interviewtype);
	            question = query.getSingleResult();
	        }catch (Exception e){
	            e.printStackTrace();
	        }finally{
	            em.close();
	        }

	        return question;
	}
	
	// get a job question for a selected job questions id
	public static HdzJobquestion getJobQuestion(String jobquestionsid){
		 EntityManager em = DBUtil.getEmfFactory().createEntityManager();
		 HdzJobquestion question = null;
	        String qString = "select a from HdzJobquestion a "
	                + "where a.jobquestionsid = :jobquestionsid";
	        
	        try{
	            TypedQuery<HdzJobquestion> query = em.createQuery(qString,HdzJobquestion.class);
	            query.setParameter("jobquestionsid", Long.parseLong(jobquestionsid));	            
	            question = query.getSingleResult();
	        }catch (Exception e){
	            e.printStackTrace();
	        }finally{
	            em.close();
	        }

	        return question;
	}
	        
}
