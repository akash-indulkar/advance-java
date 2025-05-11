
public class VerifyUser {
	public boolean isValid(String userId, String password) {
		UserDAO ud = new UserDAOImpl();
		return ud.verifyUser(userId, password);
	}
}
