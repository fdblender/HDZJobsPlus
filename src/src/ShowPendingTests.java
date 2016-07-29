package src;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ApplicationsDao;
import dao.PendingTestsDao;
import model.HdzApplicant;
import model.HdzEmployee;

/**
 * Servlet implementation class ShowPendingTests
 */
@WebServlet("/ShowPendingTests")
public class ShowPendingTests extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowPendingTests() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("in ShowPendingTests");
		HttpSession session = request.getSession();
		HdzApplicant applicant = (HdzApplicant)session.getAttribute("user");
		String positionid = null; // should this be an integer?
		
		if (applicant == null) {
			request.setAttribute("message", "Log in!!");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		} else {	
		
		
		// get all applications for applicantid
		//	ApplicationsDao.getapplicationsByApplicantid(applicant.getApplicantid());
		
		// for each application
		//		if the application != fail and the application coding flag = 'g' (assigned) then
		//			save positionid = application.jobsid.positionid
		// 			get position type (application.jobsid.position.positiontype = "developer")
		//			if the position type = developer		
		//				get the first question from Jobsquestions for positionid = 
		//					and interviewtype = 'coding'
						PendingTestsDao.getPendingTests(positionid, "coding");
		
		
		}		
		
		// set url to showpendingtests
		
		request.getRequestDispatcher("pendingtests.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
