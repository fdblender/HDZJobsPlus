package controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.HdzApplication;
import model.HdzEmployee;
import services.RoleActionService;

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
		String id = (String) request.getParameter("empid");
		System.out.println(id);
		employee = RoleActionService.getEmployee(id);
		session.setAttribute("employee", employee);
		session.setAttribute("role", employee.getPosition().replace(" ", ""));
		if (employee == null) {
			request.setAttribute("message", "Log in!!");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		} else {
			String role = (String) session.getAttribute("role");
			List<HdzApplication> hdzapplication = null;
			if (role.equals("ComplianceOfficer")) {
				session.setAttribute("HR", "No");
				hdzapplication = RoleActionService.getActionsComplianceOfficer();
				
			} else if (role.equals("HRAssistant")) {
				session.setAttribute("HR", "Yes");
				hdzapplication = RoleActionService.getActionsHRAssistant();
				
			} else if (role.equals("HRManager")) {
				session.setAttribute("HR", "Yes");
				hdzapplication = RoleActionService.getActionsHRManager();
				
			} else if (role.equals("HRSpecialist")) {
				session.setAttribute("HR", "Yes");
				hdzapplication = RoleActionService.getActionsHRSpecialist();
				
			} else if (role.equals("HealthCareProfessional")) {
				session.setAttribute("HR", "No");
				hdzapplication = RoleActionService.getActionsHealthCareProfessional();
				
			} else if (role.equals("HiringManager")) {
				session.setAttribute("HR", "Yes");
				hdzapplication = RoleActionService.getActionsHiringManager();
				
			} else if (role.equals("Employee")) {
				session.setAttribute("HR", "No");
				hdzapplication = RoleActionService.getActionsEmployee();
				
			}
			session.setAttribute("actionList", hdzapplication);
			request.getRequestDispatcher("pendingAction.jsp").forward(request, response);
		}
	}

}
