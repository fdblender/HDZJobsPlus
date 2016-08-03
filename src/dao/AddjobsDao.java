package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import model.HdzJob;
import model.HdzPosition;
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
			e.printStackTrace();
			trans.rollback();
		} finally {
			em.close();
		}


	}

	public static HdzPosition checkPosition(String posit) {
		EntityManager em = DBUtil.getEmfFactory().createEntityManager();
        HdzPosition position = null;
        String qString = "select b from HdzPosition b where b.position = :pos";
        
        try{
            TypedQuery<HdzPosition> query = em.createQuery(qString,HdzPosition.class);
            query.setParameter("pos", posit);
            position = query.getSingleResult();
        }catch (Exception e){
           return null;
        }
        finally{
                em.close();
            }
        return position;  
	}

	public static void insertPosition(HdzPosition position) {
		EntityManager em = DBUtil.getEmfFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		try {
			trans.begin();
			em.persist(position);
			trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
		} finally {
			em.close();
		}
		
	}
}
