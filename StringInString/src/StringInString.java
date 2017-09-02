import java.util.Scanner;
public class StringInString {

	public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	String[] str=sc.nextLine().split(" ",2);
int broi=0;
for(int i=0;i<str[0].length();i++){
	for(int j=0;j<str[1].length();j++){
		if(broi==(str[1].length())){
			break;
		} else
		if(str[0].charAt(i+broi)==str[1].charAt(broi)){
			broi++;
		}
		else
			broi=0;
		
	}
}
System.out.println(broi);
	}

}
