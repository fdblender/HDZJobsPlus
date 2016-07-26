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
		String qString = "select b from HdzApplication b where b.hdzJob.position = :position";
       
		try {
			
			TypedQuery<HdzApplication> query = em.createQuery(qString, HdzApplication.class);
            query.setParameter("position", position);
			app = query.getResultList();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
		}
		return app;
	}

}
