package com.javarush.test.level09.lesson11.bonus03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* Задача по алгоритмам
Задача: Пользователь вводит с клавиатуры список слов (и чисел). Слова вывести в возрастающем порядке, числа - в убывающем.
Пример ввода:
Вишня
1
Боб
3
Яблоко
2
0
Арбуз
Пример вывода:
Арбуз
3
Боб
2
Вишня
1
0
Яблоко
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<String>();
        while (true)
        {
            String s = reader.readLine();
            if (s.isEmpty()) break;
            list.add(s);
        }

        String[] array = list.toArray(new String[list.size()]);
        sort(array);

        for (String x : array)
        {
            System.out.println(x);
        }
    }

    public static void sort(String[] array)
    {
        int length = array.length;
        int maxPos, minPos, comparableFirst, comparableSecond;
        String buffer;

        int counter = 0;
        for (int i = 0; i < length; i++, counter++) {
            if (isNumber(array[i])) { // if string is number
                // find greatest number and put on current position
                maxPos = i;

                for (int j = i + 1; j < length; j++) {
                    // compare each next number in array with current one
                    if (isNumber(array[j])) {
                        comparableFirst = Integer.parseInt(array[j]);
                        comparableSecond = Integer.parseInt(array[maxPos]);

                        if (comparableFirst > comparableSecond) {
                            // remember max position
                            maxPos = j;
                        }
                    }
                }

                // exchange current item with item on max position
                if (maxPos != i) {
                    buffer = array[i];
                    array[i] = array[maxPos];
                    array[maxPos] = buffer;
                }
            } else { // if string is string
                // find smallest string and put on current position
                minPos = i;

                for (int j = i + 1; j < length; j++) {
                    // compare each next string in array with current one
                    if (!isNumber(array[j]) && !isGreaterThan(array[j], array[minPos])) {
                        // remember min position
                        minPos = j;
                    }
                }

                // exchange current item with item on min position
                if (minPos != i) {
                    buffer = array[i];
                    array[i] = array[minPos];
                    array[minPos] = buffer;
                }
            }
        }
    }

    //Метод для сравнения строк: 'а' больше чем 'b'
    public static boolean isGreaterThan(String a, String b)
    {
        return a.compareTo(b) > 0;
    }


    //строка - это на самом деле число?
    public static boolean isNumber(String s)
    {
        if (s.length() == 0) return false;

        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++)
        {
            char c = chars[i];
            if ((i != 0 && c == '-') //есть '-' внутри строки
                    || (!Character.isDigit(c) && c != '-') ) // не цифра и не начинается с '-'
            {
                return false;
            }
        }
        return true;
    }
}
