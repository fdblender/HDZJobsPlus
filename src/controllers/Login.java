package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ApplicantDao;
import dao.ValidateUserDao;
import model.HdzApplicant;
import model.HdzEmployee;

/**
 * Servlet implementation class Login
 * 
 * @author Frances Blendermann
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Login() {
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
			HdzApplicant applicant = null;
			HdzEmployee employee = null;
			String nextURL = "error.jsp";

			String email = request.getParameter("email");
			String password = request.getParameter("password");
			String loginrole = request.getParameter("loginrole");

			// validate an applicant login
			if (loginrole.equals("applicant")) {
				
				applicant = ValidateUserDao.getValidApplicant(email, password);

				if (applicant != null) {
					System.out.println("found valid user " + email + " " + password);
					session.setAttribute("user", applicant);
					session.setAttribute("role", "applicant");
					session.setAttribute("userrole", 1);
					nextURL = "YourApplications";
				} else {

					// if the applicant is not found, check to see if he/she is
					// an employee
					employee = ValidateUserDao.getValidEmployee(email, password);
					if (employee != null) {
						// add the employee as an applicant with same email &
						// password
						System.out.println("in empl");
						HdzApplicant hdzApplicant = ApplicantDao.AddApplicantAsEmployee(employee);
						session.setAttribute("user", hdzApplicant);
						session.setAttribute("role", "applicant");
						session.setAttribute("userrole", 1);
						nextURL = "YourApplications";
					} else {

						System.out.println("user not found: " + email + " " + password);
						request.setAttribute("message",
								"Applicant not found. Please login again or create a new account.");
						nextURL = "/login.jsp";
					}
				}

				// validate an employee login
			} else {

				System.out.println("Login: validating an employee " + email + " " + password);
				employee = ValidateUserDao.getValidEmployee(email, password);
				if (employee != null) {
					System.out.println("found valid user " + email + " " + password);
					session.setAttribute("user", employee);
					session.setAttribute("role", employee.getPosition().replaceAll(" ", ""));
					session.setAttribute("userrole", 2);
					nextURL = "/PendingAction";
				} else {
					request.setAttribute("message", "Employee not found. Please enter a valid email and password.");
					System.out.println("user not found: " + email + " " + password);
					nextURL = "/login.jsp";
				}
			}
			request.getRequestDispatcher(nextURL).forward(request, response);

		} catch (Exception e) {
			request.getRequestDispatcher("error.jsp").forward(request, response);
		}
	}

}
