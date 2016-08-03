package controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ApplicationsDao;
import model.HdzApplicant;
import model.HdzApplication;
import model.HdzPosition;

/**
 * Servlet implementation class YourApplications
 * 
 * @author Frances Blendermann
 */
@WebServlet("/YourApplications")
public class YourApplications extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public YourApplications() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {

			HttpSession session = request.getSession();
			String nextURL = "yourapplications.jsp";
			HdzApplicant applicant = (HdzApplicant) session.getAttribute("user");
			List<HdzApplication> applications = null;
			HdzPosition position;

			request.setAttribute("pendingcodingtest", "no");

			if (applicant == null) {
				request.setAttribute("message", "Please login in!");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			} else {
				
				// get all applications for applicantid
				applications = ApplicationsDao.getapplicationsByApplicantid(applicant.getApplicantid() + "");
				request.setAttribute("yourApps", applications);
				
				// determine if there is a pending coding test
				for (HdzApplication application : applications) {
					
					if (!application.getAppstatus().equals("Fail") && application.getCodingtest().equals("G")) {
						position = application.getHdzJob().getHdzPosition();
						
						if (position.getPositiontype() != null) {
							if (position.getPositiontype().equals("developer")) {
								
								// if the position is a developer position, 
								// set the attribute for pending coding test
								request.setAttribute("pendingcodingtest", "yes");
								nextURL = "yourapplications.jsp";
								break;
							}
						}
					}
				}

				request.getRequestDispatcher(nextURL).forward(request, response);
			}

		} catch (Exception e) {
			request.getRequestDispatcher("error.jsp").forward(request, response);
		}
	}

}
