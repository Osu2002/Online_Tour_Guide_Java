package registerpack;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RegDeleteServlet")
public class RegDeleteServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// Retrieve the 'id' parameter from the request
		String sid = request.getParameter("id");
		int id = Integer.parseInt(sid);
		
		// Delete the user registration record with the specified 'id'
		RegDao.delete(id);
		 // Redirect to the "RegViewServlet" to view the updated user registration list
		response.sendRedirect("RegViewServlet");
	}
}
