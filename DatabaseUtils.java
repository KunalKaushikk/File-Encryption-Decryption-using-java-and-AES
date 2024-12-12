import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DatabaseUtils {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/file_security";
    private static final String DB_USER = "root"; // Replace with your username
    private static final String DB_PASSWORD = ""; // Replace with your password

    public static void saveHistory(String fileName, String action) throws Exception {
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            String query = "INSERT INTO history (file_name, action) VALUES (?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, fileName);
            statement.setString(2, action);
            statement.executeUpdate();
        }
    }
}