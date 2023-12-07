package registerpack;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BookEditServlet")
public class BookEditServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<h1>Update Booking</h1>");
		String sid = request.getParameter("id");
		int id = Integer.parseInt(sid);

		Book e = BookDao.getEmployeeById(id);

		out.print("<form action='BookEditServlet2' method='post'>");
		out.print("<table>");
		out.print("<tr><td></td><td><input type='hidden' name='id' value='" + e.getId() + "'/></td></tr>");
		out.print(
				"<tr><td>Frist name:</td><td><input type='text' name='Fname' value='" + e.getFname() + "'/></td></tr>");
		out.print(
				"<tr><td>Last name:</td><td><input type='text' name='Lname' value='" + e.getLname() + "'/></td></tr>");
		out.print("<tr><td>Address:</td><td><input type='text' name='address' value='" + e.getAddress()
				+ "'/></td></tr>");

		out.print("<tr><td>City:</td><td><input type='text' name='city' value='" + e.getCity() + "'/></td></tr>");
		out.print("<tr><td>State:</td><td><input type='text' name='state' value='" + e.getState() + "'/></td></tr>");
		out.print("<tr><td>Postal code:</td><td><input type='text' name='postalcode' value='" + e.getPostalcode()
				+ "'/></td></tr>");

		out.print("<tr><td>Country:</td><td><input type='text' name='country' value='" + e.getCountry()
				+ "'/></td></tr>");
		out.print("<tr><td>Email:</td><td><input type='email' name='email' value='" + e.getEmail() + "'/></td></tr>");
		out.print("<tr><td>Phone:</td><td><input type='tel' name='phone' value='" + e.getPhone() + "'/></td></tr>");

		out.print("<tr><td>Check in:</td><td><input type='date' name='checkin' value='" + e.getCheckin()
				+ "'/></td></tr>");
		out.print("<tr><td>Check out:</td><td><input type='date' name='checkout' value='" + e.getCheckout()
				+ "'/></td></tr>");
		out.print("<tr><td>Person count:</td><td><input type='number' name='person' value='" + e.getPerson()
				+ "'/></td></tr>");

		out.print("<tr><td>Room type:</td><td>");
		out.print("<select name='roomtype' style='width:150px'>");
		out.print("<option>single</option>");
		out.print("<option>Double</option>");
		out.print("<option>Suit</option>");
		out.print("</select>");
		out.print("</td></tr>");
		out.print("<tr><td colspan='2'><input type='submit' value='Edit &amp; Save '/></td></tr>");
		out.print("</table>");
		out.print("</form>");

		out.close();
	}
}
