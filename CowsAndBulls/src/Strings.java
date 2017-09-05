
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Strings {
	Map<Character,Boolean> map = new HashMap<>();
protected String str;
protected int len;
private char type;
public Strings(byte chars, int len){
	switch(chars){
	case 1:type='0';break;
	case 2:type='a';break;
	}
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
		do{ch=generateChar(type);
		}while(map.containsKey(ch));
		map.put(ch, true);
		generated[i]=ch;	
	}
	str=String.valueOf(generated);
	System.out.println(str);
}
private char generateChar(char type){
	byte size=10;
	switch(type){
	case '0': size=10;break;
	case 'a':size=25;break;
	}
char ch;
ch= (char) (type+Math.random()*size);
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