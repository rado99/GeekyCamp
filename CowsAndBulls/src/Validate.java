
public class Validate {
Strings input,generated;

public Validate(Strings input,Strings generated){
	this.input=input;
	this.generated=generated;
}
	public boolean check(){
		int cows = 0;
		int bulls = 0;
		for (int i = 0; i < input.len; i++) {
			if (input.str.charAt(i) == generated.str.charAt(i)) {
				++bulls;
			}
		}
		if (bulls == input.len) {
			System.out.println("You did it!");
			return true;
		} else {
			for (int i = 0; i < input.len; i++) {
				for (int j = 0; j < input.len; j++) {
					if (input.str.charAt(i) == generated.str.charAt(j) && i != j)
						cows ++;
				}
			}
			System.out.println("bulls: " + bulls + " cows: " + cows);
			return false;
			
		}
	}
}
