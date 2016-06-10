package com.javarush.test.level09.lesson11.home05;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* Гласные и согласные буквы
Написать программу, которая вводит с клавиатуры строку текста.
Программа должна вывести на экран две строки:
1. первая строка содержит только гласные буквы
2. вторая - только согласные буквы и знаки препинания из введённой строки.
Буквы соединять пробелом, каждая строка должна заканчиваться пробелом.

Пример ввода:
Мама мыла раму.
Пример вывода:
а а ы а а у
М м м л р м .
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        char[] array = reader.readLine().toCharArray();
        StringBuffer sbVovels = new StringBuffer();
        StringBuffer sbOther = new StringBuffer();
        for (int i = 0; i < array.length; i++)
        {
            if (isVowel(array[i]))
            {
                sbVovels.append(array[i]);
                sbVovels.append(" ");
                //if (i!=(array.length-1)) sbVovels.append(" ");
            }
            else if (array[i]!=' ')
            {
                sbOther.append(array[i]);
                sbOther.append(" ");
                //if (i!=(array.length-1)) sbOther.append(" ");
            }
        }
        System.out.println(sbVovels.toString());
        System.out.println(sbOther.toString());
    }


    public static char[] vowels = new char[]{'а', 'я', 'у', 'ю', 'и', 'ы', 'э', 'е', 'о', 'ё'};

    //метод проверяет, гласная ли буква
    public static boolean isVowel(char c)
    {
        c = Character.toLowerCase(c);  //приводим символ в нижний регистр - от заглавных к строчным буквам

        for (char d : vowels)   //ищем среди массива гласных
        {
            if (c == d)
                return true;
        }
        return false;
    }
}
