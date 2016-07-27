import static org.junit.Assert.*;

import org.junit.Test;

import dao.AddjobsDao;
import model.HdzJob;

public class testaddjobs {

	@Test
	public void test() {
		HdzJob jobs = new HdzJob();
		jobs.setPosition("Design Engineer");
		jobs.setDescription("Database");
		AddjobsDao.addjobs(jobs);
	}

}
