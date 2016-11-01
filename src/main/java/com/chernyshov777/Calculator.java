package com.chernyshov777;

import com.chernyshov777.exceptions.NegativeNumberException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Калькулятор с методом int add(String numbers), который вычисляет
 * сумму чисел во входной строке.
 * @author Chernyshov Daniil
 */
public class Calculator {
    private static String delimiterPattern = "//([\\W*])*\n";

    private ArrayList<Integer> numbersArray;

    public Calculator() {
        numbersArray = new ArrayList<Integer>();
    }

    /**
     * Метод принимает строку с числами и возвращает сумму чисел
     * @param numbers строка с числами
     * @return сумма чисел
     */
    public int add(String numbers) {
        String delimiters = findDelimiter(numbers);
        System.out.println("delimiter = " + delimiters);
        if (delimiters != null) {
            // есть разделитель
            numbers = depatchNumberStringFromDilimiters(numbers);
            System.out.println("Input string without first part = " + numbers);
            String[] strings = splitInputString(delimiters, numbers);
            numbersArray = pickOutIntegers(strings);
            System.out.println("Array with numbers = " + numbersArray);
            try {
                checkNegativeNumbers(numbersArray);
            } catch (NegativeNumberException e) {
                e.printStackTrace();
            }
        } else {
            // нет разделителя
            numbersArray = pickOutIntegers(numbers);
            System.out.println("Array with numbers = " + numbersArray);
        }

        return sum(numbersArray);
    }

    /**
     * Проверяет больше ли заданное число, чем 1000.
     * @return true - число больше 1000, false - число меньше 1000
     */
    private boolean isBigger1000(int number) {
        if (number > 1000) {
            return true;
        }
        return false;
    }

    /**
     * Вычисляет сумму чисел массива
     * @param integers массив с числами
     * @return сумма чисел массива
     */
    private int sum(ArrayList<Integer> integers) {
        int result = 0;
        for (int integer : integers) {
            if (!isBigger1000(integer)) {
                result += integer;
            }
        }
        return result;
    }

    /**
     * Поиск разделителя во входной строке
     * @return разделитель
     */
    private String findDelimiter(String inputString) {
        String del = null;
        String delimiterConcat = null;

        //выделение части строки, где прописаны разделители
        Pattern p = Pattern.compile(delimiterPattern);
        Matcher m = p.matcher(inputString);

        while (m.find()) {
            del = m.group();
        }

        //создание регулярного выражение, состоящего из разделителей, связанных оператором "или"
        if (del != null) {
//            Pattern pp = Pattern.compile("\\[([^\\[\\]])*\\]");
            Pattern pp = Pattern.compile("\\[([^\\[\\]])*\\]");
            Matcher mm = pp.matcher(del);
            while (mm.find()) {
                if (delimiterConcat != null) {
                    delimiterConcat = delimiterConcat + "|" + mm.group().replaceAll("[\\[\\]]*", "");
                } else {
                    delimiterConcat = mm.group().replaceAll("[\\[\\]]*", "");
                }
            }
        }
        return delimiterConcat;
    }

    /**
     * Отделение части строки, где прописаны разделители, от части строки, где
     * прописаны числа.
     * @param inputString исходная строка
     * @return строка без первой части
     */
    private String depatchNumberStringFromDilimiters(String inputString) {
        //выделение части строки, где прописаны разделители
        String del = null;
        Pattern p = Pattern.compile(delimiterPattern);
        Matcher m = p.matcher(inputString);

        while (m.find()) {
            del = m.group();
        }
        return inputString.replace(del, "");
    }

    /**
     * Разделить входную строку по разделителю
     * @param delimiter разделитель
     * @return массив строк, полученный после разделения входной строки
     */
    private String[] splitInputString(String delimiter, String inputString) {
        return inputString.split(delimiter);
    }

    /**
     * Выделение в каждой подстроке чисел, т.е. [//123~!!!4]->[1234]
     * @param strings массив строк, в котором нужно выделить числа
     */
    private ArrayList<Integer> pickOutIntegers(String[] strings) {
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        Pattern p = Pattern.compile("-?\\d+");
        for (String s : strings) {
            try {
                Integer.parseInt(s);
            } catch (NumberFormatException e) {continue;}

            try {
                Matcher m = p.matcher(s);
                while (m.find()) {
                    numbers.add(Integer.parseInt(m.group()));
                }
            } catch (NumberFormatException e) {}
        }
        return numbers;
    }

    /**
     * Преобразование строки чисел в массив чисел
     * @param stringNumbers строка с числами
     * @return массив чисел
     */
    private ArrayList<Integer> pickOutIntegers(String stringNumbers) {
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        Pattern p = Pattern.compile("-?\\d");
        Matcher m = p.matcher(stringNumbers);
        while (m.find()) {
            numbers.add(Integer.parseInt(m.group()));
        }
        return numbers;
    }

    /**
     * Проверка массива на наличие отрицательных чисел
     * @param numbers массив с числами
     * @throws NegativeNumberException
     */
    private void checkNegativeNumbers(ArrayList<Integer> numbers) throws NegativeNumberException{
        for (int number : numbers) {
            if (number < 0) {
                throw new NegativeNumberException("Negatives not allowed");
            }
        }
    }
}
