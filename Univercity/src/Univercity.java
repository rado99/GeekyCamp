import java.sql.SQLException;
import java.util.Scanner;
public class Univercity {

	public static void main(String[] args) throws SQLException {
		Scanner sc=new Scanner(System.in);
		byte status=0;
		do{
			System.out.println("Press 1 to add a Student \n"
					+ "Press 2 to add a Course \n"
					+ "Press 3 to delete a Course\n"
					+ "Press 4 for All courses\n"
					+ "Press 5 to add a student to a course \n"
					+ "Press 6 to view all Courses for a Student\n"
					+"Press 7 to add or remove faculty\n"
					+ "Press 0 to exit");
			status=sc.nextByte();
			switch(status){
			case 1:GetInfo.AddStudent();break;
			case 2:GetInfo.AddCourse();break;
			case 3:GetInfo.DeleteCourse();break;
			case 4:Courses.printCourses();break;
			case 5:GetInfo.AddToCourse();break;
			case 6:GetInfo.AllCourses();break;
			case 7:faculty.addOrRemove();break;
			}
			
		}while(status!=0);
	}

}
