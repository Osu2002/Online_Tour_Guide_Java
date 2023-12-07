package registerpack;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ViewServlet")
public class PayViewServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		//out.println("<a href='index.html'>Add New Employee</a>");
		out.println("<h1>Payment Details</h1>");

		List<PayEmp> list = PayEmpDao.getAllEmployees();

		out.print("<table border='1' width='100%'  ");
		out.print(
				"<tr><th>Id</th><th>Name</th><th>Email</th><th>Passportid</th><th>Cardname</th><th>Cardnumber</th><th>Amount</th><th>Edit</th><th>Delete</th></tr>");
		for (PayEmp e : list) {
			out.print("<tr><td>" + e.getId() + "</td><td>" + e.getName() + "</td><td>" + e.getEmail() + "</td><td>"
					+ e.getPassportid() + "</td><td>" + e.getCardname() + "</td><td>" + e.getCardnumber() + "</td><td>"
					+ e.getAmount() + "</td><td><a href='EditServlet?id=" + e.getId()
					+ "'>edit</a></td><td><a href='DeleteServlet?id=" + e.getId() + "'>delete</a></td></tr>");
		}
		out.print("</table>");

		out.close();
	}
}
