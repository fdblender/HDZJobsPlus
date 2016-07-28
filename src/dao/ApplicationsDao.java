/**
 * @author Frances Blendermann
 */
package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import model.HdzApplication;
import util.DBUtil;


public class ApplicationsDao {
	public static List<HdzApplication> getapplications(String position) {
		EntityManager em = DBUtil.getEmfFactory().createEntityManager();
		List<HdzApplication> app = null;
		String qString = "select b from HdzApplication b where b.hdzJob.position like :position";
       
		try {
			
			TypedQuery<HdzApplication> query = em.createQuery(qString, HdzApplication.class);
			query.setParameter("position", "%" + position + "%");
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
			query.setParameter("applicantid", applicantid);
			app = query.getResultList();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
		}
		return app;
	}

}
