package ru.netology.maratgaliulin.customer_classes;

import java.io.*;
import java.time.format.DateTimeFormatter;
import java.util.List;

import ru.netology.maratgaliulin.exceptions.IntegerInputMismatchException;
import ru.netology.maratgaliulin.exceptions.NameInputMismatchException;
import static ru.netology.maratgaliulin.service_classes.CustomerService.MakeCustomerList;
import static ru.netology.maratgaliulin.service_classes.IOService.InputCustomerArrayLength;
import static ru.netology.maratgaliulin.service_classes.OperationService.MakeOperationList;
import static ru.netology.maratgaliulin.service_classes.StatementService.DeserializeOpData;
import static ru.netology.maratgaliulin.service_classes.StorageService.SerializeOpData;

public class OperationData implements Serializable {
    private List<Customer> customers;
    private List<Operation> operations;

//    КОНСТРУКТОРЫ

    public OperationData() {}


//    ГЕТТЕРЫ

    public List<Customer> getCustomers() {
        return customers;
    }
    public List<Operation> getOperations() {
        return operations;
    }


//    СЕТТЕРЫ

    private void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }
    private void setOperations(List<Operation> operations) {
        this.operations = operations;
    }


//    МЕТОДЫ ЗАПОЛНЕНИЯ КЛАССА OPERATIONDATA ПРИ ПОМОЩИ ПОЛЬЗОВАТЕЛЬСКОГО ВВОДА

    public void MakeClientList() throws IntegerInputMismatchException, NameInputMismatchException {

        List<Customer> customers = MakeCustomerList(InputCustomerArrayLength());

        setCustomers(customers);

    }

    public void makeOperationList() {

        List<Operation> operations = MakeOperationList(customers);

        setOperations(operations);
    }


//    МЕТОДЫ СОХРАНЕНИЯ, СЕРИАЛИЗАЦИИ, ДЕСЕРИАЛИЗАЦИИ


    public void serializer() throws IOException {
        SerializeOpData(OperationData.this);
    }

    public void deserializer() throws IOException, ClassNotFoundException {
        DeserializeOpData();
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
