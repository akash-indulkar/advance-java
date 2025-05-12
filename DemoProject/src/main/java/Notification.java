import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/notification")
public class Notification extends HttpServlet{
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) {
		PrintWriter out;
		try {
			out = res.getWriter();
			out.println("You're logged in!");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
