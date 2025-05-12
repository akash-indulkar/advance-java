import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//service layer
@WebServlet("/verify") //To map java class with action present in HTML file
public class Verification extends HttpServlet{ //HttpServlet is a class which extends Generic class and it is a adapter class
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) {
		String userId = req.getParameter("userId");
		String password = req.getParameter("password");
		VerifyUser vu = new VerifyUser();
		try {
			PrintWriter out = res.getWriter();
			if(vu.isValid(userId, password)) {
//				RequestDispatcher rd = req.getRequestDispatcher("verifyCard"); //used to send a request to another servlet
//				rd.forward(req, res);
				out.println("valid user");
				RequestDispatcher rd = req.getRequestDispatcher("notification");
//				rd.forward(req, res); //cannot forward after response has been committed
				rd.include(req, res); //include is used to add response of this servlet to buffer so that another servlet can also use this response
			}
			else res.sendRedirect("Error.html"); //redirecting a new request to another page
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ServletException e) {
			e.printStackTrace();
		}
	}
}
