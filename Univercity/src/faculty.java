import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
public class faculty {
static Connection con=connectivity.connectivity();
private String name;
public static void printAll() throws SQLException{
	Statement st;
	ResultSet rs=null;
	String sql="SELECT id,name from faculty;";
	st=con.createStatement();
	rs=st.executeQuery(sql);
	System.out.println(" ID: "+"|"+" Name:");
	while(rs.next()){
		System.out.println(rs.getInt(1)+'|'+rs.getString(2));
	}
}
}
