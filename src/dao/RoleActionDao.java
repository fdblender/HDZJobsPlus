package dao;


import model.HdzApplication;
import model.HdzEmployee;
import util.DBUtil;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class RoleActionDao {

	public static List<HdzApplication> getActionsComplianceOfficer() {
		EntityManager em = DBUtil.getEmfFactory().createEntityManager();
        List<HdzApplication> hdzApplications = null;
        String qString = "select b from HdzApplication b where b.appstatus <> :status"
        		+ " and b.hdzApplicant.citizenflag is null";
        
        try{
            TypedQuery<HdzApplication> query = em.createQuery(qString,HdzApplication.class);
            query.setParameter("status", "Fail");
            hdzApplications = query.getResultList();
        }catch (Exception e){
            e.printStackTrace();
        }
        finally{
                em.close();
            }
        return hdzApplications;  
	}

	public static List<HdzApplication> getActionsHRAssistant() {
		// get all applicants where status is new
		EntityManager em = DBUtil.getEmfFactory().createEntityManager();
        List<HdzApplication> hdzApplications = null;
        String qString = "select b from HdzApplication b where b.appstatus = :status";
        
        try{
            TypedQuery<HdzApplication> query = em.createQuery(qString,HdzApplication.class);
            query.setParameter("status", "New");
            hdzApplications = query.getResultList();
        }catch (Exception e){
            e.printStackTrace();
        }
        finally{
                em.close();
            }
        return hdzApplications;  
	}

	public static List<HdzApplication> getActionsHRManager() {
		// get all applicants where status is workReferenceChecked
		System.out.println("in getActionsHRManager");
		EntityManager em = DBUtil.getEmfFactory().createEntityManager();
        List<HdzApplication> hdzApplications = null;
        String qString = "select b from HdzApplication b where b.appstatus = :status";
        
        try{
            TypedQuery<HdzApplication> query = em.createQuery(qString,HdzApplication.class);
            query.setParameter("status", "WorkRefChecked");
            hdzApplications = query.getResultList();
        }catch (Exception e){
            e.printStackTrace();
        }
        finally{
                em.close();
            }
        return hdzApplications;  
	}

	public static List<HdzApplication> getActionsHRSpecialist() {
		// get all applicants where status not fail
		EntityManager em = DBUtil.getEmfFactory().createEntityManager();
        List<HdzApplication> hdzApplications = null;
        String qString = "select b from HdzApplication b where b.appstatus <> :status"
        		+ " and b.hdzApplicant.hdzEducations.educationflag is null";
        
        try{
            TypedQuery<HdzApplication> query = em.createQuery(qString,HdzApplication.class);
            query.setParameter("status", "Fail");
            hdzApplications = query.getResultList();
        }catch (Exception e){
            e.printStackTrace();
        }
        finally{
                em.close();
            }
        return hdzApplications;  
	}

	public static List<HdzApplication> getActionsHealthCareProfessional() {
		// get all applicants where status not fail
		EntityManager em = DBUtil.getEmfFactory().createEntityManager();
        List<HdzApplication> hdzApplications = null;
        String qString = "select b from HdzApplication b where b.appstatus <> :status";
        
        try{
            TypedQuery<HdzApplication> query = em.createQuery(qString,HdzApplication.class);
            query.setParameter("status", "Fail");
            hdzApplications = query.getResultList();
        }catch (Exception e){
            e.printStackTrace();
        }
        finally{
                em.close();
            }
        return hdzApplications;  
	}

	public static List<HdzApplication> getActionsHiringManager() {
		// get all applicants where status not HRInterviewDone
		EntityManager em = DBUtil.getEmfFactory().createEntityManager();
        List<HdzApplication> hdzApplications = null;
        String qString = "select b from HdzApplication b where b.appstatus = :status";
        
        try{
            TypedQuery<HdzApplication> query = em.createQuery(qString,HdzApplication.class);
            query.setParameter("status", "HRInterviewDone");
            hdzApplications = query.getResultList();
        }catch (Exception e){
            e.printStackTrace();
        }
        finally{
                em.close();
            }
        return hdzApplications;  
	}

	public static List<HdzApplication> getActionsEmployee() {
		// get all applicants where HiringManagerInterviewDone
		EntityManager em = DBUtil.getEmfFactory().createEntityManager();
        List<HdzApplication> hdzApplications = null;
        String qString = "select b from HdzApplication b where b.appstatus = :status";
        
        try{
            TypedQuery<HdzApplication> query = em.createQuery(qString,HdzApplication.class);
            query.setParameter("status", "HMInterviewDone");
            hdzApplications = query.getResultList();
        }catch (Exception e){
            e.printStackTrace();
        }
        finally{
                em.close();
            }
        return hdzApplications;  
	}

	public static HdzEmployee getEmployee(String id) {
		EntityManager em = DBUtil.getEmfFactory().createEntityManager();
		HdzEmployee hdzEmployee = null;
        String qString = "select b from HdzEmployee b where b.employeeid = :id";
        
        try{
            TypedQuery<HdzEmployee> query = em.createQuery(qString,HdzEmployee.class);
            query.setParameter("id", Long.parseLong(id));
            hdzEmployee = query.getSingleResult();
        }catch (Exception e){
            e.printStackTrace();
        }
        finally{
                em.close();
            }
        return hdzEmployee;  
	}

}
