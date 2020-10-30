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
				//PreparedStatement statement = connection.prepareStatement("update user set email = ?, name = ? where id = ?")){
				PreparedStatement statement = connection.prepareStatement("update user set money = ? where id = ?")){

			statement.setInt(1, 10000);
			statement.setLong(2, 2L);
			statement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
