import java.util.Scanner;

public class CowsAndBulls {
	static char[] vhod = new char[4];
	static char[] izhod = new char[4];
	static boolean reached = false;

	public static void main(String[] args) {
		generate();
		System.out.println(vhod);
		do {
			input();
		} while (!validate());

	}

	public static void generate() {
		for (int i = 0; i < vhod.length; i++) {
			vhod[i] = (char) ((char) '0' + (Math.random() * 10));
		}
		if (vhod[0] == vhod[1] || vhod[0] == vhod[2] || vhod[0] == vhod[3] || vhod[1] == vhod[2] || vhod[1] == vhod[3]
				|| vhod[2] == vhod[3] || vhod[0] == 0) {
			generate();
		}
	}

	public static void input() {
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		if (input.length() != 4) {
			System.out.println("Too big or small number, please try again");
			input();
		}
		if (input.charAt(0) == '0') {
			System.out.println(vhod);
		} else {
			izhod = input.toCharArray();
		}
	}

	public static boolean validate() {
		int cows = 0;
		int bulls = 0;
		for (int i = 0; i < vhod.length; i++) {
			if (vhod[i] == izhod[i]) {
				++bulls;
			}
		}
		if (bulls == vhod.length) {
			System.out.println("You did it!");
			return true;
		} else {
			for (int i = 0; i < vhod.length; i++) {
				for (int j = 0; j < vhod.length; j++) {
					if (vhod[j] == izhod[i] && i != j)
						cows ++;
				}
			}
			System.out.println("bulls: " + bulls + " cows: " + cows);
			return false;
		}
	}
}
