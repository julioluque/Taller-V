package mvc.tp.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import mvc.tp.model.User;
import mvc.tp.util.DBUtility;

public class LoginDao {
	public String authenticateUser(User loginUser){
		
		String userName = loginUser.getUsername();
		String password = loginUser.getPassword();
		String status="failed";
		
		Connection con = null;
	    Statement stmt = null;
	    ResultSet rs = null;
	    
	    String userNameDB = "";
	    String passwordDB = "";
	    int estadoDB = 0;
	    int rolDB = 0;
	    
	    try
	    {
	    	String SQL = "SELECT [usuario],[password],[estado],[rol] FROM [dbo].[Usuarios]";
	    	
	    	con = DBUtility.getConnection();
	    	stmt = con.createStatement();
	    	rs =stmt.executeQuery(SQL);
	    	
	    	while(rs.next())
	    	{
	    		userNameDB = rs.getString("usuario");//representa una columna de la tabal
	    		passwordDB = rs.getString("password");
	    		estadoDB = rs.getInt("estado");
	    		rolDB = rs.getInt("rol");
	    		
	    		//1 activo 
	    		if(userName.equalsIgnoreCase(userNameDB) && password.equals(passwordDB) && (estadoDB ==1))
	    		{
	    			if(rolDB==1){
	    				status = "success_adm";
	    			}
	    			else{
	    				status = "success_usr";
	    			}
	    		}
	    		
	    	}
	    }
	    catch(SQLException e)
	    {
	    	 e.printStackTrace();	
	    }
		return status;
	}

}
