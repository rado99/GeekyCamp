import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Student {
	static java.sql.Connection con=connectivity.connectivity();
private int courseNumber;
private String firstName;
private String lastName;
private int facultyID;
public Student(String firstName, String lastName,int facultyID){
	this.firstName=firstName;
	this.lastName=lastName;
	this.facultyID=facultyID;
}
public Student(int courseNumber){
	this.courseNumber=courseNumber;
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
public void ViewAllCourses() throws SQLException{
	PreparedStatement prs;
	ResultSet rs;
	String sql="Select name,description,credits from courses INNER JOIN coursesStudents on courses.ID=coursesStudents.courseID "
			+ " where studentid=? ";
	prs=con.prepareStatement(sql);
	prs.setInt(1, courseNumber);
	rs=prs.executeQuery();
	while(rs.next()){
		System.out.println(rs.getString(1)+"  |  "+rs.getString(2)+"  |  "+rs.getString(3));
	}
	
	
}
public static void AllStudents() throws SQLException{
	Statement st;
	ResultSet rs;
	String sql="SELECT * from Students";
	st=con.createStatement();
	rs=st.executeQuery(sql);
	while(rs.next()){
		while(rs.next()){
			System.out.println(rs.getString(1)+"  |  "+rs.getString(2)+"  |  "+rs.getString(3));
		}
	}
}
}
