package controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.RoleActionDao;
import model.HdzApplication;
import model.HdzEmployee;

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
		HdzEmployee employee = (HdzEmployee)session.getAttribute("employee");
		employee = RoleActionDao.getEmployee((String) request.getAttribute("empid"));
		if (employee == null) {
			request.setAttribute("message", "Log in!!");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		} else {
			String role = (String) session.getAttribute("role");
			List<HdzApplication> hdzapplication = null;
			if (role.equals("ComplianceOfficer")) {
				session.setAttribute("HR", "No");
				hdzapplication = RoleActionDao.getActionsComplianceOfficer();
				
			} else if (role.equals("HRAssistant")) {
				session.setAttribute("HR", "Yes");
				hdzapplication = RoleActionDao.getActionsHRAssistant();
				
			} else if (role.equals("HRManager")) {
				session.setAttribute("HR", "Yes");
				hdzapplication = RoleActionDao.getActionsHRManager();
				
			} else if (role.equals("HRSpecialist")) {
				session.setAttribute("HR", "Yes");
				hdzapplication = RoleActionDao.getActionsHRSpecialist();
				
			} else if (role.equals("HealthCareProfessional")) {
				session.setAttribute("HR", "No");
				hdzapplication = RoleActionDao.getActionsHealthCareProfessional();
				
			} else if (role.equals("HiringManager")) {
				session.setAttribute("HR", "Yes");
				hdzapplication = RoleActionDao.getActionsHiringManager();
				
			} else if (role.equals("Employee")) {
				session.setAttribute("HR", "No");
				hdzapplication = RoleActionDao.getActionsEmployee();
				
			}
			session.setAttribute("actionList", hdzapplication);
			request.getRequestDispatcher("pendingAction.jsp").forward(request, response);
		}
	}

}
