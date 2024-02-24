package ru.netology.maratgaliulin;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String name = "Marat Galiulin";
        System.out.println("Hello, " + name + "!!!!");

        System.out.println("Введите строку: ");
        String s = scan.nextLine();

        System.out.println("Введите целое число: ");
        int i = scan.nextInt();

        System.out.println("Введите десятичное дробное число: ");
        float f = scan.nextFloat();

        System.out.println("Вы ввели: " + i + ", " + f + ", " + s);

    }
}