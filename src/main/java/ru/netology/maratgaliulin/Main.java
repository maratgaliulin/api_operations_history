package ru.netology.maratgaliulin;
import ru.netology.maratgaliulin.customer_classes.*;
import static ru.netology.maratgaliulin.customer_classes.StaticMethods.*;


public class Main {
    public static void main(String[] args) {

        Customer[] clientLIst = MakeClientList();  // СОЗДАНИЕ СПИСКА КЛИЕНТОВ
        Integer[] CustomerIDArr = getCustomerIds(clientLIst);  // СОЗДАНИЕ СПИСКА ID КЛИЕНТОВ

        Operation[] operationsList = MakeOperationList(CustomerIDArr);  // СОЗДАНИЕ СПИСКА ОПЕРАЦИЙ
        Integer[] OperationIdArr = getTransactionIds(operationsList);  // СОЗДАНИЕ СПИСКА ID ОПЕРАЦИЙ

        Integer[][] AllIDArr = saveClientsAndOperationsIDs(CustomerIDArr, OperationIdArr);   // СОХРАНЕНИЕ ID КЛИЕНТОВ И ОПЕРАЦИЙ


//      ВЫВОД В КОНСОЛЬ ИНФОРМАЦИИ О КЛИЕНТАХ, ТРАНЗАКЦИЯХ И ИХ ID

        printCustomers(clientLIst);
        printOperations(operationsList);
        printCustomerAndOperationIds(AllIDArr);

    }
}