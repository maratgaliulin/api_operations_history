package ru.netology.maratgaliulin;
import ru.netology.maratgaliulin.customer_classes.*;

import java.io.IOException;


public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        OperationData opData = new OperationData();

        opData.MakeClientList();
        opData.MakeOperationList();

        opData.SerializeOpData();

        opData.DeserializeOpData();


    }
}