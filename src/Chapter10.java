import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Chapter10 {
	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/database01?user=user01&password=password01&useSSL=false";
	
	public static void main(String[] args) throws ClassNotFoundException {
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw e;
		}
		
		String sql = "update user set money = money + ? where id = ?"; 
		
		try (Connection connection = DriverManager.getConnection(URL);
				PreparedStatement statement = connection.prepareStatement(sql)){
			connection.setAutoCommit(false);

			// ID1のお金を1000減らす;
			statement.setInt(1, -1000);
			statement.setLong(2, 1L);
			statement.addBatch();
			System.out.println(statement.toString());
			
			// ID2のお金を1000増やす
			statement.setInt(1, 1000);
			statement.setLong(2, 2L);
			statement.addBatch();
			System.out.println(statement.toString());
			
			// 更新した回数
			int[] result = statement.executeBatch();
			System.out.println("変更:" + result.length + "件");
			
			try {
				connection.commit();
				System.out.println("成功");
			} catch (SQLException e) {
				connection.rollback();
				System.out.println("失敗");
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
