package foo;

import java.io.InputStream;
import java.util.Date;

import org.hibernate.Session;

public class AppMain {
	InputStream inputStream;

	public AppMain() {
		this.inputStream = this.getClass().getResourceAsStream("/foo/sql.sql");
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		AppMain test = new AppMain();

		// try {
		// System.out.println("location = " + test.inputStream);
		// Database.resetDatabase(
		// test.inputStream,
		// "jdbc:derby:/Users/yves/Downloads/derbytest/test2;create=true;user=APP;password=APP");
		// } catch (SQLException e) {
		// e.printStackTrace();
		// }
		System.out.println("Hibernate one to many (Annotation)");
		Session session = HibernateUtil.getSessionFactory().openSession();

		session.beginTransaction();

		Stock stock = new Stock();
		stock.setStockCode("7052");
		stock.setStockName("PADINI");
		session.save(stock);

		StockDailyRecord stockDailyRecords = new StockDailyRecord();
		stockDailyRecords.setPriceOpen(new Float("1.2"));
		stockDailyRecords.setPriceClose(new Float("1.1"));
		stockDailyRecords.setPriceChange(new Float("10.0"));
		stockDailyRecords.setVolume(3000000L);
		stockDailyRecords.setDate(new Date());

		stockDailyRecords.setStock(stock);
		stock.getStockDailyRecords().add(stockDailyRecords);

		session.save(stockDailyRecords);

		session.getTransaction().commit();
		System.out.println("Done");
	}

	public int multiply(int x, int y) {
		return x * y;
	}
}
