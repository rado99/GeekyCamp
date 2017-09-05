import java.util.Scanner;
public class StringInString {

	public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	String[] str=sc.nextLine().split(" ",2);
int broi=0;
boolean isReached=false;
for(int i=0;i<str[0].length();i++){
	if(i+broi>str[0].length())
		break;
	for(int j=0;j<str[1].length();++j){
		if(broi>=(str[1].length())){
			isReached=true;
			break;	
		}
		if(str[1].charAt(j)=='*'){
			for(int k=1;k<str[0].length()+broi;k++){
				//if(str[0].charAt())
			}
		}
		else
		if(str[1].charAt(j)=='?'||str[0].charAt(i+broi)==str[1].charAt(broi)){
			broi++;
		}
		else
			{broi=0;
	}
	}
}
System.out.println(isReached);
	}

}
