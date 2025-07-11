package backend.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtil {
    private static final String url = "jdbc:mysql://localhost:3306/jsp";
    private static final String user = "root";
    private static final String passw = "root123";

    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // Ensure driver is loaded
            Connection con = DriverManager.getConnection(url, user, passw);
            System.out.println("✅ Connected to DB");
            return con;
        } catch (ClassNotFoundException e) {
            System.out.println("❌ JDBC Driver NOT found: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("❌ Failed to connect to DB: " + e.getMessage());
        }
        return null;
    }
}
