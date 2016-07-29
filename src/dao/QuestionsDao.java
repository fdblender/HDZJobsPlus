package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import model.HdzJob;
import model.HdzJobquestion;
import model.HdzTest;
import util.DBUtil;

public class QuestionsDao {

	public static List<HdzJobquestion> getQuestionList(String string) {
		
	        EntityManager em = DBUtil.getEmfFactory().createEntityManager();
	        List<HdzJobquestion> questions = null;
	        String qString = "select q.hdzJobquestion from HdzTest q where q.hdzJobquestion.interviewtype = :type";
	        
	        try{
	            TypedQuery<HdzJobquestion> query = em.createQuery(qString,HdzJobquestion.class);
	            query.setParameter("type",string);
	            questions = query.getResultList();
	        }catch (Exception e){
	            e.printStackTrace();
	        }finally{
	            em.close();
	        }return questions;
	}

}
