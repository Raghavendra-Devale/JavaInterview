package backend;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import backend.db.DBUtil;
import dao.UserDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/loginsystem")
public class LoginServ extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name = req.getParameter("uname");
        String pass = req.getParameter("pwd");

        System.out.println("name = " + name + " password = " + pass);

        // Get database connection
        Connection con = DBUtil.getConnection();
        if (con == null) {
            System.out.println("Failed to connect to DB. Check DBUtil and JAR.");
            resp.setContentType("text/html");
            PrintWriter out = resp.getWriter();
            out.println("<h3>Database connection failed. Contact admin.</h3>");
            return;
        }

        // Validate user
        UserDAO ud = new UserDAO();
        boolean isValid = ud.validateUser(name, pass);

        if (isValid) {
            
            HttpSession session = req.getSession();
            session.setAttribute("username", name);

            
            resp.sendRedirect("dashboard.jsp");
        } else {
            
            resp.setContentType("text/html");
            PrintWriter out = resp.getWriter();
            out.println("<h3> Invalid username or password.</h3>");
            out.println("<a href='login.html'>Try again</a>");
        }
    }
}
