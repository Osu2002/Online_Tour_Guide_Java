package registerpack;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SaveServlet")
public class PaySaveServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String passportid = request.getParameter("passportid");
		String cardname = request.getParameter("cardname");
		String cardnumber = request.getParameter("cardnumber");
		String amount = request.getParameter("amount");

		PayEmp e = new PayEmp();
		e.setName(name);
		e.setEmail(email);
		e.setPassportid(passportid);
		e.setCardname(cardname);
		e.setCardnumber(cardnumber);
		e.setAmount(amount);
		
		

		int status = PayEmpDao.save(e);
		if (status > 0) {
			out.print("<p>Record saved successfully!</p>");
			request.getRequestDispatcher("index.html").include(request, response);
		} else {
			out.println("Sorry! unable to save record");
		}

		out.close();
	}

}
