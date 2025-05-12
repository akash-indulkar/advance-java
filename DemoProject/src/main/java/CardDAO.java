import java.sql.Date;

public interface CardDAO {
	public boolean verifyCard(int cardNo, int cvv, Date expdate);
}
