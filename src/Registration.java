import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Registration {
	public static void main(String[] args) throws ClassNotFoundException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw e;
		}

		String url = "jdbc:mysql://localhost:3306/database01?user=user01&password=password01&useSSL=false";

		try (Connection connection = DriverManager.getConnection(url);
				PreparedStatement statement = connection.prepareStatement("insert into user (email, name) values (?, ?)")){

			statement.setString(1, "bbb@bbb.bbb");
			statement.setString(2, "やまださぶろー");
			//日本語に対応してないのでnameは登録に失敗した

			boolean result = statement.execute();
			System.out.println(result);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
