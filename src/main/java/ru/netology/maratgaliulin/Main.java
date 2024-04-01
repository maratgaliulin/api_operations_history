package ru.netology.maratgaliulin;

import ru.netology.maratgaliulin.customer_classes.LoanOperation;
import ru.netology.maratgaliulin.customer_classes.Operation;
import ru.netology.maratgaliulin.service_classes.AsyncInputOperationService;
import ru.netology.maratgaliulin.service_classes.OperationService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import static ru.netology.maratgaliulin.service_classes.CustomerService.getCustomerIds;


public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

//        OperationData opData = new OperationData();
//
//        opData.MakeClientList();
//        opData.makeOperationList();
//
//        opData.serializer();
//
//        opData.deserializer();

        OperationService operationService = new OperationService();
        operationService.makeClientList();
        operationService.makeOperationList();

        List<String> customerIDs = getCustomerIds(operationService.getCustomers());


        Queue<Operation> operations = new LinkedList<>();

        for (String customerID : customerIDs) {
            operations.add(new LoanOperation(customerID, "23456.56"));
        }

        AsyncInputOperationService asyncInputOperationService = new AsyncInputOperationService(operations, operationService);

        asyncInputOperationService.startAsyncOperationProcessing();



    }
}