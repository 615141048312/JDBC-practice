import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Update {
	public static void main(String[] args) throws ClassNotFoundException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw e;
		}

		String url = "jdbc:mysql://localhost:3306/database01?user=user01&password=password01&useSSL=false";

		try (Connection connection = DriverManager.getConnection(url);
				PreparedStatement statement = connection.prepareStatement("update user set email = ?, name = ? where id = ?")){

			statement.setString(1, "ccc@ccc.ccc");
			statement.setString(2, "Saburo Yamada");
			statement.setLong(3, 3L);
			statement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
