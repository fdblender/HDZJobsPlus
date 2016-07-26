package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.HdzApplication;
import model.HdzEmployee;
import services.InterviewService;

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
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		System.out.println("in ");
		HdzEmployee employee = (HdzEmployee) session.getAttribute("user");
		String urlToRedirect = null;
		String appid = request.getParameter("applicationid");
		HdzApplication hdzApplication = InterviewService.getHdzApplication(appid);
		session.setAttribute("app", hdzApplication);
		if (employee == null) {
			request.setAttribute("message", "Log in!!");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		} else {
			String role = (String) session.getAttribute("role");
			System.out.println(role);
			session.setAttribute("applicationid", request.getAttribute("applicationid"));
			if (role.equals("ComplianceOfficer")) {
				urlToRedirect = "/Nationalityform";

			} else if (role.equals("HRAssistant")) {
				System.out.println("in Workhistoryreferenveform");
				urlToRedirect = "/Workhistoryreferenceform";

			} else if (role.equals("HRManager")) {
				urlToRedirect = "/InterviewForm";

			} else if (role.equals("HRSpecialist")) {
				urlToRedirect = "/EducationForm";

			} else if (role.equals("HealthCareProfessional")) {
				urlToRedirect = "/DrugCheckForm";

			} else if (role.equals("HiringManager")) {
				urlToRedirect = "/InterviewForm";

			} else if (role.equals("Employee")) {
				urlToRedirect = "/InterviewForm";
			}

			/*JSONObject jobj = new JSONObject();

			try {
				jobj.put("url", urlToRedirect);
			} catch (JSONException e) {
				request.setAttribute("message", "Something went wrong!!");
				request.getRequestDispatcher("error.jsp").forward(request, response);
			}
			response.getWriter().write(jobj.toString());*/
			request.getRequestDispatcher(urlToRedirect).forward(request, response);
		}
	}

}
