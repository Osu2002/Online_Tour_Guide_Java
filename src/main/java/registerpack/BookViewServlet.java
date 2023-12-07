package registerpack;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BookViewServlet")
public class BookViewServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.print("<title>Booking List</title>");
		out.println("<a href='book.html'>Bookings</a>");
		out.println("<h1>Booking List</h1>");

		List<Book> list = BookDao.getAllEmployees();

		out.print("<table border='2' style='font-family: arial, sans-serif;\r\n" + "  border-collapse: collapse;\r\n"
				+ "  width: 100%;' ");
		out.print(
				"<tr><th>Id</th><th>FName</th><th>Lname</th><th>Address</th><th>City</th><th>State</th><th>postalcode</th><th>Country</th><th>email</th><th>phone</th><th>chekin</th><th>checkout</th><th>person coun</th><th>Room Type</th><th>Edit</th><th>Delete</th></tr>");
		for (Book e : list) {
			out.print("<tr><td>" + e.getId() + "</td><td>" + e.getFname() + "</td><td>" + e.getLname() + "</td><td>"
					+ e.getAddress() + "</td><td>" + e.getCity() + "</td><td>" + e.getState() + "</td><td>"
					+ e.getPostalcode() + "</td><td>" + e.getCountry() + "</td><td>" + e.getEmail() + "</td><td>"
					+ e.getPhone() + "</td><td>" + e.getCheckin() + "</td><td>" + e.getCheckout() + "</td><td>"
					+ e.getPerson() + "</td><td>" + e.getRoomtype() + "</td><td><a href='BookEditServlet?id="
					+ e.getId() + "'>edit</a></td><td><a href='BookDeleteServlet?id=" + e.getId()
					+ "'>delete</a></td></tr>");
		}
		out.print("</table>");

		out.close();
	}
}
