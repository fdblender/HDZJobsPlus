package dao;


import model.HdzApplication;
import model.HdzEmployee;
import model.HdzJob;
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
           return null;
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
        String qString = "select b from HdzApplication b where b.appstatus = :status "
        		+ "and b.hdzApplicant.workrefflag is null";
        
        try{
            TypedQuery<HdzApplication> query = em.createQuery(qString,HdzApplication.class);
            query.setParameter("status", "New");
            hdzApplications = query.getResultList();
        }catch (Exception e){
           return null;
        }
        finally{
                em.close();
            }
        return hdzApplications;  
	}

	public static List<HdzApplication> getActionsHRManager() {
		// get all applicants where status is workReferenceChecked
		EntityManager em = DBUtil.getEmfFactory().createEntityManager();
        List<HdzApplication> hdzApplications = null;
        String qString = "select b from HdzApplication b where b.appstatus = :status";
        
        try{
            TypedQuery<HdzApplication> query = em.createQuery(qString,HdzApplication.class);
            query.setParameter("status", "WorkRefChecked");
            hdzApplications = query.getResultList();
        }catch (Exception e){
           return null;
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
        		+ " and b.hdzApplicant.applicantid in "
        		+ " (select a.hdzApplicant.applicantid from HdzEducation a"
        		+ " where a.educationflag is null)";
        
        try{
            TypedQuery<HdzApplication> query = em.createQuery(qString,HdzApplication.class);
            query.setParameter("status", "Fail");
            hdzApplications = query.getResultList();
        }catch (Exception e){
           return null;
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
        String qString = "select b from HdzApplication b where b.appstatus <> :status"
        		+ " and (b.hdzApplicant.dottestflag is null"
        		+ " or b.hdzApplicant.dottestflag is null"
        		+ " or b.hdzApplicant.drugtestflag is null"
        		+ " or b.hdzApplicant.alcoholtestflag is null"
        		+ " or b.hdzApplicant.stdpanelflag is null)";
        
        try{
            TypedQuery<HdzApplication> query = em.createQuery(qString,HdzApplication.class);
            query.setParameter("status", "Fail");
            hdzApplications = query.getResultList();
        }catch (Exception e){
           return null;
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
           return null;
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
        String qString = "select b from HdzApplication b where b.appstatus = :status"
        		+ " and (b.codingtest = :test or b.hdzJob.hdzPosition.positiontype <> :position)";
        
        try{
            TypedQuery<HdzApplication> query = em.createQuery(qString,HdzApplication.class);
            query.setParameter("status", "HMInterviewDone");
            query.setParameter("test", "C");
            query.setParameter("position", "developer");
            hdzApplications = query.getResultList();
        }catch (Exception e){
           return null;
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
           return null;
        }
        finally{
                em.close();
            }
        return hdzEmployee;  
	}

	public static List<HdzJob> getActiveJobs() {
		EntityManager em = DBUtil.getEmfFactory().createEntityManager();
		List<HdzJob> jobs = null;
        String qString = "select distinct b.hdzJob from HdzApplication b "
        		+ "where b.hdzJob.numberopenings <> 0";        
        try{
            TypedQuery<HdzJob> query = em.createQuery(qString,HdzJob.class);
            jobs = query.getResultList();
        }catch (Exception e){
           return null;
        }
        finally{
                em.close();
            }
        return jobs;
	}

	public static List<HdzApplication> getActiveApplications(String jobId) {
		EntityManager em = DBUtil.getEmfFactory().createEntityManager();
		List<HdzApplication> applications = null;
        String qString = "select b from HdzApplication b where b.hdzJob.jobsid = :id";
        
        try{
            TypedQuery<HdzApplication> query = em.createQuery(qString,HdzApplication.class);
            query.setParameter("id", Long.parseLong(jobId));
            applications = query.getResultList();
        }catch (Exception e){
           return null;
        }
        finally{
                em.close();
            }
        return applications;
	}

	public static HdzJob getJob(String jobId) {
		EntityManager em = DBUtil.getEmfFactory().createEntityManager();
		HdzJob job = null;
        String qString = "select b from HdzJob b where b.jobsid = :id";
        
        try{
            TypedQuery<HdzJob> query = em.createQuery(qString,HdzJob.class);
            query.setParameter("id", Long.parseLong(jobId));
            job = query.getSingleResult();
        }catch (Exception e){
           return null;
        }
        finally{
                em.close();
            }
        return job;
	}

}
