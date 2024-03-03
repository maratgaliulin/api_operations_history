package ru.netology.maratgaliulin;
import ru.netology.maratgaliulin.customer_classes.*;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Scanner;

import static java.util.Collections.sort;

public class Main {
    public static void main(String[] args) {


        Scanner scan = new Scanner(System.in);

        System.out.print("Введите количество клиентов: ");
        int customerArrLen = scan.nextInt();

        System.out.print("Введите количество транзакций: ");
        int operationArrLen = scan.nextInt();

        Customer[] customers = new Customer[customerArrLen];

        Operation[] operations = new Operation[operationArrLen];

        Integer[] IDArr = new Integer[customerArrLen];
        String[] firstNameArr = new String[customerArrLen];
        String[] lastNameArr = new String[customerArrLen];
        String[] emailArr = new String[customerArrLen];
        String[] phoneArr = new String[customerArrLen];
        String[] DOBArr = new String[customerArrLen];

        int[] opClientIDArr = new int[operationArrLen];
        int[] operationIDArr = new int[operationArrLen];
        double[] amountArr = new double[operationArrLen];

        for (int i = 0; i < customerArrLen; i++){
            System.out.println("Введите ID клиента: ");
            IDArr[i] = scan.nextInt();

            System.out.println("Введите фамилию клиента: ");
            lastNameArr[i] = scan.next();

            System.out.println("Введите имя клиента: ");
            firstNameArr[i] = scan.next();

            System.out.println("Введите email клиента: ");
            emailArr[i] = scan.next();

            System.out.println("Введите номер телефона клиента: ");
            phoneArr[i] = scan.next();

            System.out.println("Введите дату рождения клиента (дд-мм-гггг): ");
            DOBArr[i] = scan.next();

            customers[i] = new Customer(IDArr[i], firstNameArr[i], lastNameArr[i], emailArr[i], phoneArr[i], DOBArr[i]);
        }

        for (int i = 0; i < operationArrLen; i++){
            System.out.println("Введите тип операции (1 - кэшбэк, 2 - займ): ");
            int opType = scan.nextInt();
            if(opType != 1 && opType != 2){
                System.out.println("Введет неверный тип операции.");
                break;
            }

            System.out.println("Введите ID клиента из имеющихся клиентов " + Arrays.toString(IDArr) + ": ");
            Integer cliID = scan.nextInt();

            if(Arrays.asList(IDArr).contains(cliID)){
                opClientIDArr[i] = cliID;
            }
            else {
                System.out.println("Клиента с таким ID не существует.");
                break;
            }
            System.out.println("Введите ID операции: ");
            operationIDArr[i] = scan.nextInt();

            System.out.println("Введите объем операции: ");
            amountArr[i] = scan.nextDouble();

            if(opType == 1){
                operations[i] = new CashbackOperation(opClientIDArr[i], operationIDArr[i], amountArr[i]);
            }
            else {
                operations[i] = new LoanOperation(opClientIDArr[i], operationIDArr[i], amountArr[i]);
            }
        }

        for (int i = 0; i < customerArrLen; i++){
            customers[i].print();
        }

        for (int i = 0; i < operationArrLen; i++){
            operations[i].print();
        }


    }
}