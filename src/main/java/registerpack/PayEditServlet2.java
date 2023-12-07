package registerpack;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/EditServlet2")
public class PayEditServlet2 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String sid = request.getParameter("id");
		int id = Integer.parseInt(sid);
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String passportid = request.getParameter("passportid");
		String cardname = request.getParameter("cardname");
		String cardnumber = request.getParameter("cardnumber");
		String amount = request.getParameter("amount");

		PayEmp e = new PayEmp();
		e.setId(id);
		e.setName(name);
		e.setEmail(email);
		e.setPassportid(passportid);
		e.setCardname(cardname);
		e.setCardnumber(cardnumber);
		e.setAmount(amount);

		int status = PayEmpDao.update(e);
		if (status > 0) {
			response.sendRedirect("ViewServlet"); 
		} else {
			out.println("Sorry! unable to update record");
		}

		out.close();
	}

}
