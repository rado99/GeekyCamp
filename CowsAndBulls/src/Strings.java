import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Strings {
	Map<Character,Boolean> map = new HashMap<>();
protected String str;
protected int len;
private byte type;
public Strings(byte type, int len){
	this.type=type;
	this.len=len;
}
public void setStr(String str){
	this.str=str;
}
public String getStr(){
	return this.str;
}

public void generate(){
	char[] generated=new char[len];
	char ch;
	for(int i=0;i<len;i++){
		do{ch=generateChar(10);
		}while(map.containsKey(ch));
		map.put(ch, true);
		generated[i]=ch;	
	}
	str=String.valueOf(generated);
	System.out.println(str);
}
private char generateChar(int type){
char ch;
ch= (char) ('0'+Math.random()*type);
return ch;
}

public void input() {
	Scanner sc = new Scanner(System.in);
	String input = sc.nextLine();
	if (input.length() !=len) {
		System.out.println("Too big or small number, please try again");
		input();
	}
	str=input;
	}
}