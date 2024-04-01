package ru.netology.maratgaliulin;

import ru.netology.maratgaliulin.customer_classes.Customer;
import ru.netology.maratgaliulin.customer_classes.Operation;
import ru.netology.maratgaliulin.customer_classes.OperationData;

import java.io.IOException;
import java.util.List;

import static ru.netology.maratgaliulin.service_classes.CustomerService.MakeCustomerList;
import static ru.netology.maratgaliulin.service_classes.CustomerService.getCustomerIds;
import static ru.netology.maratgaliulin.service_classes.IOService.*;
import static ru.netology.maratgaliulin.service_classes.OperationService.*;


public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        OperationData opData = new OperationData();

        opData.MakeClientList();
        opData.makeOperationList();

        opData.serializer();

        opData.deserializer();



    }
}