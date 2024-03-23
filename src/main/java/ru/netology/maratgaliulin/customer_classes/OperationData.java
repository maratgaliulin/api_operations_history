package ru.netology.maratgaliulin.customer_classes;

import ru.netology.maratgaliulin.exceptions.IntegerInputMismatchException;
import ru.netology.maratgaliulin.exceptions.NameInputMismatchException;

import java.io.*;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class OperationData implements Serializable {
    private Customer[] customers;
    private Operation[] operations;

    public OperationData() {}

    public Customer[] getCustomers() {
        return customers;
    }
    public Operation[] getOperations() {
        return operations;
    }

//    СЕТТЕРЫ

    public void setCustomers(Customer[] customers) {
        this.customers = customers;
    }
    public void setOperations(Operation[] operations) {
        this.operations = operations;
    }

//    ГЕТТЕРЫ (

    private Integer[] getCustomerIds(Customer[] customers){
        int len = customers.length;

        Integer[] CustomerIds = new Integer[len];

        for (int i = 0; i < len; i++) {
            CustomerIds[i] = customers[i].getId();
        }

        return CustomerIds;
    }
    private Integer[] getTransactionIds(Operation[] ops){
        int len = ops.length;

        Integer[] OperationIds = new Integer[len];

        for (int i = 0; i < len; i++) {
            OperationIds[i] = ops[i].getOperationID();
        }
        return OperationIds;
    }

//    МЕТОДЫ ПРОВЕРКИ

    private boolean MatchPattern(String str, String RegExPattern){
        Pattern pattern = Pattern.compile(RegExPattern);
        Matcher matcher = pattern.matcher(str);
        return matcher.matches();
    }
    private String CheckOutput(String input, String RegExPattern, String ErrorMsg){
        if(MatchPattern(input, RegExPattern)){
            return input;
        }else {
            throw new NameInputMismatchException(ErrorMsg, input);
        }
    }


//    МЕТОДЫ ЗАПОЛНЕНИЯ КЛАССА OPERATIONDATA ПРИ ПОМОЩИ ПОЛЬЗОВАТЕЛЬСКОГО ВВОДА

    public void MakeClientList() throws IntegerInputMismatchException, NameInputMismatchException {
        Scanner scan = new Scanner(System.in);

        System.out.print("Введите количество клиентов: ");

        int customerArrLen = 1;

        if(scan.hasNextInt()){
            customerArrLen = scan.nextInt();
        }else {
            throw new IntegerInputMismatchException(scan.next());
        }

        String namePattern = "(?<!\\S&&[^,])[a-zA-Z-а-яёА-ЯЁ]+(?!\\S&&[^,])";
        String emailPattern = "^[a-zA-Z0-9_!#$%&'*+/=?``{|}~^.-]+@[a-zA-Z0-9.-]+$";
        String phonePattern = "^(\\+\\d{1,3}( )?)?((\\(\\d{1,3}\\))|\\d{1,3})[- .]?\\d{3,4}[- .]?\\d{4}$";
        String datePattern = "\\d{2}-\\d{2}-\\d{4}";

        Customer[] customers = new Customer[customerArrLen];
        Integer[] IDArr = new Integer[customerArrLen];
        String[] firstNameArr = new String[customerArrLen];
        String[] lastNameArr = new String[customerArrLen];
        String[] emailArr = new String[customerArrLen];
        String[] phoneArr = new String[customerArrLen];
        String[] DOBArr = new String[customerArrLen];

        for (int i = 0; i < customerArrLen; i++){

            System.out.println("Введите ID клиента: ");
            if(scan.hasNextInt()) {
                IDArr[i] = scan.nextInt();
            }else {
                throw new IntegerInputMismatchException(scan.next());
            }

            System.out.println("Введите фамилию клиента: ");
            String lastName = scan.next();
            lastNameArr[i] = CheckOutput(lastName, namePattern,
                    "Фамилия не должна содержать цифры и специальные символы, но было указано: ");

            System.out.println("Введите имя клиента: ");
            String firstName = scan.next();
            firstNameArr[i] = CheckOutput(firstName, namePattern,
                    "Имя не должно содержать цифры и специальные символы, но было указано: ");

            System.out.println("Введите email клиента: ");
            String email = scan.next();
            emailArr[i] = CheckOutput(email, emailPattern,
                    "Указан неверный формат электронной почты - mail@yandex.ru, а было указано: ");

            System.out.println("Введите номер телефона клиента: ");
            String phoneNo = scan.next();
            phoneArr[i] = CheckOutput(phoneNo, phonePattern,
                    "Указан неверный формат номера телефона - +1(123)4567890 или +11234567890, а было указано: ");

            System.out.println("Введите дату рождения клиента (дд-мм-гггг): ");
            String DOB = scan.next();
            DOBArr[i] = CheckOutput(DOB, datePattern,
                    "Указан неверный формат даты рождения - дд-мм-гггг, а было указано: ");

            customers[i] = new Customer(IDArr[i], firstNameArr[i], lastNameArr[i], emailArr[i], phoneArr[i], DOBArr[i]);
        }

        setCustomers(customers);

    }
    public void MakeOperationList() {

        Scanner scan = new Scanner(System.in);

        System.out.print("Введите количество транзакций: ");

        int operationArrLen = 1;

        if(scan.hasNextInt()) {
            operationArrLen = scan.nextInt();
        }else {
            throw new IntegerInputMismatchException(scan.next());
        }

        Integer[] IDArr = getCustomerIds(customers);

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

        setOperations(operations);
    }


//    МЕТОДЫ СОХРАНЕНИЯ, СЕРИАЛИЗАЦИИ, ДЕСЕРИАЛИЗАЦИИ

    public Integer[][] saveClientsAndOperationsIDs(){
        return new Integer[][]{getCustomerIds(customers), getTransactionIds(operations)};
    }

    public void SerializeOpData() throws IOException {
        String filePath = "E:\\1.WORKING-FOLDER\\3.Study\\4.Финтех_бакалавриат\\011.Программирование_на_Java\\api_operations_history\\Files\\save.ser";
        FileOutputStream outputStream = new FileOutputStream(filePath);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
        objectOutputStream.writeObject(OperationData.this);
    }

    public void DeserializeOpData() throws IOException, ClassNotFoundException {
        String filePath = "E:\\1.WORKING-FOLDER\\3.Study\\4.Финтех_бакалавриат\\011.Программирование_на_Java\\api_operations_history\\Files\\save.ser";
        FileInputStream fileInputStream = new FileInputStream(filePath);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

        OperationData operationData = (OperationData) objectInputStream.readObject();

        System.out.println("Десериализованный объект:");
        System.out.println(operationData);
    }


//    OVERRIDE METHODS

    @Override
    public String toString(){
        var f = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        StringBuilder str = new StringBuilder();
        if(customers != null){
            for (Customer cus : customers){
                str.append("Информация о клиенте:\n" + "ID клиента: ")
                        .append(cus.getClientID()).append(".\n")
                        .append("ФИО клиента: ").append(cus.getFirstName())
                        .append(" ").append(cus.getLastName())
                        .append(".\n").append("Дата рождения: ")
                        .append(cus.getDOB().format(f)).append(".\n")
                        .append("Email: ").append(cus.getEmail())
                        .append(".\n").append("Номер телефона: ")
                        .append(cus.getPhoneNo()).append(".\n").append("\n");
            }
        }

        if(operations != null){
            for (Operation op: operations){
                str.append("Детали операции: \n").append("Тип операции: ")
                        .append(op.getOperationType()).append(".")
                        .append("ID клиента: ").append(op.getClientID())
                        .append(". \n").append("ID операции: ")
                        .append(op.getOperationID()).append(".\n")
                        .append("Сумма операции: ").append(op.getAmount())
                        .append(". \n");
            }
        }
        return str.toString();
    }


}
