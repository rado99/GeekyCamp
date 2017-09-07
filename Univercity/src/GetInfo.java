import java.sql.SQLException;
import java.util.Scanner;

public class GetInfo {
private byte status;
public GetInfo(byte status){
	this.status=status;
}
public static void AddStudent() throws SQLException{
	Scanner sc=new Scanner(System.in);
	String name,lastName;
	int facultyID;
	System.out.print("Please enter a name:");
name=sc.nextLine();
System.out.print("\nPlease enter last name:");
lastName=sc.nextLine();
faculty.printAll();
System.out.println("Enter Faculty ID:");
facultyID=sc.nextInt();
Student st=new Student(name,lastName,facultyID);
System.out.println(st.addStudent()+" rows were added!");

}
}
