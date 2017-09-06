import java.util.Random;
import java.util.Scanner;

public class CowsAndBulls {

	public static void main(String[] args) {
		byte[] status;
		byte size,limit=10;
		ForComparing input,generated;
		Scanner sc=new Scanner(System.in);
		System.out.print("Please press '1' for only numbers, '2' for characters,3 for words:");
		byte type= sc.nextByte();
		switch(type){
		case 1:limit=10;break;
		case 2:limit=26;break;
		case 3:limit=10;break;
		}
		do{
		System.out.print("Please select difficulty,greater than 1 and smaller than "+limit+":");
		size=sc.nextByte();
		}while(size<2||size>limit);
		input=new ForComparing(type,size);
		generated=new ForComparing(type,size);
		generated.generate();
		Validator validator=new Validator(input,generated);
		do{
		input.input();
		status=validator.check();
		System.out.println("bulls:"+status[1]+" cows: "+status[0]);
		System.out.println(status[1]==input.getLen()?"You did it!":"Please try again");
		}while(status[1]!=input.getLen());

	}

	
}