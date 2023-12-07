package registerpack;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/EditServlet")
public class PayEditServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<h1>Update Employee</h1>");
		String sid = request.getParameter("id");
		int id = Integer.parseInt(sid);

		PayEmp e = PayEmpDao.getEmployeeById(id); 

		out.print("<form action='PayEditServlet2' method='post'>");
		out.print("<table>");
		out.print("<tr><td></td><td><input type='hidden' name='id' value='" + e.getId() + "'/></td></tr>");
		out.print("<tr><td>Name:</td><td><input type='text' name='name' value='" + e.getName() + "'/></td></tr>");
		
		out.print("<tr><td>Email:</td><td><input type='email' name='email' value='" + e.getEmail() + "'/></td></tr>");
		out.print("<tr><td>Passportid:</td><td><input type='text' name='passportid' value='" + e.getPassportid() + "'/></td></tr>");
		out.print("<tr><td>Cardname:</td><td><input type='password' name='cardname' value='" + e.getCardname()
				+ "'/></td></tr>");
		out.print("<tr><td>Cardnumber:</td><td><input type='text' name='cardnumber' value='" + e.getCardnumber() + "'/></td></tr>");
		out.print("<tr><td>Amount:</td><td><input type='text' name='amount' value='" + e.getAmount() + "'/></td></tr>");
		
		
		out.print("<tr><td colspan='2'><input type='submit' value='Edit &amp; Save '/></td></tr>");
		out.print("</table>");
		out.print("</form>");

		out.close();
	}
}
