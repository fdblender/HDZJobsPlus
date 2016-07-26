package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import model.HdzJob;
import util.DBUtil;



public class AddjobsDao {
	
	public static void addjobs(HdzJob jobs) {
		EntityManager em = DBUtil.getEmfFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		try {
			trans.begin();
			em.persist(jobs);
			trans.commit();
		} catch (Exception e) {
			trans.rollback();
		} finally {
			em.close();
		}


	}
}
