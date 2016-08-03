package controllers;

import java.io.IOException;

import javax.mail.MessagingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.InterviewDao;
import model.*;
import util.Email;

/**
 * Servlet implementation class DrugCheckForm
 * 
 * @author Xiao
 */
@WebServlet("/DrugCheckForm")
public class DrugCheckForm extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DrugCheckForm() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			HttpSession session = request.getSession();
			String stdid = request.getParameter("stdid");

			String dotid = request.getParameter("dotid");

			String alcoholid = request.getParameter("alcoholid");
			String applicationid = request.getParameter("applicationid");

			String stdcomment = request.getParameter("stdaddcomment");
			String dotcomment = request.getParameter("dotaddcomment");
			String alcoholcomment = request.getParameter("alcoholaddcomment");

			if (applicationid != null) {
				session.setAttribute("DrugApplicationid", applicationid);

				HdzApplication application = dao.PendingActionsDao.getapplicationbyappifDrugTest(applicationid);

				session.setAttribute("DrugApplication", application);

				request.getRequestDispatcher("drugscreencheck.jsp").forward(request, response);
			}

			if (stdid != null) {

				HdzApplicant applicant = dao.PendingActionsDao.getapplicantbyapplicantid(stdid);

				HdzApplication myapplication = dao.PendingActionsDao
						.getapplicationbyapplicationid(session.getAttribute("DrugApplicationid").toString());

				applicant.setStdpanelflag("Y");
				applicant.setDrugtestflag("N");

				dao.PendingActionsDao.update(applicant);

				session.setAttribute("DrugApplicant", applicant);

				myapplication.setAppstatus("Fail");
				dao.PendingActionsDao.update(myapplication);

				try {
					Email.sendEmail("study.javaclass@gmail.com", "study.javaclass@gmail.com", "Application status Info",
							"<html>Hi " + myapplication.getHdzApplicant().getFirstname() + ",<br/> "
									+ "We Regret to Inform you that we are not proceeding further with your Application at this point."
									+ "<br/> Thanks,<br/>HDZ Team</html>",
							true);
				} catch (MessagingException e) {
					
				}

				session.setAttribute("hiremessage", "The Application is Failed!!!!");

				if (stdcomment != null && !stdcomment.equals("")) {
					String old = InterviewDao.getComment(myapplication);
					if (old != null && !old.equals("")) {
						stdcomment = stdcomment + "<br/>" + old;
					}

					HdzEmployee user = (HdzEmployee) session.getAttribute("user");
					myapplication.setComments(user.getEmpname() + " (" + user.getPosition() + "): " + stdcomment);

					dao.PendingActionsDao.update(myapplication);

				}
				myapplication = dao.PendingActionsDao
						.getapplicationbyapplicationid(myapplication.getApplicationid() + "");
				session.setAttribute("DrugApplication", myapplication);

				request.getRequestDispatcher("drugscreencheck.jsp").forward(request, response);

			}

			if (dotid != null) {

				HdzApplicant applicant = dao.PendingActionsDao.getapplicantbyapplicantid(dotid);

				HdzApplication myapplication = dao.PendingActionsDao
						.getapplicationbyapplicationid(session.getAttribute("DrugApplicationid").toString());

				applicant.setDottestflag("Y");
				applicant.setDrugtestflag("N");

				dao.PendingActionsDao.update(applicant);
				session.setAttribute("DrugApplicant", applicant);
				myapplication.setAppstatus("Fail");
				dao.PendingActionsDao.update(myapplication);

				try {
					Email.sendEmail("study.javaclass@gmail.com", "study.javaclass@gmail.com", "Application status Info",
							"<html>Hi " + myapplication.getHdzApplicant().getFirstname() + ",<br/> "
									+ "We Regret to Inform you that we are not proceeding further with your Application at this point."
									+ "<br/> Thanks,<br/>HDZ Team</html>",
							true);
				} catch (MessagingException e) {
					
				}

				session.setAttribute("hiremessage", "The Application is Failed!!!!");

				if (dotcomment != null && !dotcomment.equals("")) {
					String old = InterviewDao.getComment(myapplication);
					if (old != null && !old.equals("")) {
						dotcomment = dotcomment + "<br/>" + old;
					}

					HdzEmployee user = (HdzEmployee) session.getAttribute("user");
					myapplication.setComments(user.getEmpname() + " (" + user.getPosition() + "): " + dotcomment);

					dao.PendingActionsDao.update(myapplication);

				}
				myapplication = dao.PendingActionsDao
						.getapplicationbyapplicationid(myapplication.getApplicationid() + "");
				session.setAttribute("DrugApplication", myapplication);

				request.getRequestDispatcher("drugscreencheck.jsp").forward(request, response);

			}
			if (alcoholid != null) {

				HdzApplicant applicant = dao.PendingActionsDao.getapplicantbyapplicantid(alcoholid);

				HdzApplication myapplication = dao.PendingActionsDao
						.getapplicationbyapplicationid(session.getAttribute("DrugApplicationid").toString());

				applicant.setAlcoholtestflag("Y");
				applicant.setDrugtestflag("N");

				dao.PendingActionsDao.update(applicant);
				session.setAttribute("DrugApplicant", applicant);
				myapplication.setAppstatus("Fail");
				dao.PendingActionsDao.update(myapplication);

				try {
					Email.sendEmail("study.javaclass@gmail.com", "study.javaclass@gmail.com", "Application status Info",
							"<html>Hi " + myapplication.getHdzApplicant().getFirstname() + ",<br/> "
									+ "We Regret to Inform you that we are not proceeding further with your Application at this point."
									+ "<br/> Thanks,<br/>HDZ Team</html>",
							true);
				} catch (MessagingException e) {
					
				}

				session.setAttribute("hiremessage", "The Application is Failed!!!!");

				if (alcoholcomment != null && !alcoholcomment.equals("")) {
					String old = InterviewDao.getComment(myapplication);
					if (old != null && !old.equals("")) {
						alcoholcomment = alcoholcomment + "<br/>" + old;
					}

					HdzEmployee user = (HdzEmployee) session.getAttribute("user");
					myapplication.setComments(user.getEmpname() + " (" + user.getPosition() + "): " + alcoholcomment);

					dao.PendingActionsDao.update(myapplication);

				}
				myapplication = dao.PendingActionsDao
						.getapplicationbyapplicationid(myapplication.getApplicationid() + "");
				session.setAttribute("DrugApplication", myapplication);

				request.getRequestDispatcher("drugscreencheck.jsp").forward(request, response);

			}
		} catch (Exception e) {
			request.getRequestDispatcher("/error.jsp").forward(request, response);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			HttpSession session = request.getSession();
			String stdid = request.getParameter("stdid");

			String dotid = request.getParameter("dotid");

			String alcoholid = request.getParameter("alcoholid");
			String applicationid = session.getAttribute("DrugApplicationid").toString();

			String stdcomment = request.getParameter("stdaddcomment");
			String dotcomment = request.getParameter("dotaddcomment");
			String alcoholcomment = request.getParameter("alcoholaddcomment");

			if (stdid != null) {
				session.setAttribute("hiremessage", null);
				HdzApplicant applicant = dao.PendingActionsDao.getapplicantbyapplicantid(stdid);
				HdzApplication myapplication = dao.PendingActionsDao.getapplicationbyapplicationid(applicationid);

				applicant.setStdpanelflag("N");

				dao.PendingActionsDao.update(applicant);

				session.setAttribute("DrugApplicant", applicant);

				if (applicant.getAlcoholtestflag() != null && applicant.getStdpanelflag() != null
						&& applicant.getDottestflag() != null) {
					if (applicant.getAlcoholtestflag().equals("N") && applicant.getStdpanelflag().equals("N")
							&& applicant.getDottestflag().equals("N")) {
						applicant.setDrugtestflag("Y");
						dao.PendingActionsDao.update(applicant);

						session.setAttribute("DrugApplicant", applicant);

						session.setAttribute("hiremessage", "The drug test is passed!!!!");
					}
				}
				if (dao.PendingActionsDao.checkAppStatus(myapplication)) {

					if (stdcomment != null && !stdcomment.equals("")) {
						String old = InterviewDao.getComment(myapplication);
						if (old != null && !old.equals("")) {
							stdcomment = stdcomment + "<br/>" + old;
						}

						HdzEmployee user = (HdzEmployee) session.getAttribute("user");
						myapplication.setComments(user.getEmpname() + " (" + user.getPosition() + "): " + stdcomment);

					}

					dao.PendingActionsDao.update(myapplication);
					myapplication = dao.PendingActionsDao
							.getapplicationbyapplicationid(myapplication.getApplicationid() + "");
					session.setAttribute("DrugApplication", myapplication);
				}

				if (stdcomment != null && !stdcomment.equals("")) {
					String old = InterviewDao.getComment(myapplication);
					if (old != null && !old.equals("")) {
						stdcomment = stdcomment + "<br/>" + old;
					}

					HdzEmployee user = (HdzEmployee) session.getAttribute("user");
					myapplication.setComments(user.getEmpname() + "(" + user.getPosition() + "): " + stdcomment);

					dao.PendingActionsDao.update(myapplication);

				}
				myapplication = dao.PendingActionsDao
						.getapplicationbyapplicationid(myapplication.getApplicationid() + "");
				session.setAttribute("DrugApplication", myapplication);

				request.getRequestDispatcher("drugscreencheck.jsp").forward(request, response);

			}

			if (dotid != null) {
				session.setAttribute("hiremessage", null);
				HdzApplicant applicant = dao.PendingActionsDao.getapplicantbyapplicantid(dotid);
				HdzApplication myapplication = dao.PendingActionsDao.getapplicationbyapplicationid(applicationid);

				applicant.setDottestflag("N");

				dao.PendingActionsDao.update(applicant);
				myapplication = dao.PendingActionsDao
						.getapplicationbyapplicationid(myapplication.getApplicationid() + "");
				session.setAttribute("DrugApplicant", applicant);

				if (applicant.getAlcoholtestflag() != null && applicant.getStdpanelflag() != null
						&& applicant.getDottestflag() != null) {
					if (applicant.getAlcoholtestflag().equals("N") && applicant.getStdpanelflag().equals("N")
							&& applicant.getDottestflag().equals("N")) {
						applicant.setDrugtestflag("Y");
						dao.PendingActionsDao.update(applicant);

						session.setAttribute("DrugApplicant", applicant);
						session.setAttribute("hiremessage", "The drug test is passed!!!!");

					}
				}

				if (dao.PendingActionsDao.checkAppStatus(myapplication)) {

					if (dotcomment != null && !dotcomment.equals("")) {
						String old = InterviewDao.getComment(myapplication);
						if (old != null && !old.equals("")) {
							dotcomment = dotcomment + "<br/>" + old;
						}

						HdzEmployee user = (HdzEmployee) session.getAttribute("user");
						myapplication.setComments(user.getEmpname() + " (" + user.getPosition() + "): " + dotcomment);

					}

					dao.PendingActionsDao.update(myapplication);
					myapplication = dao.PendingActionsDao
							.getapplicationbyapplicationid(myapplication.getApplicationid() + "");
					session.setAttribute("DrugApplication", myapplication);

				}

				if (dotcomment != null && !dotcomment.equals("")) {
					String old = InterviewDao.getComment(myapplication);
					if (old != null && !old.equals("")) {
						dotcomment = dotcomment + "<br/>" + old;
					}

					HdzEmployee user = (HdzEmployee) session.getAttribute("user");
					myapplication.setComments(user.getEmpname() + " (" + user.getPosition() + "): " + dotcomment);

					dao.PendingActionsDao.update(myapplication);

				}
				myapplication = dao.PendingActionsDao
						.getapplicationbyapplicationid(myapplication.getApplicationid() + "");
				session.setAttribute("DrugApplication", myapplication);

				request.getRequestDispatcher("drugscreencheck.jsp").forward(request, response);

			}

			if (alcoholid != null) {
				session.setAttribute("hiremessage", null);
				HdzApplicant applicant = dao.PendingActionsDao.getapplicantbyapplicantid(alcoholid);
				HdzApplication myapplication = dao.PendingActionsDao.getapplicationbyapplicationid(applicationid);

				applicant.setAlcoholtestflag("N");

				dao.PendingActionsDao.update(applicant);

				session.setAttribute("DrugApplicant", applicant);

				if (applicant.getAlcoholtestflag() != null && applicant.getStdpanelflag() != null
						&& applicant.getDottestflag() != null) {
					if (applicant.getAlcoholtestflag().equals("N") && applicant.getStdpanelflag().equals("N")
							&& applicant.getDottestflag().equals("N")) {
						applicant.setDrugtestflag("Y");
						dao.PendingActionsDao.update(applicant);

						session.setAttribute("DrugApplicant", applicant);
						session.setAttribute("hiremessage", "The drug test is passed!!!!");

					}
				}
				if (dao.PendingActionsDao.checkAppStatus(myapplication)) {

					if (alcoholcomment != null && !alcoholcomment.equals("")) {
						String old = InterviewDao.getComment(myapplication);
						if (old != null && !old.equals("")) {
							alcoholcomment = alcoholcomment + "<br/>" + old;
						}

						HdzEmployee user = (HdzEmployee) session.getAttribute("user");
						myapplication
								.setComments(user.getEmpname() + " (" + user.getPosition() + "): " + alcoholcomment);

					}

					dao.PendingActionsDao.update(myapplication);
					myapplication = dao.PendingActionsDao
							.getapplicationbyapplicationid(myapplication.getApplicationid() + "");
					session.setAttribute("DrugApplication", myapplication);

				}

				if (alcoholcomment != null && !alcoholcomment.equals("")) {
					String old = InterviewDao.getComment(myapplication);
					if (old != null && !old.equals("")) {
						alcoholcomment = alcoholcomment + "<br/>" + old;
					}

					HdzEmployee user = (HdzEmployee) session.getAttribute("user");
					myapplication.setComments(user.getEmpname() + " (" + user.getPosition() + "): " + alcoholcomment);

					dao.PendingActionsDao.update(myapplication);

				}
				myapplication = dao.PendingActionsDao
						.getapplicationbyapplicationid(myapplication.getApplicationid() + "");
				session.setAttribute("DrugApplication", myapplication);

				request.getRequestDispatcher("drugscreencheck.jsp").forward(request, response);

			}
		} catch (Exception e) {
			request.getRequestDispatcher("/error.jsp").forward(request, response);
		}
	}

}
