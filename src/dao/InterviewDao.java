package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import model.HdzApplication;
import util.DBUtil;

public class InterviewDao {

	public static String getCosingTest(long id) {
		EntityManager em = DBUtil.getEmfFactory().createEntityManager();
		String coding = null;
        String qString = "select b.codingtest from HdzApplication b where b.applicationid = :id";
        
        try{
            TypedQuery<String> query = em.createQuery(qString,String.class);
            query.setParameter("id",id);
            coding = query.getSingleResult();
        }catch (Exception e){
            e.printStackTrace();
        }
        finally{
                em.close();
            }
        return coding;  
	}

	public static HdzApplication getHdzApplication(String appid) {
		EntityManager em = DBUtil.getEmfFactory().createEntityManager();
		HdzApplication hdzApplication = null;
        String qString = "select b from HdzApplication b where b.applicationid = :id";
        
        try{
            TypedQuery<HdzApplication> query = em.createQuery(qString,HdzApplication.class);
            query.setParameter("id", Long.parseLong(appid));
            hdzApplication = query.getSingleResult();
        }catch (Exception e){
            e.printStackTrace();
        }
        finally{
                em.close();
            }
        return hdzApplication;  
	}

	public static void updateApplication(HdzApplication hdzApplication) {
		EntityManager em = DBUtil.getEmfFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        try {
            trans.begin();
            em.merge(hdzApplication);
            trans.commit();
        } catch (Exception e) {
            trans.rollback();
        } finally {
            em.close();
        }
		
	}

	public static String getComment(HdzApplication hdzApplication) {
		EntityManager em = DBUtil.getEmfFactory().createEntityManager();
		String comment = null;
        String qString = "select b.comments from HdzApplication b where b.applicationid = :id";
        
        try{
            TypedQuery<String> query = em.createQuery(qString,String.class);
            query.setParameter("id", hdzApplication.getApplicationid());
            comment = query.getSingleResult();
        }catch (Exception e){
            e.printStackTrace();
        }
        finally{
                em.close();
            }
        return comment;
		
	}

	public static List<HdzQuestions> getQuestions(HdzApplication hdzApplication, String role) {
		// TODO Auto-generated method stub
		return null;
	}

	public static Double getScore(HdzApplication hdzApplication) {
		// TODO Auto-generated method stub
		return null;
	}
	


}
