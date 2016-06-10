package com.javarush.test.level09.lesson11.home08;

import java.util.ArrayList;

/* Список из массивов чисел
Создать список, элементами которого будут массивы чисел. Добавить в список пять объектов–массивов длиной 5, 2, 4, 7, 0 соответственно. Заполнить массивы любыми данными и вывести их на экран.
*/

public class Solution
{
    public static void main(String[] args)
    {
        ArrayList<int[]> list = createList();
        printList(list);
    }

    public static ArrayList<int[]> createList()
    {
        ArrayList<int[]> list = new ArrayList<int[]>();
        int[] aNull = new int[5];
        int[] aOne = new int[2];
        int[] aTwo = new int[4];
        int[] aThree = new int[7];
        int[] aFour = new int[0];
        list.add(aNull);
        list.add(aOne);
        list.add(aTwo);
        list.add(aThree);
        list.add(aFour);
        for (int[] array : list)
        {
            for (int i = 0; i < array.length; i++)
            {
                array[i] = 1;
            }
        }
        return list;
    }

    public static void printList(ArrayList<int[]> list)
    {
        for (int[] array: list )
        {
            for (int x: array)
            {
                System.out.println(x);
            }
        }
    }
}
