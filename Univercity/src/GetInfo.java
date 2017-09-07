import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class GetInfo {
	static Connection con = connectivity.connectivity();
	private byte status;
	static Scanner sc = new Scanner(System.in);
	public GetInfo(byte status) {
		this.status = status;
	}

	public static void AddStudent() throws SQLException {
		String name, lastName;
		int facultyID;
		System.out.print("Please enter a name:");
		name = sc.nextLine();
		System.out.print("\nPlease enter last name:");
		lastName = sc.nextLine();
		faculty.printAll();
		System.out.println("Enter Faculty ID:");
		facultyID = sc.nextInt();
		
		Student st = new Student(name, lastName, facultyID);
		int result = st.addStudent();
		
		System.out.println(result + " rows were added!");

	}

	public static void AddCourse() throws SQLException {
		
		String name, description;
		int credits;
		System.out.print("Please enter Course Name:");
		name = sc.nextLine();
		System.out.print("Please enter Course Description:");
		description = sc.nextLine();
		System.out.print("Please enter number of credits:");
		credits = sc.nextInt();
		
		Courses cs = new Courses(name, description, credits);
		int result = cs.addCourse();
		
		System.out.println(result + " rows were added!");

	}

	public static void DeleteCourse() throws SQLException {
		String name;
		System.out.print("Please enter Course Name:");
		name = sc.nextLine();
		
		Courses cs = new Courses(name);
		System.out.println(cs.deleteCourse() + " rows were deleted!");

	}

	public static void AddToCourse() throws SQLException {
		PreparedStatement prs;
		int courseNumber;
		int status;
		String courseName;
		System.out.print("Enter course name:");
		courseName = sc.nextLine();
		System.out.print("Enter Student course number:");
		courseNumber = sc.nextInt();
		
		String sql = "INSERT into coursesStudents(courseId,studentId) SELECT id,? from Courses WHERE name=?";
		prs = con.prepareStatement(sql);
		prs.setInt(1, courseNumber);
		prs.setString(2, courseName);
		status=prs.executeUpdate();
		
		System.out.println(status + " row was added!");
	}
	public static void AllCourses() throws SQLException{
		int courseNumber;
	System.out.print("Please enter Student course number:");
	courseNumber=sc.nextInt();
	
	Student st=new Student(courseNumber);
	st.ViewAllCourses();
	}
	
}
