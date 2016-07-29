package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import model.HdzJob;
import model.HdzJobquestion;
import model.HdzTest;
import util.DBUtil;

public class QuestionsDao {

	public static List<HdzTest> getQuestionList(String string, String applicationid) {
		
	        EntityManager em = DBUtil.getEmfFactory().createEntityManager();
	        List<HdzTest> questions = null;
	        String qString = "select q from HdzTest q where q.hdzJobquestion.interviewtype = :type and q.hdzApplication.applicationid = :applicationid";
	        
	        try{
	            TypedQuery<HdzTest> query = em.createQuery(qString,HdzTest.class);
	            query.setParameter("type",string);
	            query.setParameter("applicationid",Long.parseLong(applicationid));
	            questions = query.getResultList();
	        }catch (Exception e){
	            e.printStackTrace();
	        }finally{
	            em.close();
	        }return questions;
	}

}
