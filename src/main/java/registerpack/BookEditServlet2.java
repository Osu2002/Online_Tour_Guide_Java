package registerpack;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BookEditServlet2")
public class BookEditServlet2 extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String sid = request.getParameter("id");
		int id = Integer.parseInt(sid);
		String Fname = request.getParameter("Fname");
		String Lname = request.getParameter("Lname");
		String address = request.getParameter("address");
		String city = request.getParameter("city");
		String state = request.getParameter("state");
		String postalcode = request.getParameter("postalcode");
		String country = request.getParameter("country");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String checkin = request.getParameter("checkin");
		String checkout = request.getParameter("checkout");
		String person = request.getParameter("person");
		String roomtype = request.getParameter("roomtype");

		Book e = new Book();
		e.setId(id);
		e.setFname(Fname);
		e.setLname(Lname);
		e.setAddress(address);
		e.setCity(city);
		e.setState(state);
		e.setPostalcode(postalcode);
		e.setCountry(country);
		e.setEmail(email);
		e.setPhone(phone);
		e.setCheckin(checkin);
		e.setCheckout(checkout);
		e.setPerson(person);
		e.setRoomtype(roomtype);

		int status = BookDao.update(e);
		if (status > 0) {
			response.sendRedirect("BookViewServlet");
		} else {
			out.println("Sorry! unable to update record");
		}

		out.close();
	}

}
