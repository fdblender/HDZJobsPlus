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

import model.HdzApplication;

/**
 * Servlet implementation class ViewApplications
 */
@WebServlet("/ViewApplications")
public class ViewApplications extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewApplications() {
        super();
        // TODO Auto-generated constructor stub
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
		
	
		
		
		try {
			
			//HttpSession session = request.getSession();
			String position = request.getParameter("position");
			List<HdzApplication> apps = ApplicationsDao.getapplications(position);
			if (apps== null || apps.size() ==0) {
				request.setAttribute("message", "No Results!!");
				request.setAttribute("applicationsSearch", null);
			} else {
				request.setAttribute("applicationsSearch", apps);
			}
			request.getRequestDispatcher("/PendingAction").forward(request, response);
		} catch (NullPointerException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
			
		}
	
	}

}
