import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Courses {
	java.sql.Connection con=connectivity.connectivity();
private String name;
private String description;
private int credits;
public Courses(String name,String description,int credits){
	this.name=name;
	this.description=description;
	this.credits=credits;
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
public void deleteCourse() throws SQLException{
	con.setAutoCommit(false);
	PreparedStatement prs;
	String sql="DELETE FROM coursesStudents WHERE courseId IN(SELECT id from Courses WHERE name=?)";
	prs=con.prepareStatement(sql);
	prs.setString(1,name);
	prs.executeUpdate();
	sql="DELETE FROM Courses WHERE name=?";
	prs=con.prepareStatement(sql);
	prs.executeUpdate();
try{
	con.commit();
}
catch(SQLException e){
	e.printStackTrace();
	con.rollback();
}
}
}

