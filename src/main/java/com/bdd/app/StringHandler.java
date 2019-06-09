package com.bdd.app;

import java.util.Scanner;

public class StringHandler implements Handler {
    @Override
    public void handle() throws Exception {
        System.out.println("Выберите действие:");
        System.out.println("1 - Развернуть строку через массив char");
        System.out.println("2 - Развернуть строку через StringBuilder");
        System.out.println("3 - Удалить лишние пробелы в начале и в конце строки");
        System.out.println("4 - Привести все символы строки к верхнему регистру");
        System.out.println("5 - Извлечь подстроку с указанием начального и конечного индексов");
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        System.out.println("Введите строку:");
        String data = scanner.next();
        switch (input){
            case 1:
                reverseChars(data);
                break;
            case 2:
                reverseStringBuilder(data);
                break;
            case 3:
                deleteSpaces(data);
                break;
            case 4:
                upperCase(data);
                break;
            case 5:
                subString(data);
                break;
            default:
                throw new Exception("Некорректное значение");
        }
    }
    private void reverseChars(String data) {
        char[] array = data.toCharArray();
        char[] resultArray = new char[array.length];
        int reverseCount = array.length - 1;
        for (char c : array) {
            resultArray[reverseCount--] = c;
        }
        String result = new String(resultArray);
        System.out.println(result);
    }
    private void reverseStringBuilder(String data) {
        System.out.println(new StringBuilder(data).reverse());

    }
    private void deleteSpaces(String data) {
        System.out.println(data.trim());
    }

    private void upperCase(String data) {
        System.out.println(data.toUpperCase());
    }

    private void subString(String data) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите индекс начала строки:");
        int start = scanner.nextInt();
        System.out.println("Введите индекс окончания строки:");
        int end = scanner.nextInt();
        System.out.println(data.substring(start, end));
    }
}
