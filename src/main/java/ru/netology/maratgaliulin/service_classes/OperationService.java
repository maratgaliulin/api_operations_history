package ru.netology.maratgaliulin.service_classes;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import ru.netology.maratgaliulin.customer_classes.CashbackOperation;
import ru.netology.maratgaliulin.customer_classes.Customer;
import ru.netology.maratgaliulin.customer_classes.LoanOperation;
import ru.netology.maratgaliulin.customer_classes.Operation;
import ru.netology.maratgaliulin.exceptions.IntegerInputMismatchException;
import static ru.netology.maratgaliulin.service_classes.CustomerService.getCustomerById;
import static ru.netology.maratgaliulin.service_classes.CustomerService.getCustomerIds;
import static ru.netology.maratgaliulin.service_classes.IOService.InputOperationProperties;

public class OperationService {
    public static Operation MakeSingleOperation(List<String> inputList){
        Operation operation;

        if (inputList.get(0).equals("1")){
            operation = new CashbackOperation(inputList.get(1), Double.parseDouble(inputList.get(2)));
        } else {
            operation = new LoanOperation(inputList.get(1), Double.parseDouble(inputList.get(2)));
        }

        return operation;
    }
    public static List<Operation> MakeOperationList(List<Customer> customers) {

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
    public static List<String> getOperationIds(List<Operation> operations){

        List<String> OperationIds = new ArrayList<>();

        for (Operation operation : operations) {
            OperationIds.add(operation.getOperationID());
        }

        return OperationIds;
    }


}
