package ru.netology.maratgaliulin.service_classes;

import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import ru.netology.maratgaliulin.customer_classes.*;
import ru.netology.maratgaliulin.exceptions.IntegerInputMismatchException;
import ru.netology.maratgaliulin.exceptions.NameInputMismatchException;

import static ru.netology.maratgaliulin.service_classes.CustomerService.*;
import static ru.netology.maratgaliulin.service_classes.IOService.InputCustomerArrayLength;
import static ru.netology.maratgaliulin.service_classes.IOService.InputOperationProperties;
import static ru.netology.maratgaliulin.service_classes.StatementService.DeserializeOpData;
import static ru.netology.maratgaliulin.service_classes.StorageService.SerializeOpData;

public class OperationService {

    private List<Customer> customers;
    private List<Operation> operations;

//    КОНСТРУКТОРЫ

    public OperationService() {
    }
    public OperationService(List<Customer> customers, List<Operation> operations) {
        this.customers = customers;
        this.operations = operations;
    }

//    ГЕТТЕРЫ

    public List<Customer> getCustomers() {
        return customers;
    }
    public List<Operation> getOperations() {
        return operations;
    }

//    СЕТТЕРЫ (сделал их private, т.к. лучше заполнять экземпляр класса при помощи пользовательского ввода (см.ниже))

    private void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }
    private void setOperations(List<Operation> operations) {
        this.operations = operations;
    }

//    МЕТОДЫ ЗАПОЛНЕНИЯ ЭКЗЕМПЛЯРА КЛАССА OperationService ПРИ ПОМОЩИ ПОЛЬЗОВАТЕЛЬСКОГО ВВОДА

    public void makeClientList() throws IntegerInputMismatchException, NameInputMismatchException {

        List<Customer> customers = MakeCustomerList(InputCustomerArrayLength());

        setCustomers(customers);

    }

    public void makeOperationList() {

        List<Operation> operations = MakeOperationList(customers);

        setOperations(operations);
    }

    public void addOperation(Operation operation){
        operations.add(operation);
    }

//    МЕТОДЫ СОХРАНЕНИЯ, СЕРИАЛИЗАЦИИ, ДЕСЕРИАЛИЗАЦИИ


    public void serializer() throws IOException {
        SerializeOpData(OperationService.this);
    }

    public void deserializer() throws IOException, ClassNotFoundException {
        DeserializeOpData();
    }

//    OVERRIDE МЕТОДЫ

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

// PRIVATE МЕТОДЫ

    private Operation MakeSingleOperation(List<String> inputList){
        Operation operation;

        if (inputList.get(0).equals("1")){
            operation = new CashbackOperation(inputList.get(1), inputList.get(2));
        } else {
            operation = new LoanOperation(inputList.get(1), inputList.get(2));
        }

        return operation;
    }
    private List<Operation> MakeOperationList(List<Customer> customers) {

        List<Operation> operations = new ArrayList<>();

        List<String> IDArr = getCustomerIds(customers);

        Scanner scan = new Scanner(System.in);

        System.out.print("Введите количество транзакций: ");

        int operationArrLen;

        if(scan.hasNextInt()) {
            operationArrLen = scan.nextInt();
        }else {
            throw new IntegerInputMismatchException(scan.next());
        }


        for (int i = 0; i < operationArrLen; i++){
            System.out.println("Введите ID клиента из имеющихся: " + IDArr);
            String clID = scan.next();

            operations.add(MakeSingleOperation(InputOperationProperties(getCustomerById(customers, clID))));

        }

        return operations;
    }
    private List<String> getOperationIds(List<Operation> operations){

        List<String> OperationIds = new ArrayList<>();

        for (Operation operation : operations) {
            OperationIds.add(operation.getOperationID());
        }

        return OperationIds;
    }


}
