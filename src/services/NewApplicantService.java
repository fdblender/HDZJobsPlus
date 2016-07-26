package services;
import dao.ApplicantDao;
import model.HdzApplicant;
public class NewApplicantService {
	public NewApplicantService(){
		
	}
	public static void insertApplicant(HdzApplicant applicant){
		ApplicantDao.insert(applicant);
	}
}
