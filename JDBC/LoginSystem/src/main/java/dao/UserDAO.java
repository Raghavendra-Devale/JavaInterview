package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import backend.db.DBUtil;

public class UserDAO {

	public boolean validateUser(String username, String password) {
	    Connection con = DBUtil.getConnection();
	    String query = "SELECT * FROM users WHERE username = ? AND password = ?";
	    try {
	        PreparedStatement pst = con.prepareStatement(query);
	        pst.setString(1, username);
	        pst.setString(2, password);

	        ResultSet rs = pst.executeQuery();
	        return rs.next(); 

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return false;
	}
	
	public boolean registerUser(String username, String password, Connection con) {
		
		boolean userExists = existingUser(username,con);
		if(!userExists) {
			String query = "insert into users (username, password) values(?,?)";
			
			try {
				PreparedStatement pst = con.prepareStatement(query);
				pst.setString(1, username);
				pst.setString(2, password);
				
				int res = pst.executeUpdate();
				
				if(res>0) {
					return true;
				}
			}catch (Exception e) {
				System.out.println("error "+ e.getMessage());
				e.printStackTrace();
			}

			
		}
								

		return false;
	}



public boolean existingUser(String username,Connection con) {
    
    String query = "SELECT * FROM users WHERE username = ? ";
    try {
        PreparedStatement pst = con.prepareStatement(query);
        pst.setString(1, username);
        

        ResultSet rs = pst.executeQuery();
        if(rs.next()) {
        	return true;
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }
    return false;
}

}