package controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONException;
import org.json.JSONObject;

import dao.RoleActionDao;

/**
 * Servlet implementation class ActionSubmit
 */
@WebServlet("/ActionSubmit")
public class ActionSubmit extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ActionSubmit() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		HDZEmployee employee = (HDZEmployee)session.getAttribute("employee");
		String urlToRedirect = null;
		if (employee == null) {
			request.setAttribute("message", "Log in!!");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		} else {
			String role = (String) session.getAttribute("role");
			List<HDZApplication> hdzapplication = null;
			if (role.equals("ComplianceOfficer")) {				
				urlToRedirect = "/";
				
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
			
		JSONObject jobj = new JSONObject();
		
		try {
			jobj.put("url", urlToRedirect);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.getWriter().write(jobj.toString());
	}

}
