import java.util.Arrays;
import java.util.Scanner;

public class First {
	public static void main(String[] Args) {
		
		boolean hasStarted = false;
		Scanner sc = new Scanner(System.in);
		int broi = 0;
		String[] str = sc.nextLine().split(" ");
		boolean[] bool = new boolean[str.length];
		for (int i = 0; i < str.length; i++) {
			if (!bool[i]){
				for (int j = i; j < str.length; j++) {
					if (str[i].equals(str[j])) {
						if (!bool[j]) {
							broi++;
							bool[j] = true;
						}
					} 
				}
				
				String t = str[i] + ' ' + broi;
				String res = null;
				
				if (!hasStarted) {
					res = t;
					hasStarted = true;
				} else {
					res= ' ' + t;
				}
			
				System.out.print(res);
			broi=0;
			}
		}
		System.out.println();
	}

}