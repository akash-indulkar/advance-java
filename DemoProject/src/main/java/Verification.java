import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/verify") //To map java class with action present in HTML file
public class Verification extends HttpServlet{ //HttpServlet is a class which extends Generic class and it is a adapter class
	@Override
	public void service(HttpServletRequest req, HttpServletResponse res) {
		String userId = req.getParameter("userId");
		String password = req.getParameter("password");
		System.out.println(userId);
		System.out.println(password);
	}
}
