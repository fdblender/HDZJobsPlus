package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.RoleActionDao;

/**
 * Servlet implementation class PendingAction
 */
@WebServlet("/PendingAction")
public class PendingAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PendingAction() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		HDZEmployee employee = (HDZEmployee)session.getAttribute("employee");
		if (employee == null) {
			request.setAttribute("message", "Log in!!");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		} else {
			String role = (String) session.getAttribute("role");
			if (role.equals("ComplianceOfficer")) {
				session.setAttribute("HR", "No");
				List<HDZApplication> hdzapplication = RoleActionDao.getActionsComplianceOfficer();
				
			} else if (role.equals("HRAssistant")) {
				session.setAttribute("HR", "Yes");
				List<HDZApplication> hdzapplication = RoleActionDao.getActionsHRAssistant();
				
			} else if (role.equals("HRManager")) {
				session.setAttribute("HR", "Yes");
				List<HDZApplication> hdzapplication = RoleActionDao.getActionsHRManager();
				
			} else if (role.equals("HRSpecialist")) {
				session.setAttribute("HR", "Yes");
				List<HDZApplication> hdzapplication = RoleActionDao.getActionsHRSpecialist();
				
			} else if (role.equals("HealthCareProfessional")) {
				session.setAttribute("HR", "No");
				List<HDZApplication> hdzapplication = RoleActionDao.getActionsHealthCareProfessional();
				
			} else if (role.equals("HiringManager")) {
				session.setAttribute("HR", "Yes");
				List<HDZApplication> hdzapplication = RoleActionDao.getActionsHiringManager();
				
			} else if (role.equals("Employee")) {
				session.setAttribute("HR", "No");
				List<HDZApplication> hdzapplication = RoleActionDao.getActionsEmployee();
				
			}
			request.getRequestDispatcher("pendingAction.jsp").forward(request, response);
		}
	}

}
