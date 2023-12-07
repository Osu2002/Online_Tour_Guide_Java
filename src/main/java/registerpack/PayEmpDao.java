package registerpack;

import java.util.*;
import java.sql.*;

public class PayEmpDao {
                                                     //Establishes a database connection and returns the Connection object.
	public static Connection getConnection() {
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tour", "root", "1234");
		} catch (Exception e) {
			System.out.println(e);     
		}
		return con;
	}

	public static int save(PayEmp e) {
		int status = 0;
		try {                                             // Load the MySQL JDBC driver and connect to the database
			Connection con = PayEmpDao.getConnection();
			PreparedStatement ps = con
					.prepareStatement("insert into payment(name,email,passportid,cardname,cardnumber,amount) values (?,?,?,?,?,?)");
			ps.setString(1, e.getName());
			ps.setString(2, e.getEmail());
			ps.setString(3, e.getPassportid());
			ps.setString(4, e.getCardname());
			ps.setString(5, e.getCardnumber());
			ps.setString(6, e.getAmount());
			
			status = ps.executeUpdate();
			

			con.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return status;
	}

	public static int update(PayEmp e) {
		int status = 0;
		try {
			Connection con = PayEmpDao.getConnection();                       //   Inserts an employee's payment details into the database
			PreparedStatement ps = con
					.prepareStatement("update payment set name=?,email=?,passportid=?,cardname=?,cardnumber=?,amount=? where id=?");
			ps.setString(1, e.getName());
			ps.setString(2, e.getEmail());
			ps.setString(3, e.getPassportid());
			ps.setString(4, e.getCardname());
			ps.setString(5, e.getCardnumber());
			ps.setString(6, e.getAmount());
			ps.setInt(7, e.getId());

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
			Connection con = PayEmpDao.getConnection();
			PreparedStatement ps = con.prepareStatement("delete from payment where id=?");
			ps.setInt(1, id);
			status = ps.executeUpdate();

			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return status;
	}

	public static PayEmp getEmployeeById(int id) {
		PayEmp e = new PayEmp();

		try {
			Connection con = PayEmpDao.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from payment where id=?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				e.setId(rs.getInt(1));
				e.setName(rs.getString(2));
				e.setEmail(rs.getString(3));
				e.setPassportid(rs.getString(4));
				e.setCardname(rs.getString(5));
				e.setCardnumber(rs.getString(6));
				e.setAmount(rs.getString(7));
				
			}
			con.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return e;
	}

	public static List<PayEmp> getAllEmployees() {
		List<PayEmp> list = new ArrayList<PayEmp>();

		try {
			Connection con = PayEmpDao.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from payment");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				PayEmp e = new PayEmp();
				e.setId(rs.getInt(1));
				e.setName(rs.getString(2));
				e.setEmail(rs.getString(3));
				e.setPassportid(rs.getString(4));
				e.setCardname(rs.getString(5));
				e.setCardnumber(rs.getString(6));
				e.setAmount(rs.getString(7));
				list.add(e);
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}
}
