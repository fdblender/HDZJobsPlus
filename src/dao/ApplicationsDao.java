/**
 * @author Frances Blendermann
 * TO DO: TEST
 */
package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import model.HdzApplicant;
import model.HdzApplication;
import util.DBUtil;


public class ApplicationsDao {
	
	public static void update(HdzApplication application) {
		EntityManager em = DBUtil.getEmfFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		try {
			trans.begin();
			em.merge(application);
			trans.commit();
		} catch (Exception e) {
			trans.rollback();
		} finally {
			em.close();
		}
	}
	
	public static List<HdzApplication> getapplications(String position) {
		EntityManager em = DBUtil.getEmfFactory().createEntityManager();
		List<HdzApplication> app = null;
		String qString = "select b from HdzApplication b where lower(b.hdzJob.description) like :position";
       
		try {
			
			TypedQuery<HdzApplication> query = em.createQuery(qString, HdzApplication.class);
			query.setParameter("position", "%" + position.toLowerCase() + "%");
			app = query.getResultList();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
		}
		return app;
	}
	
	// TO DO: TEST THIS METHOD 
	public static List<HdzApplication> getapplicationsByApplicantid(String applicantid) {
		EntityManager em = DBUtil.getEmfFactory().createEntityManager();
		List<HdzApplication> app = null;
		String qString = "select b from HdzApplication b where b.hdzApplicant.applicantid = :applicantid";
       
		try {
			
			TypedQuery<HdzApplication> query = em.createQuery(qString, HdzApplication.class);
			query.setParameter("applicantid", Long.parseLong(applicantid));
			app = query.getResultList();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
		}
		return app;
	}

}
