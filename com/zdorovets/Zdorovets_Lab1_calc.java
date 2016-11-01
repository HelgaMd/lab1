package com.zdorovets;
import java.util.ArrayList;
/*
 * NegativeException class
 * @author Evgeny Zdorovets
 * @version 9.5
 * created on 04/10/16
 */
class NegativeException extends Exception {
    private static final long serialVersionUID = 1L;
    public NegativeException(String message) {
        super(message);
    }
}
/*
 * Calculator class
 * @author Evgeny Zdorovets
 * @version 9.5
 * created on 04/10/16
 */
class Zdorovets_Lab1_calc {
	private static String delimiter;
	private static String numbersWithoutDelimiter;
	private static String input;
    /*
     * Метод add(String input_string)
     * Нужен в случае со сложным(-и) разделителями 
     * для выделения разделителя и самого арифм. выражения
     * Если не используются сложные разделители, 
     * то по умолчанию - "," и "\n"
     * @param input_string входная строка, 
     * состоящая из разделителя(-ей) и выражения 
     * @return сумма двух чисел, либо исключение  
     */
    public static int add(String input_string) throws NumberFormatException, NegativeException {
        input = input_string; 
        delimiter = ",|\n"; // разделитель по умолчанию
        numbersWithoutDelimiter = input;
        if (existDelimiters())
            delimiter = ""; // если есть разделители со скобками, 
                            //то начальный разделитель равен ""
        int currentDelimIndex; // индекс символа, относящегося к разделителю, в строке
        while (existDelimiters()) { //пока есть разделители
        	// выделяется индекс, следующий за "//" и символом квадратной скобки
            currentDelimIndex = getDelimIndexWithOffset(3);
            if (isNotEmptyDelimiter())
                delimiter = delimiter.concat("|"); // добавление символа, 
                                                   // разделяющего разделители
            // пока не конец разделителя
            while (symbolBelongsToDelimiter(currentDelimIndex)) { 
            	// добавление к разделителю текущего символа
                delimiter = delimiter.concat(input.substring(currentDelimIndex, currentDelimIndex + 1)); 
                currentDelimIndex++;
            }
            // удаление очередного разделителя из анализируемой строки
            input = input.substring(currentDelimIndex + 1);  
            if (existMoreDelimiters()) { // если есть еще разделители
            	// то прибавляем "//" для будущего анализа
                input = "//".concat(input); 
            } else {
            	// иначе выделяется строка без разделителя  
            	numbersWithoutDelimiter = input.substring(input.indexOf("\n") + 1);  
            }
        }

        if (existsShortDelimiter()) {
            int delimIndex = getDelimIndexWithOffset(2);
            delimiter = input.substring(delimIndex, delimIndex + 1); // разделитель состоит из одного символа
            numbersWithoutDelimiter = input.substring(input.indexOf("\n") + 1);
        }
        return add(numbersWithoutDelimiter, delimiter);
    }
    /*
     * Метод add(String input, String delimiter)
     * Нужен для вычисления суммы
     * @param input входная строка
     * @param delimiter входной разделитель
     * @return сумма двух чисел, либо исключение 
     */
    public static int add(String input, String delimiter) throws NumberFormatException, NegativeException {
        int sum = 0;
        String[] numbers = input.split(delimiter);
        ArrayList < Integer > negativeList = new ArrayList < Integer > ();
        int num;
        for (String number: numbers) {
            if (!number.trim().isEmpty()) {
                num = Integer.parseInt(number.trim());
                if (num < 0)
                    negativeList.add(num);
                else if (num <= 1000)
                    sum += num;
            }
        }
        if (negativeList.size() > 0) {
            throw new NegativeException("Negatives not allowed: " + negativeList.toString());
        }
        return sum;
    }
    /* 
     * @return есть ли длинный разделитель в строке (начинающийся с "//[")
     */
    public static boolean existDelimiters(){
    	return input.startsWith("//[");
    }
    /* 
     * @return есть ли длинный разделитель в строке (начинающийся с "[", без учета символов "//")
     */
    public static boolean existMoreDelimiters(){
    	return input.startsWith("[");
    }
    /* 
     * @return есть ли короткий разделитель в строке (начинающиеся с "//")
     */
    public static boolean existsShortDelimiter(){
    	return input.startsWith("//");
    }
    /* 
     * @param offset смещение
     * @return индекс разделителя со смещением
     */
    public static int getDelimIndexWithOffset(int offset){
    	return input.indexOf("//") + offset;
    }
    /* 
     * @return истина, если разделитель не равен пустой строке  
     */
    public static boolean isNotEmptyDelimiter(){
    	return !"".equals(delimiter);
    }
    /* 
     * @param currentDelimIndex текущий индекс разделителя
     * @return истина, если нет символа завершения ("]")
     */
    public static boolean symbolBelongsToDelimiter(int currentDelimIndex){
    	return !input.substring(currentDelimIndex, currentDelimIndex + 1).equals("]");
    }

}