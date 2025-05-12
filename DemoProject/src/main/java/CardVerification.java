import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/verifyCard")
public class CardVerification extends HttpServlet{
	@Override
	public void service(HttpServletRequest req, HttpServletResponse res) {
		int cardNo = Integer.parseInt(req.getParameter("cardNo"));
		int cvv = Integer.parseInt(req.getParameter("cvv"));
		Date date = Date.valueOf(req.getParameter("expdate"));
		VerifyCard vc = new VerifyCard();
		try {
			PrintWriter out = res.getWriter();
			if(vc.verifyCard(cardNo, cvv, date)) out.println("card verified successfully");
			else out.println("card verification failed");
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

}
