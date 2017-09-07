import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class Courses {
	static java.sql.Connection con=connectivity.connectivity();
private String name;
private String description;
private int credits;
public Courses(String name,String description,int credits){
	this.name=name;
	this.description=description;
	this.credits=credits;
}
public Courses(String name){
	this.name=name;
}
public String getName(){
	return this.name;
}
public int addCourse(){
	int status=0;
PreparedStatement prs;
String sql="Insert into Courses (Name,Description,Credits) VALUES (?,?,?)";
try{
	prs=con.prepareStatement(sql);
	prs.setString(1, name);
	prs.setString(2, description);
	prs.setInt(3, credits);
status=prs.executeUpdate();
}
catch(SQLException e){
	e.printStackTrace();
	System.out.println("The data was not inserted");
}
finally{
	return status;
}
}
public int deleteCourse() throws SQLException{
	int status=0;
	con.setAutoCommit(false);
	PreparedStatement prs;
	String sql="DELETE FROM CoursesStudents WHERE CourseID IN (SELECT ID FROM Courses WHERE name=? )";
	prs=con.prepareStatement(sql);
	prs.setString(1,name);
	status+=prs.executeUpdate();
	sql="DELETE FROM Courses WHERE name=?";
	prs=con.prepareStatement(sql);
	prs.setString(1,name);
	status+=prs.executeUpdate();
con.commit();
con.setAutoCommit(true);
	return status;

}
public static void printCourses() throws SQLException{
	Statement st;
	ResultSet rs;
	String sql="SELECT * from Courses";
	st=con.createStatement();
	rs=st.executeQuery(sql);
	System.out.println("ID   |  Name:"+"| Description:  |"+"Credits:");
	while(rs.next()){
		System.out.println(rs.getString(1)+"|"+rs.getString(2)+"|"+rs.getString(3)+"|"+rs.getString(4));
	}
}
}

