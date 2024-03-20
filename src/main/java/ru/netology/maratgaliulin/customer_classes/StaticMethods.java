package ru.netology.maratgaliulin.customer_classes;

import ru.netology.maratgaliulin.exceptions.IntegerInputMismatchException;
import ru.netology.maratgaliulin.exceptions.NameInputMismatchException;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class StaticMethods {

    public static Customer[] MakeClientList() throws IntegerInputMismatchException {
        Scanner scan = new Scanner(System.in);

        System.out.print("Введите количество клиентов: ");
        if(scan.hasNextInt()){
            int customerArrLen = scan.nextInt();
        }else {
            throw new IntegerInputMismatchException(scan.next());
        }
        int customerArrLen = 1;


        Customer[] customers = new Customer[customerArrLen];
        Integer[] IDArr = new Integer[customerArrLen];
        String[] firstNameArr = new String[customerArrLen];
        String[] lastNameArr = new String[customerArrLen];
        String[] emailArr = new String[customerArrLen];
        String[] phoneArr = new String[customerArrLen];
        String[] DOBArr = new String[customerArrLen];

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



        return customers;

    }
    public static Operation[] MakeOperationList(Integer[] IDArr) {

        Scanner scan = new Scanner(System.in);

        System.out.print("Введите количество транзакций: ");
        int operationArrLen = scan.nextInt();

        Operation[] operations = new Operation[operationArrLen];

        int[] opClientIDArr = new int[operationArrLen];
        int[] operationIDArr = new int[operationArrLen];
        double[] amountArr = new double[operationArrLen];

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

        return operations;
    }

    public static Integer[] getCustomerIds(Customer[] customers){
        int len = customers.length;

        Integer[] CustomerIds = new Integer[len];

        for (int i = 0; i < len; i++) {
            CustomerIds[i] = customers[i].getId();
        }

        return CustomerIds;
    }

    public static Integer[] getTransactionIds(Operation[] ops){
        int len = ops.length;

        Integer[] OperationIds = new Integer[len];

        for (int i = 0; i < len; i++) {
            OperationIds[i] = ops[i].getOperationID();
        }
        return OperationIds;
    }

    public static Integer[][] saveClientsAndOperationsIDs(Integer[] clientIDArr, Integer[] operationIDArr){
        return new Integer[][]{clientIDArr, operationIDArr};
    }

    public static void printOperations(Operation[] operations) {
        for (Operation op : operations){
            op.print();
        }
    }

    public static void printCustomers(Customer[] customers) {
        for (Customer cus : customers){
            cus.print();
        }
    }

    public static void printCustomerAndOperationIds(Integer[][] arr) {
        System.out.println(Arrays.deepToString(arr));
    }

}


