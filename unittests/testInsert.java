import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import model.HdzApplicant;
import model.HdzJob;
import dao.*;
public class testInsert {

	@Test
	public void test() {

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
	@Test 
	public void testAddJob(){
		HdzJob job= new HdzJob(); 
		job.setDescription("great test job 42");
		job.getHdzPosition().setPosition("manager");
		AddjobsDao.addjobs(job);
		List<HdzJob> jobs = ApplicantDao.searchJobs("great test job 42");
		assertNotNull(jobs);
	}
 @Test
 public void testAddSkill(){
	 System.out.println("Feature not yet implemented");
	 fail();
 }
}
