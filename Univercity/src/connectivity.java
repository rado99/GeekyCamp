import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.regex.*;

import jdk.nashorn.internal.ir.RuntimeNode.Request;

public class connectivity{

	
	
public static Connection connectivity() {
	
			try {
				Class.forName("com.mysql.jdbc.Driver");
				
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
				System.out.println("Driver is aplayed");
			}
			
				String path = "jdbc:mysql://localhost:3306/Univercity";
				String name = "root";
				String pass = "";
				Connection con = null;
				
				try{
				con = DriverManager.getConnection(path, name, pass);
			    }
				
				catch(SQLException ex){
					
				ex.printStackTrace();
				System.out.println("Not connected to the database " + ex);
				
				}
		return con;	
    }
}
