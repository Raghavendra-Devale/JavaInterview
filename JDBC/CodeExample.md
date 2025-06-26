##  **Step 2: Code Example — First JDBC Program**

---

###  **Prerequisites Recap:**

* MySQL is installed and running.
* Database `jdbc_demo` exists.
* MySQL JDBC driver (`mysql-connector-j`) is added to the project.

### 💻 **Java Code (Connect and Create Table):**

```java
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.SQLException;

public class SetupDemo {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/jdbc_demo";
        String user = "root";
        String password = "root123"; // Update to your password

        try {
            // Load the JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Connect to the database
            Connection conn = DriverManager.getConnection(url, user, password);
            System.out.println(" Database connected successfully!");

            // Create a table
            Statement stmt = conn.createStatement();
            String createTableSQL = "CREATE TABLE IF NOT EXISTS users ("
                    + "id INT AUTO_INCREMENT PRIMARY KEY, "
                    + "name VARCHAR(100), "
                    + "email VARCHAR(100))";

            stmt.executeUpdate(createTableSQL);
            System.out.println(" Table 'users' created (if not exists).");

            // Close connections
            stmt.close();
            conn.close();
            System.out.println(" Connection closed.");

        } catch (ClassNotFoundException e) {
            System.out.println(" JDBC Driver not found: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println(" SQL Error: " + e.getMessage());
        }
    }
}
```

---

###  **What This Code Does:**

* Loads the JDBC driver.
* Connects to your MySQL database.
* Creates a table called `users`.
* Closes the database connection.
