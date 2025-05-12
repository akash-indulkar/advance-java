
public class RegisterUser {

	public int registerUser(String userId, String password) {
		RegisterDAO rd = new RegisterDAOImpl();
		return rd.RegisterUser(userId, password);
	}

}
