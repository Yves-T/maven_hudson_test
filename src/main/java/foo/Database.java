package foo;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {

	private static final String DRIVER_NAME = "org.apache.derby.jdbc.EmbeddedDriver";

	static {

		try {

			Class.forName(DRIVER_NAME).newInstance();
			System.out.println("*** Driver loaded");
		} catch (Exception e) {

			System.out.println("*** Error : " + e.toString());

			System.out.println("*** ");
			System.out.println("*** Error : ");
			e.printStackTrace();
		}

	}

	// private static final String URL =
	// "jdbc:derby:/Users/yves/.myeclipse/derby/test2";
	private static final String USER = "APP";

	private static final String PASSWORD = "APP";

	public static Connection getConnection(String dbLocation)

	throws SQLException {

		return DriverManager.getConnection(dbLocation, USER, PASSWORD);

	}

	public static void resetDatabase(InputStream resource, String dbLocation)

	throws SQLException {

		String line = new String();

		StringBuffer stringBuffer = new StringBuffer();

		try {

			// FileReader fr = new FileReader(new File("mySQLFile.sql"));
			// File file = new File(resource.toURI());
			// System.out.println("file = " + file);
			// FileReader fr = new FileReader(resource);
			// be sure to not have line starting with "--" or "/*" or any other
			// non aplhabetical character

			BufferedReader bufferedReader = new BufferedReader(

			new InputStreamReader(resource));

			while ((line = bufferedReader.readLine()) != null) {

				stringBuffer.append(line);
			}
			bufferedReader.close();

			// here is our splitter ! We use ";" as a delimiter for each request
			// then we are sure to have well formed statements
			String[] queries = stringBuffer.toString().split(";");

			Connection c = Database.getConnection(dbLocation);

			Statement statement = c.createStatement();

			for (int i = 0; i < queries.length; i++) {

				// we ensure that there is no spaces before or after the request
				// string
				// in order to not execute empty statements
				if (!queries[i].trim().equals("")) {

					statement.executeUpdate(queries[i]);
					System.out.println(">>" + queries[i]);

				}
			}

		} catch (Exception e) {

			System.out.println("*** Error : " + e.toString());

			System.out.println("*** ");
			System.out.println("*** Error : ");
			e.printStackTrace();
			System.out
					.println("################################################");
			System.out.println(stringBuffer.toString());
		}

	}
}
