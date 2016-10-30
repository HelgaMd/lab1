
public class NegativeExc extends Exception {
	private String value;
	
	NegativeExc(String excText) {
		value = excText;
	}
	
	public String getMessage() {
		return value;
	}
}
