import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/signup")
public class Signup extends HttpServlet{
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) {
		String userId = req.getParameter("userId");
		String password = req.getParameter("password");
		RegisterUser ru = new RegisterUser();
		int updateCount = ru.registerUser(userId, password);
		try {
			if(updateCount == 1) {
					res.sendRedirect("Login.html"); //response has been committed here
					PrintWriter out = res.getWriter();
					out.println("You're signed up!");
//					RequestDispatcher rd = req.getRequestDispatcher("notification");
//					rd.forward(req, res); //cannot forward after response has been committed
//					rd.include(req, res); //include is used to add response of this servlet to buffer so that another servlet can also use this response
			}else {
				res.sendRedirect("Error.html");
			}
		} catch (IOException e) {
			e.printStackTrace();
//		} catch (ServletException e) {
//			e.printStackTrace();
		}
	}
}
