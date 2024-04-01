package ru.netology.maratgaliulin.service_classes;

import ru.netology.maratgaliulin.customer_classes.CashbackOperation;
import ru.netology.maratgaliulin.customer_classes.Customer;
import ru.netology.maratgaliulin.customer_classes.LoanOperation;
import ru.netology.maratgaliulin.customer_classes.Operation;
import ru.netology.maratgaliulin.exceptions.IntegerInputMismatchException;
import ru.netology.maratgaliulin.exceptions.NameInputMismatchException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IOService {

//    ОПЕРАЦИИ ВВОДА ДАННЫХ

    public static List<String> InputCustomerCredentials(){

        List<String> list = new ArrayList<>();

        Scanner scan = new Scanner(System.in);

        String namePattern = "(?<!\\S&&[^,])[a-zA-Z-а-яёА-ЯЁ]+(?!\\S&&[^,])";
        String emailPattern = "^[a-zA-Z0-9_!#$%&'*+/=?``{|}~^.-]+@[a-zA-Z0-9.-]+$";
        String phonePattern = "^(\\+\\d{1,3}( )?)?((\\(\\d{1,3}\\))|\\d{1,3})[- .]?\\d{3,4}[- .]?\\d{4}$";
        String datePattern = "\\d{2}-\\d{2}-\\d{4}";

        System.out.println("Введите фамилию клиента: ");
        String lastName = scan.next();
        list.add(CheckOutput(lastName, namePattern,
                "Фамилия не должна содержать цифры и специальные символы, но было указано: "));

        System.out.println("Введите имя клиента: ");
        String firstName = scan.next();
        list.add(CheckOutput(firstName, namePattern,
                "Имя не должно содержать цифры и специальные символы, но было указано: "));

        System.out.println("Введите email клиента: ");
        String email = scan.next();
        list.add(CheckOutput(email, emailPattern,
                "Указан неверный формат электронной почты - mail@yandex.ru, а было указано: "));

        System.out.println("Введите номер телефона клиента: ");
        String phoneNo = scan.next();
        list.add(CheckOutput(phoneNo, phonePattern,
                "Указан неверный формат номера телефона - +1(123)4567890 или +11234567890, а было указано: "));

        System.out.println("Введите дату рождения клиента (дд-мм-гггг): ");
        String DOB = scan.next();
        list.add(CheckOutput(DOB, datePattern,
                "Указан неверный формат даты рождения - дд-мм-гггг, а было указано: "));

        return list;
    }
    public static int InputCustomerArrayLength() throws IntegerInputMismatchException{
        Scanner scan = new Scanner(System.in);

        System.out.print("Введите количество клиентов: ");

        int customerArrLen;

        if(scan.hasNextInt()){
            customerArrLen = scan.nextInt();
        }else {
            throw new IntegerInputMismatchException(scan.next());
        }

        return customerArrLen;
    }

    public static List<String> InputOperationProperties(Customer customer){

        List<String> list = new ArrayList<>();
        Scanner scan = new Scanner(System.in);

        System.out.println("Введите тип операции (1 - кэшбэк, 2 - займ): ");

        String opType = scan.next();

        if(!opType.equals("1") && !opType.equals("2")){
            System.out.println("Введет неверный тип операции.");
        }

        String cliID = customer.getClientID();


        System.out.println("Введите объем операции: ");
        String OpAmount = scan.next();

        list.add(opType);

        list.add(cliID);

        list.add(OpAmount);

        return list;
    }


//    ОПЕРАЦИИ ВЫВОДА

    public static void PrintCustomers(List<Customer> customers) {
        for (Customer cus : customers){
            cus.print();
        }
    }

    public static void printOperations(List<Operation> operations) {
        for (Operation op : operations){
            op.print();
        }
    }


    //    МЕТОДЫ ДЛЯ ПРОВЕРКИ ПРАВИЛЬНОСТИ ВВОДА:

    public static boolean MatchPattern(String str, String RegExPattern){
        Pattern pattern = Pattern.compile(RegExPattern);
        Matcher matcher = pattern.matcher(str);
        return matcher.matches();
    }

    public static String CheckOutput(String input, String RegExPattern, String ErrorMsg){
        if(MatchPattern(input, RegExPattern)){
            return input;
        }else {
            throw new NameInputMismatchException(ErrorMsg, input);
        }
    }

}
