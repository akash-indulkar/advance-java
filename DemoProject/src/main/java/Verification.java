import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//service layer
@WebServlet("/verify") //To map java class with action present in HTML file
public class Verification extends HttpServlet{ //HttpServlet is a class which extends Generic class and it is a adapter class
	@Override
	public void service(HttpServletRequest req, HttpServletResponse res) {
		String userId = req.getParameter("userId");
		String password = req.getParameter("password");
		VerifyUser vu = new VerifyUser();
		try {
			PrintWriter out = res.getWriter();
			if(vu.isValid(userId, password)) out.println("valid user");
			else out.println("invalid user");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
