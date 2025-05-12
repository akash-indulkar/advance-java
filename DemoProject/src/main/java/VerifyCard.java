import java.sql.Date;

public class VerifyCard {
	public boolean verifyCard(int cardNo, int cvv, Date expdate) {
		CardDAO cd = new CardDAOImpl();
		return cd.verifyCard(cardNo, cvv, expdate);
	}
}
