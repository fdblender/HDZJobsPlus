package services;


import model.HdzApplication;
import model.HdzEmployee;
import model.HdzJob;

import java.util.ArrayList;
import java.util.List;

import dao.PendingActionsDao;
import dao.RoleActionDao;

public class RoleActionService {

	public static List<HdzApplication> getActionsComplianceOfficer() {
		return RoleActionDao.getActionsComplianceOfficer(); 
	}

	public static List<HdzApplication> getActionsHRAssistant() {
		return RoleActionDao.getActionsHRAssistant(); 
	}

	public static List<HdzApplication> getActionsHRManager() {
		return RoleActionDao.getActionsHRManager(); 
	}

	public static List<HdzApplication> getActionsHRSpecialist() {
		return RoleActionDao.getActionsHRSpecialist();  
	}

	public static List<HdzApplication> getActionsHealthCareProfessional() {
		return RoleActionDao.getActionsHealthCareProfessional(); 
	}

	public static List<HdzApplication> getActionsHiringManager() {
		return RoleActionDao.getActionsHiringManager(); 
	}

	public static List<HdzApplication> getActionsEmployee() {
		return RoleActionDao.getActionsEmployee(); 
	}

	public static HdzEmployee getEmployee(String id) {
		return RoleActionDao.getEmployee(id); 
	}

	public static List<HdzJob> getActiveJobs() {
		return RoleActionDao.getActiveJobs(); 
	}

	public static List<HdzApplication> getActiveApplications(String jobId) {
		List<HdzApplication> applications = RoleActionDao.getActiveApplications(jobId); 
		List<HdzApplication> copyApplications = new ArrayList<HdzApplication>();
		for (HdzApplication h: applications) {
			if(!PendingActionsDao.checkAppStatus(h)) {
				copyApplications.add(h);
			}
		}
		if (applications.size() == copyApplications.size()) {
			return null;
		}
		applications.removeAll(copyApplications);		
		return applications; 
	}

	public static HdzJob getJob(String jobId) {
		return RoleActionDao.getJob(jobId); 
	}

}
