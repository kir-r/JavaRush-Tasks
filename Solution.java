package com.javarush.task.task18.task1821;

/* 
Встречаемость символов
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream inputStream = new FileInputStream(args[0]);

        byte[] buff = new byte[inputStream.available()];
        while (inputStream.available() > 0) {
            int i = inputStream.read(buff);
        }
        inputStream.close();

        ArrayList<Character> list = new ArrayList<>();
        for (byte b : buff)
            list.add((char) b); //список всех символов из файла;

        HashMap<Character, Integer> mapa = new HashMap<>();
        int freq;
        for (char c : list) {//
            freq = Collections.frequency(list, c); //высчитывает количество вхождений символа
            mapa.put(c, freq); //помещаем в мапу символ и количество его вхождений
        }

        ArrayList<Integer> numbersASCII = new ArrayList<>(); //сортируем символы
        for (Map.Entry<Character, Integer> pair : mapa.entrySet()) {
            numbersASCII.add((int)pair.getKey());
        }
        Collections.sort(numbersASCII);

        for (Integer i : numbersASCII) {
            System.out.println((char)(int)i + " " + mapa.get((char)(int)i));
            //выводим символ и его значение
        }

    }
}
