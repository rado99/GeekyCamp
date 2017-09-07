import java.sql.PreparedStatement;
import java.sql.SQLException;


public class Student {
	java.sql.Connection con=connectivity.connectivity();
private int courseNumber;
private String firstName;
private String lastName;
private int facultyID;
public Student(String firstName, String lastName,int facultyID){
	this.firstName=firstName;
	this.lastName=lastName;
	this.facultyID=facultyID;
}
public int getCourseNumber(){
	return this.courseNumber;
}
public int addStudent(){
	int status=0;
PreparedStatement prs;
String sql="Insert into Students (firstName,lastName,facultyID) VALUES (?,?,?)";
try{
	prs=con.prepareStatement(sql);
	prs.setString(1, firstName);
	prs.setString(2, lastName);
	prs.setInt(3, facultyID);
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
}
