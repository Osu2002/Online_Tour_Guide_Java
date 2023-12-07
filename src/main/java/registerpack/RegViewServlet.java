package registerpack;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RegViewServlet")


public class RegViewServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		// Start HTML structure and define some CSS styles
		out.print("<html><head><title>Booking List</title>");
		out.print("<style>");
		out.print("body {");
		out.print("  font-family: Arial, sans-serif;");
		out.print("  background-color: #f5f5f5;");
		out.print("  text-align: center;");
		out.print("  margin: 0;");
		out.print("  padding: 0;");
		out.print("}");
		out.print(".backGround{");
		out.print("background-image: url(\"images/galle.jpg\");");
		out.print(" position: fixed; ");
		out.print("  height: 100%;");
		out.print("top: 0;");
		out.print("left: 0;");
		out.print(" width: 100%;");
		out.print("min-height: 100vh; ");
		out.print("background-repeat: repeat;");
		out.print("background-size: cover;");
		out.print("z-index: -1;");
		out.print("filter: blur(4px);");
		out.print(" }");
		out.print("h1 {");
		out.print("  color: #007BF;");
		out.print("}");
		out.print("a {");
		out.print("  text-decoration: none;");
		out.print("  color: #007BFF;");
		out.print("  margin: 10px;");
		out.print("}");
		out.print("table {");
		out.print("  font-family: Arial, sans-serif;");
		out.print("  border-collapse: collapse;");
		out.print("  width: 100%;");
		out.print("}");
		out.print("th {");
		out.print("  background-color: #007BFF;");
		out.print("  color: #fff;");
		out.print("}");
		out.print("th, td {");
		out.print("  border: 1px solid #ddd;");
		out.print("  padding: 8px;");
		out.print("  text-align: center;");
		out.print("}");
		out.print("tr:nth-child(even) {");
		out.print("  background-color: #f2f2f2;");
		out.print("}");
		out.print("tr:hover {");
		out.print("  background-color: #ddd;");
		out.print("}");
		out.print("</style>");
		out.print("</head><body>");
		out.print("<div class=\"backGround\"></div>");
		
		// Create navigation links and page header
		out.println("<a href='reg.html'>User Registration</a>");
		out.println("<h1>Users</h1>");

		// Retrieve a list of user registration records from the database
		List<Reg> list = RegDao.getAllEmployees();

		// Generate an HTML table to display the records
		out.print("<table>");
		out.print(
				"<tr><th>Id</th><th>First Name</th><th>Last Name</th><th>NIC</th><th>Email</th><th>Password</th><th>Repassword</th><th>Phone</th><th>DOB</th><th>Country</th><th>Edit</th><th>Delete</th></tr>");
		for (Reg e : list) {
			out.print("<tr><td>" + e.getId() + "</td><td>" + e.getFristname() + "</td><td>" + e.getLastname()
					+ "</td><td>" + e.getNic() + "</td><td>" + e.getEmail() + "</td><td>" + e.getPassword()
					+ "</td><td>" + e.getRepassword() + "</td><td>" + e.getPhone() + "</td><td>" + e.getDob()
					+ "</td><td>" + e.getCountry() + "</td><td><a href='RegEditServlet?id=" + e.getId()
					+ "'>edit</a></td><td><a href='RegDeleteServlet?id=" + e.getId() + "'>delete</a></td></tr>");
		}
		out.print("</table>");
		
		 // Close HTML structure
		out.print("</body></html>");
		out.close();
	}
}
