package registerpack;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RegSaveServlet")
public class RegSaveServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		// Retrieve user registration information from the request
		String fristname = request.getParameter("fristname");
		String lastname = request.getParameter("lastname");
		String nic = request.getParameter("nic");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String repassword = request.getParameter("repassword");
		String phone = request.getParameter("phone");
		String dob = request.getParameter("dob");
		String country = request.getParameter("country");

		// Create a new 'Reg' object and set its properties
		Reg e = new Reg();

		e.setFristname(fristname);
		e.setLastname(lastname);
		e.setNic(nic);
		e.setEmail(email);
		e.setPassword(password);
		e.setRepassword(repassword);
		e.setPhone(phone);
		e.setDob(dob);
		e.setCountry(country);

		// Attempt to save the user registration information to the database
		int status = RegDao.save(e);
		if (status > 0) {
			// If the save operation is successful, redirect to "RegViewServlet"
            // and display a success message
			response.sendRedirect("reg.html");
			out.print("<p>Record saved successfully!</p>");
			request.getRequestDispatcher("reg.html").include(request, response);
		} else {
			// If the save operation fails, display an error message
			out.println("Sorry! unable to save record");
		}

		out.close();
	}

}
