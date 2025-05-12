import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegisterDAOImpl implements RegisterDAO{

	@Override
	public int RegisterUser(String userId, String password) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "root", "Akash@6777");
			String query = "INSERT INTO users VALUES(?, ?, ?)";
			PreparedStatement psmnt = con.prepareStatement(query);
			int uid = 2;
			psmnt.setInt(1, uid);
			psmnt.setString(2, userId);
			psmnt.setString(3, password);
			int updateCount = psmnt.executeUpdate();
			return updateCount;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return 0;
	}
	
}
