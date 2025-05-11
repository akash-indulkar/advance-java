import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAOImpl implements UserDAO{

	@Override
	public boolean verifyUser(String userId, String password) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "root", "Akash@6777");
			String query = "Select * from users where username=? and password=?";
			PreparedStatement psmt = con.prepareStatement(query);
			psmt.setString(1, userId);
			psmt.setString(2, password);
			System.out.println(userId);
			System.out.println(password);
			ResultSet rs = psmt.executeQuery();
			return rs.next();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
}
