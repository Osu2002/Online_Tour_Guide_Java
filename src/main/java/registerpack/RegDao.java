package registerpack;

import java.util.*;
import java.sql.*;

public class RegDao {

	// Establishes a database connection and returns the connection object.
	public static Connection getConnection() {
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tour","root", "1234");
		} catch (Exception e) {
			System.out.println(e);
		}
		return con;
	}

	 // Inserts a new user registration record into the database.
	public static int save(Reg e) {
		int status = 0;
		try {
			Connection con = RegDao.getConnection();
			PreparedStatement ps = con.prepareStatement(
				"insert into reguser(fristname,lastname,nic,email,password,repassword,phone,dob,country) values (?,?,?,?,?,?,?,?,?)");
			ps.setString(1, e.getFristname());
			ps.setString(2, e.getLastname());
			ps.setString(3, e.getNic());
			ps.setString(4, e.getEmail());
			ps.setString(5, e.getPassword());
			ps.setString(6, e.getRepassword());
			ps.setString(7, e.getPhone());
			ps.setString(8, e.getDob());
			ps.setString(9, e.getCountry());

			status = ps.executeUpdate();

			con.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return status;
	}

	// Updates an existing user registration record in the database.
	public static int update(Reg e) {
		int status = 0;
		try {
			Connection con = RegDao.getConnection();
			PreparedStatement ps = con.prepareStatement(
					"update reguser set fristname=?,lastname=?,nic=?,email=?,password=?,repassword=?,phone=?,dob=?,country=? where id=?");
			ps.setString(1, e.getFristname());
			ps.setString(2, e.getLastname());
			ps.setString(3, e.getNic());
			ps.setString(4, e.getEmail());
			ps.setString(5, e.getPassword());
			ps.setString(6, e.getRepassword());
			ps.setString(7, e.getPhone());
			ps.setString(8, e.getDob());
			ps.setString(9, e.getCountry());
			ps.setInt(10, e.getId());

			status = ps.executeUpdate();

			con.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return status;
	}
	// Deletes a user registration record from the database by ID.
	public static int delete(int id) {
		int status = 0;
		try {
			Connection con = RegDao.getConnection();
			PreparedStatement ps = con.prepareStatement("delete from reguser where id=?");
			ps.setInt(1, id);
			status = ps.executeUpdate();

			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return status;
	}
	// Retrieves a user registration record from the database by ID.
	public static Reg getEmployeeById(int id) {
		Reg e = new Reg();

		try {
			Connection con = RegDao.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from reguser where id=?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				e.setId(rs.getInt(1));
				e.setFristname(rs.getString(2));
				e.setLastname(rs.getString(3));
				e.setNic(rs.getString(4));
				e.setEmail(rs.getString(5));
				e.setPassword(rs.getString(6));
				e.setRepassword(rs.getString(7));
				e.setPhone(rs.getString(8));
				e.setDob(rs.getString(9));
				e.setCountry(rs.getString(10));

			}
			con.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return e;
	}
	// Retrieves a list of all user registration records from the database.
	public static List<Reg> getAllEmployees() {
		List<Reg> list = new ArrayList<Reg>();

		try {
			Connection con = RegDao.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from reguser");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Reg e = new Reg();
				e.setId(rs.getInt(1));
				e.setFristname(rs.getString(2));
				e.setLastname(rs.getString(3));
				e.setNic(rs.getString(4));
				e.setEmail(rs.getString(5));
				e.setPassword(rs.getString(6));
				e.setRepassword(rs.getString(7));
				e.setPhone(rs.getString(8));
				e.setDob(rs.getString(9));
				e.setCountry(rs.getString(10));

				list.add(e);
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}
}
