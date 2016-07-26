package services;


import model.HdzApplication;
import model.HdzEmployee;
import java.util.List;

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

}
