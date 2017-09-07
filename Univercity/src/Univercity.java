import java.sql.SQLException;
import java.util.Scanner;
public class Univercity {

	public static void main(String[] args) throws SQLException {
		Scanner sc=new Scanner(System.in);
		byte status=0;
		do{
			System.out.println("Press 1 to add a Student \nPress 2 to add a Course \nPress 0 to exit");
			status=sc.nextByte();
			switch(status){
			case 1:GetInfo.AddStudent();break;
			}
			
		}while(status!=0);
	}

}
