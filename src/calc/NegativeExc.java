package calc;

public class NegativeExc extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String value;
	
	NegativeExc(String excText) {
		value = excText;
	}
	
	public String getMessage() {
		return value;
	}
}
