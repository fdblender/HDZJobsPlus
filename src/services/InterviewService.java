package services;

import dao.InterviewDao;
import model.HdzApplication;

public class InterviewService {

	public static Object getCodingTest(String appid) {
		return InterviewDao.getCosingTest(appid);
	}

	public static HdzApplication getHdzApplication(String appid) {
		return InterviewDao.getHdzApplication(appid);
	}

	public static void updateCodingTest(HdzApplication hdzApplication) {
		InterviewDao.updateCodingTest(hdzApplication);
		
	}

}
