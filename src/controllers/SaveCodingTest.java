/**
 * @author: Frances Blendermann
 */
package controllers;

import java.io.IOException;
import java.util.List;

import javax.mail.MessagingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ApplicationsDao;
import dao.TestsDao;
import model.HdzApplicant;
import model.HdzApplication;
import model.HdzJobquestion;
import model.HdzPosition;
import model.HdzTest;
import util.Email;

/**
 * Servlet implementation class EvaluateCompletedTest
 */
@WebServlet("/SaveCodingTest")
public class SaveCodingTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SaveCodingTest() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("in SaveCodingTest");
		HttpSession session = request.getSession();		
		HdzApplicant applicant = (HdzApplicant)session.getAttribute("user");		
		List<HdzApplication> applications = null;
		HdzPosition position;		
		boolean notestsfound = true;
		
		if (applicant == null) {
			request.setAttribute("message", "Please login in!");			
			request.getRequestDispatcher("login.jsp").forward(request, response);
		} else {	
			// get all applications for applicantid
			applications = ApplicationsDao.getapplicationsByApplicantid(applicant.getApplicantid()+"");		
			for (HdzApplication application : applications) {	
				System.out.println("application: "+application.getHdzJob().getHdzPosition().getPosition());
				
				// if the application has not failed and the application coding flag = 'G' (assigned)				
				if (!application.getAppstatus().equals("Fail") && application.getCodingtest().equals("G")) {
					position = application.getHdzJob().getHdzPosition();
					if (position.getPositiontype().equals("developer")) {
						
						// update the application
						application.setCodingtest("C");
						System.out.println("Setting codingtest='c' for Position type: "+position.getPositiontype());
						ApplicationsDao.update(application);
						
						// create and insert a new test response
						HdzTest test = new HdzTest();
						test.setCodinglanguage(request.getParameter("codinglanguage"));
						test.setHdzApplication(application);
						test.setTestresponse(request.getParameter("response"));	
						System.out.println(request.getParameter("questionid"));
						// get and set the job question for the job question id parameter
						HdzJobquestion question = TestsDao.getJobQuestion(request.getParameter("questionid"));
						
						test.setHdzJobquestion(question);
						
						// add the response to the tests table											
						TestsDao.insertTest(test);	
						try {
							Email.sendEmail("study.javaclass@gmail.com", "study.javaclass@gmail.com",
									"Coding Test Challenge Completed",
									"<html>Hi,<br/><br/> "
											+  application.getHdzApplicant().getFirstname() + 
											" completed his coding challenge. Pleae take it."
											+ "<br/><br/> Thanks,<br/>HDZ Team</html>",
									true);
						} catch (MessagingException e) {
							e.printStackTrace();
						}
						notestsfound = false;
					}
				}
			}		
		}
		
		if (notestsfound) {
			request.setAttribute("message", "No tests found.");
		}
		request.getRequestDispatcher("YourApplications").forward(request, response);		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
