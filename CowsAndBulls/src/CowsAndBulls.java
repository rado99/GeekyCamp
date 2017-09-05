import java.util.Scanner;

public class CowsAndBulls {
	static byte size;
	
	static char[] vhod=new char[4];
	static char[] izhod=new char[4];
	static boolean reached = false;
	

	public static void main(String[] args) {
		boolean status=false;
		byte size;
		Strings input,generated;
		Scanner sc=new Scanner(System.in);
		System.out.print("Please press '1' for only numbers, '2' for characters,3 for words:");
		byte type= sc.nextByte();
		System.out.print("Please select difficulty,greater than 1 and smaller than 10:");
		size=sc.nextByte();
		System.out.println(type+" "+size);
		input=new Strings(type,size);
		generated=new Strings(type,size);
		generated.generate();
		Validate validator=new Validate(input,generated);
		do{
		input.input();
		status=validator.check();
		}while(!status);

	}

	
}