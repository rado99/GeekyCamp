import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.Scanner;
public class faculty {
static Connection con=connectivity.connectivity();
private String name;
public faculty(String name){
	this.name=name;
}
public static void printAll() throws SQLException{
	Statement st;
	ResultSet rs=null;
	String sql="SELECT id,name from faculty;";
	st=con.createStatement();
	rs=st.executeQuery(sql);
	System.out.println(" ID: "+"|"+" Name:");
	while(rs.next()){
		System.out.println(rs.getString(1)+"  |  "+rs.getString(2));
	}
	
}
public static void addOrRemove() throws SQLException{
	Scanner sc=new Scanner(System.in);
	int status;
	String name;
	System.out.println("Press 1 to Add, or 2 to remove a faculty");
status=sc.nextInt();
sc.nextLine();
printAll();
System.out.println("Please enter faculty name to add or remove");
name=sc.nextLine();
faculty fac=new faculty(name);
switch(status){
case 1:fac.addFaculty();break;
case 2:fac.removeFaculty();break;
}
}
void addFaculty() throws SQLException{
	PreparedStatement prs=null;
	String sql="Insert into faculty(name) VALUES(?)";
	prs=con.prepareStatement(sql);
	prs.setString(1, name);
	prs.executeUpdate();
}
void removeFaculty() throws SQLException{
	int status=0;
	con.setAutoCommit(false);
	PreparedStatement prs;
	String sql="DELETE FROM Students WHERE facultyID IN (SELECT ID FROM faculty WHERE name=? )";
	prs=con.prepareStatement(sql);
	prs.setString(1,name);
	status+=prs.executeUpdate();
	sql="DELETE FROM faculty WHERE name=?";
	prs=con.prepareStatement(sql);
	prs.setString(1,name);
	status+=prs.executeUpdate();
con.commit();
System.out.println("There were "+status+"rows deleted");
con.setAutoCommit(true);
}
}
