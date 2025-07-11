package backend;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import backend.db.DBUtil;
import backend.db.DBUtil.*;
import dao.UserDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class RegisterServ extends HttpServlet{
		
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uname = req.getParameter("uname");
		String pwd = req.getParameter("password");
		PrintWriter out = resp.getWriter();
		
		Connection con = DBUtil.getConnection();
		if(con == null) {
			resp.setContentType("text/html");
			
			System.out.println("failed to connect db ");
			out.print("Failed to connect to database ");
			return;
		}
		UserDAO dao = new UserDAO();
		boolean success = dao.registerUser(uname, pwd, con);
		if(success) {
			resp.setContentType("text/html");
			System.out.println("stored");
			out.print("registered successfull ");
		}else {
			out.print("failed to register");
		}

		
	}

	
}
