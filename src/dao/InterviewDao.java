package dao;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import model.HdzApplicant;
import model.HdzApplication;
import model.HdzJob;
import model.HdzJobquestion;
import model.HdzTest;
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
        	return null;
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
            return null;
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
            return null;
        }
        finally{
                em.close();
            }
        return comment;
		
	}

	public static List<HdzJobquestion> getQuestions(HdzApplication hdzApplication, String role) {
		EntityManager em = DBUtil.getEmfFactory().createEntityManager();
		List<HdzJobquestion> questions = null;
        String qString = "select b from HdzJobquestion b where b.interviewtype = :type";
        
        try{
            TypedQuery<HdzJobquestion> query = em.createQuery(qString,HdzJobquestion.class);
            query.setParameter("type", role);
            questions = query.setFirstResult(0).setMaxResults(10).getResultList();
        }catch (Exception e){
            return null;
        }
        finally{
                em.close();
            }
        return questions;
	}

	public static BigDecimal getScore(HdzApplication hdzApplication) {
		EntityManager em = DBUtil.getEmfFactory().createEntityManager();
		BigDecimal score = null;
        String qString = "select b.score from HdzApplication b where b.applicationid = :id";
        
        try{
            TypedQuery<BigDecimal> query = em.createQuery(qString,BigDecimal.class);
            query.setParameter("id", hdzApplication.getApplicationid());
            score = query.getSingleResult();
        }catch (Exception e){
            return null;
        }
        finally{
                em.close();
            }
        return score;
	}

	public static void InsertResponse(HdzTest test) {
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

	public static void updateJob(HdzJob jobUpdate) {
		EntityManager em = DBUtil.getEmfFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        try {
            trans.begin();
            em.merge(jobUpdate);
            trans.commit();
        } catch (Exception e) {
            trans.rollback();
        } finally {
            em.close();
        }
		
	}

	public static List<HdzApplicant> getSkilledApplicants(String jobId) {
		EntityManager em = DBUtil.getEmfFactory().createEntityManager();
		List<HdzApplicant> applicants = null;
        String qString = "select distinct b.hdzApplicant from HdzApplicantskill b where b.skills in"
        		+ " (select a.jobskills from HdzJobskill a where a.hdzJob.jobsid = :id)";
        
        try{
            TypedQuery<HdzApplicant> query = em.createQuery(qString,HdzApplicant.class);
            query.setParameter("id", Long.parseLong(jobId));
            applicants = query.getResultList();
        }catch (Exception e){
            return null;
        }
        finally{
                em.close();
            }
        return applicants;
	}

	public static List<HdzApplicant> getSearchedApplicants(String skill, String experience) {
		EntityManager em = DBUtil.getEmfFactory().createEntityManager();
		List<HdzApplicant> applicants = null;
        String qString = "select distinct b.hdzApplicant from HdzApplicantskill b where b.skills = :skill"
        		+ " and b.experience >= :experience";
        
        try{
            TypedQuery<HdzApplicant> query = em.createQuery(qString,HdzApplicant.class);
            query.setParameter("skill", skill);
            query.setParameter("experience", new BigDecimal(experience));
            applicants = query.getResultList();
        }catch (Exception e){
            return null;
        }
        finally{
                em.close();
            }
        return applicants;
	}

	public static boolean checkPosition(HdzApplication hdzApplication) {
		EntityManager em = DBUtil.getEmfFactory().createEntityManager();
		String position = null;
        String qString = "select  b.hdzJob.hdzPosition.positiontype from HdzApplication b "
        		+ "where b.applicationid = :id";
        
        try{
            TypedQuery<String> query = em.createQuery(qString,String.class);
            query.setParameter("id", hdzApplication.getApplicationid());
            position = query.getSingleResult();
        }catch (Exception e){
            return false;
        }
        finally{
                em.close();
            }
        return (position.equals("developer"));
	}
	


}
