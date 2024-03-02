package ru.netology.maratgaliulin;
import ru.netology.maratgaliulin.customer_classes.*;

import java.math.BigDecimal;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Customer customer = new Customer(123, "Marat", "Galiulin", "marat@mail.ru", "+7123456789", "14-05-1986");

        customer.print();

        Operation op = new CashbackOperation(123, 12, 2.5);

        op.print();

        Scanner scan = new Scanner(System.in);

        System.out.print("Введите количество клиентов: ");
        int customerArrLen = scan.nextInt();

        System.out.print("Введите количество транзакций: ");
        int operationArrLen = scan.nextInt();

        Customer[] customers = new Customer[customerArrLen];

        Operation[] operations = new Operation[operationArrLen];




    }
}