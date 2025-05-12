import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CardDAOImpl implements CardDAO{

	@Override
	public boolean verifyCard(int cardNo, int cvv, Date expdate) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "root", "Akash@6777");
			String query = "SELECT * FROM cards WHERE cardNo = ? and cvv = ? and expdate = ?";
			PreparedStatement stmnt = con.prepareStatement(query); 
			stmnt.setInt(1, cardNo);
			stmnt.setInt(2, cvv);
			stmnt.setDate(3, expdate);
			ResultSet rs = stmnt.executeQuery();
			return rs.next();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	

}
