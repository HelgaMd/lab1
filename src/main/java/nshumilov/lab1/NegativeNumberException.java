package nshumilov.lab1;

import java.util.List;

public class NegativeNumberException extends RuntimeException {
	private List<Integer> negativeNumbers;

	public NegativeNumberException(List<Integer> negativeNumbers) {
		this.negativeNumbers = negativeNumbers;
	}

	@Override
	public String getMessage() {
		StringBuilder sb = new StringBuilder();
		sb.append("Negative numbers not allowed. Got: ");
		for(int number: negativeNumbers)
			sb.append(number).append(" ");
		return sb.toString();
	}
}
