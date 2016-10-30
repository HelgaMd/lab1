
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			SimpleCalc calcObj = new SimpleCalc();
			System.out.println(calcObj.Add("//[.][***][][;]\n2.2***3;51"));
		} catch(NegativeExc exc) {
			System.out.print("Negatives not allowed:");
			System.out.println(exc.getMessage());
		}
	}

}
