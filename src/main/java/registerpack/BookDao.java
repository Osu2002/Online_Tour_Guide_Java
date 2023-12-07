package registerpack;

import java.util.*;
import java.sql.*;

public class BookDao {
	
	// Establish a database connection

	public static Connection getConnection() {
		Connection con = null;
		try {                     // Load the MySQL JDBC driver and establish a connection
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tour", "root", "1234");
		} catch (Exception e) {
			System.out.println(e);
		}
		return con;
	}

	public static int save(Book e) {
		// Save a booking record to the database
		int status = 0;
		try {
			Connection con = BookDao.getConnection();
			PreparedStatement ps = con.prepareStatement(
					"insert into book(Fname,Lname,address,city,state,postalcode,country,email,phone,checkin,checkout,person,roomtype) values (?,?,?,?,?,?,?,?,?,?,?,?,?)");
			ps.setString(1, e.getFname());
			ps.setString(2, e.getLname());
			ps.setString(3, e.getAddress());
			ps.setString(4, e.getCity());
			ps.setString(5, e.getState());
			ps.setString(6, e.getPostalcode());
			ps.setString(7, e.getCountry());
			ps.setString(8, e.getEmail());
			ps.setString(9, e.getPhone());
			ps.setString(10, e.getCheckin());
			ps.setString(11, e.getCheckout());
			ps.setString(12, e.getPerson());
			ps.setString(13, e.getRoomtype());

			status = ps.executeUpdate();

			con.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return status;
	}

	public static int update(Book e) {
		int status = 0;
		try {
			Connection con = BookDao.getConnection();
			PreparedStatement ps = con.prepareStatement(
					"update book set Fname=?,Lname=?,address=?,city=?,state=?,postalcode=?,country=?,email=?,phone=?,checkin=?,checkout=?,person=?,roomtype=? where id=?");
			ps.setString(1, e.getFname());
			ps.setString(2, e.getLname());
			ps.setString(3, e.getAddress());
			ps.setString(4, e.getCity());
			ps.setString(5, e.getState());
			ps.setString(6, e.getPostalcode());
			ps.setString(7, e.getCountry());
			ps.setString(8, e.getEmail());
			ps.setString(9, e.getPhone());
			ps.setString(10, e.getCheckin());
			ps.setString(11, e.getCheckout());
			ps.setString(12, e.getPerson());
			ps.setString(13, e.getRoomtype());
			ps.setInt(14, e.getId());

			status = ps.executeUpdate();

			con.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return status;
	}

	public static int delete(int id) {
		int status = 0;
		try {
			Connection con = BookDao.getConnection();
			PreparedStatement ps = con.prepareStatement("delete from book where id=?");
			ps.setInt(1, id);
			status = ps.executeUpdate();

			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return status;
	}

	public static Book getEmployeeById(int id) {
		Book e = new Book();

		try {
			Connection con = BookDao.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from book where id=?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				e.setId(rs.getInt(1));
				e.setFname(rs.getString(2));
				e.setLname(rs.getString(3));
				e.setAddress(rs.getString(4));
				e.setCity(rs.getString(5));
				e.setState(rs.getString(6));
				e.setPostalcode(rs.getString(7));
				e.setCountry(rs.getString(8));
				e.setEmail(rs.getString(9));
				e.setPhone(rs.getString(10));
				e.setCheckin(rs.getString(11));
				e.setCheckout(rs.getString(12));
				e.setPerson(rs.getString(13));
				e.setRoomtype(rs.getString(14));
			}
			con.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return e;
	}

	public static List<Book> getAllEmployees() {
		List<Book> list = new ArrayList<Book>();

		try {
			Connection con = BookDao.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from book");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Book e = new Book();
				e.setId(rs.getInt(1));
				e.setFname(rs.getString(2));
				e.setLname(rs.getString(3));
				e.setAddress(rs.getString(4));
				e.setCity(rs.getString(5));
				e.setState(rs.getString(6));
				e.setPostalcode(rs.getString(7));
				e.setCountry(rs.getString(8));
				e.setEmail(rs.getString(9));
				e.setPhone(rs.getString(10));
				e.setCheckin(rs.getString(11));
				e.setCheckout(rs.getString(12));
				e.setPerson(rs.getString(13));
				e.setRoomtype(rs.getString(14));
				list.add(e);
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}
}
