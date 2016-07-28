package services;

import java.math.BigDecimal;
import java.util.List;

import dao.InterviewDao;
import model.HdzApplication;
import model.HdzJobquestion;
import model.HdzTest;

public class InterviewService {

	public static String getCodingTest(long id) {
		return InterviewDao.getCosingTest(id);
	}

	public static HdzApplication getHdzApplication(String appid) {
		return InterviewDao.getHdzApplication(appid);
	}

	public static void updateApplication(HdzApplication hdzApplication) {
		InterviewDao.updateApplication(hdzApplication);
		
	}

	public static String getComment(HdzApplication hdzApplication) {
		return InterviewDao.getComment(hdzApplication);
	}

	public static List<HdzJobquestion> getQuestions(HdzApplication hdzApplication, String role) {
		return InterviewDao.getQuestions(hdzApplication, role);
	}

	public static BigDecimal getScore(HdzApplication hdzApplication) {
		return InterviewDao.getScore(hdzApplication);
	}

	public static void InsertResponse(HdzTest test) {
		InterviewDao.InsertResponse(test);
		
	}

}
