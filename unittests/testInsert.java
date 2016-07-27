import static org.junit.Assert.*;

import org.junit.Test;

import model.HdzApplicant;
import model.HdzJob;
import dao.*;
public class testInsert {

	@Test
	public void test() {
//		HdzJob job= new HdzJob(); 
//		job.setDescription("great test job");
//		job.setPosition("manager");
//		AddjobsDao.addjobs(job);
		HdzApplicant applicant = new HdzApplicant();
		applicant.setFirstname("Test42");
		applicant.setLastname("Subject42");
		applicant.setEmail("test42subject42@test.com");
	ApplicantDao.insert(applicant);
	applicant.setBday("42-42-42");
	ApplicantDao.update(applicant);
	applicant=ApplicantDao.getApplicantByName("Test42", "Subject42");
	assertNotNull(applicant);
	}
	

}
