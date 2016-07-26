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
		HdzApplicant applicant =new HdzApplicant();
		applicant.setFirstname("Test");
		applicant.setLastname("Subject");
		applicant.setEmail("tes@test.com");
	ApplicantDao.insert(applicant);
	}
	

}
