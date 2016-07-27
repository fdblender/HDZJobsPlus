import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import dao.ApplicantDao;
import model.HdzJob;

public class applicantTest {

	@Test
	public void searchTest() {
		
		List<HdzJob> jobs = ApplicantDao.searchJobs("Hardware");
		
		assertTrue(jobs.get(0).getPosition().contains("Hardware"));
	}
}
