package ru.netology.maratgaliulin;
import ru.netology.maratgaliulin.customer_classes.*;
import static ru.netology.maratgaliulin.customer_classes.StaticMethods.*;


public class Main {
    public static void main(String[] args) {

        Customer[] clientLIst = MakeClientList();
        Integer[] CustomerIDArr = getCustomerIds(clientLIst);

        Operation[] operationsList = MakeOperationList(CustomerIDArr);
        Integer[] OperationIdArr = getTransactionIds(operationsList);

        Integer[][] AllIDArr = saveClientsAndOperationsIDs(CustomerIDArr, OperationIdArr);



        printCustomers(clientLIst);
        printOperations(operationsList);
        printCustomerAndOperationIds(AllIDArr);

    }
}