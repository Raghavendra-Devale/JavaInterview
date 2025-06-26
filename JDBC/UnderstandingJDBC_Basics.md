###  **Objective:** Connect Java to a MySQL Database and Print a Success Message

---

###  **Prerequisites:**

* MySQL is installed and running.
* A test database exists (e.g., `jdbc_demo`).
* MySQL JDBC Driver (`mysql-connector-j-x.x.xx.jar`) is in your classpath or added via Maven.

---

###  **MySQL Setup:**

Create a database and a test table (via MySQL command line or GUI like MySQL Workbench):

```sql
CREATE DATABASE jdbc_demo;

USE jdbc_demo;

CREATE TABLE test_table (
    id INT PRIMARY KEY,
    name VARCHAR(50)
);
```

---

###  **Java Code Example (Step 1):**

```java
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcConnectDemo {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/jdbc_demo";
        String user = "root";
        String password = "root123"; // Change as per your setup

        try {
            // Step 1: Load the JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Establish the connection
            Connection conn = DriverManager.getConnection(url, user, password);

            // Step 3: Confirm connection
            if (conn != null) {
                System.out.println(" Connected to the database successfully!");
            }

            // Step 4: Close the connection
            conn.close();

        } catch (ClassNotFoundException e) {
            System.out.println(" JDBC Driver not found: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println(" SQL Exception: " + e.getMessage());
        }
    }
}
```

---

###  **Explanation:**

* `Class.forName()` loads the JDBC driver class.
* `DriverManager.getConnection()` opens the DB connection.
* The `if (conn != null)` check ensures that a valid connection was established.
* Always close the connection to free up resources.🌝