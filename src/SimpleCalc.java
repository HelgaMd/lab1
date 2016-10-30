
import java.util.*;

public class SimpleCalc {
	
	private  String defTokens = ",|\n";
	private String tokensRe;
	private boolean splitNumbers;//check [] in tokens
	private String regExSybmols = "[]*?+-%-|(){}\\^$.:";
	private String inputStr;
	private int curIter;// current position
	
	
	/**
	 * Add single delimiter to tokensRe
	 * 
	 */
	
	private void AddDelimiter() {
		String delimiter = "";
		for(curIter = 0; inputStr.charAt(curIter) != '\n' && !Character.isDigit(inputStr.charAt(curIter + 1)); curIter++) {
			if(regExSybmols.indexOf(inputStr.charAt(curIter)) != -1)
				delimiter += "\\" + inputStr.charAt(curIter);
			else
				delimiter += inputStr.charAt(curIter);
		}
		
		inputStr = inputStr.substring(++curIter);
		tokensRe = defTokens + "|" + delimiter;
		
	}
	
	/**
	 * Join ArrayList in string with yout delimiter
	 * 
	 * @param arrObj ArrayList object
	 * @param delim delimiter for result string
	 * @return String with ArrayList params with delimiter
	 */
	private String JoinArrayList(ArrayList<String> arrObj, char delim) {
		String result = "";
		for(int i = 0; i < arrObj.size(); i++) {
			result += i + 1 == arrObj.size() ? arrObj.get(i) : (arrObj.get(i) + delim);
		}
		
		return result;
	}
	
	
	/**
	 * Add multiple delimiters to tokensRe
	 */
	private void MulDelimiters() {
		String tmp = "";
		ArrayList<String> dels = new ArrayList<String>();
		while(true) {
			if(inputStr.charAt(curIter) == '[') {
				for(curIter = curIter + 1; inputStr.charAt(curIter) != ']'; curIter++) {
					if(regExSybmols.indexOf(inputStr.charAt(curIter)) != -1)
						tmp += "\\" + inputStr.charAt(curIter);
					else
						tmp += inputStr.charAt(curIter);
				}
				if(inputStr.charAt(curIter) == ']' && inputStr.charAt(curIter + 1) == '\n') {
					if(tmp.length() == 0) {
						splitNumbers = true;
					}
					else {
						dels.add(tmp);
					}
					curIter += 2;
					break;
				}
				else if(inputStr.charAt(curIter) == ']') {
					if(tmp.length() == 0) {
						splitNumbers = true;
					}
					else {
						dels.add(tmp);
					}
					curIter++;
					tmp = "";
				}
				
			}
		}
		
		tokensRe = defTokens + "|" + JoinArrayList(dels, '|');
		inputStr = inputStr.substring(curIter);
	}
	
	
	
	/**
	 * Add numbers 
	 * 
	 * @param numbers
	 * @return
	 * @throws NegativeExc
	 */
	public int Add(String numbers) throws NegativeExc {
		
		inputStr = numbers;
		splitNumbers = false;
		tokensRe = defTokens;

		
		ArrayList<String> negValues = new ArrayList<String>();
		int res = 0;
		if(inputStr.length() == 0) {
			return res;
		}
		
		if(inputStr.length() > 1) {
			if(inputStr.charAt(0) == '/' && inputStr.charAt(1) == '/') {
				if(inputStr.charAt(2) == '[') {
					inputStr = inputStr.substring(2);
					MulDelimiters();
				}
				else {
					inputStr = inputStr.substring(2);
					AddDelimiter();
				}
			}
		}
		
		String []tokens = inputStr.split(tokensRe);
		for(String value : tokens) {
			if(splitNumbers) {
				for(int i = 0; i < value.length(); i++) {
					res += Character.getNumericValue(value.charAt(i));
				}
			}
			else { 
				int parseVal = Integer.parseInt(value);
				if(parseVal < 0)
					negValues.add(value);
				if(parseVal < 1000 && parseVal > 0)
					res += Integer.parseInt(value);
			}
		}
		
		if(negValues.size() > 0)
			throw new NegativeExc(JoinArrayList(negValues,','));
		return res;
	}
}
