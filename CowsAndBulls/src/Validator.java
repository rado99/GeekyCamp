
public class Validator {
	ForComparing input, generated;

	public Validator(ForComparing input, ForComparing generated) {
		this.input = input;
		this.generated = generated;
	}

	
	public byte[] check() {
		
		byte[] ret = { 0, 0 };
		for (int i = 0; i < input.getLen(); i++) {
			for (int j = 0; j < input.getLen(); j++) {
				if (input.getStr().charAt(i) == generated.getStr().charAt(j))
					if (i != j)
						++ret[0];
					else
						++ret[1];
			}
		}
		return ret;
	}
}
