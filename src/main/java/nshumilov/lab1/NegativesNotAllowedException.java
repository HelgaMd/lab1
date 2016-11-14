package nshumilov.lab1;

import java.util.List;
import java.util.stream.Collectors;

public class NegativesNotAllowedException extends RuntimeException {
	private List<Integer> negativeNumbers;

	public NegativesNotAllowedException(List<Integer> negativeNumbers) {
		this.negativeNumbers = negativeNumbers;
	}

	@Override
	public String getMessage() {
		return ("Negatives not allowed. Got: "
				+ String.join(", ", negativeNumbers.stream().map(String::valueOf).collect(Collectors.toList())));
	}
}
