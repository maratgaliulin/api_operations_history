package ru.netology.maratgaliulin.service_classes;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class StatementService {

    public static void DeserializeOpData() throws IOException, ClassNotFoundException {
        String filePath = "E:\\1.WORKING-FOLDER\\3.Study\\4.Финтех_бакалавриат\\011.Программирование_на_Java\\api_operations_history\\Files\\save.ser";
        FileInputStream fileInputStream = new FileInputStream(filePath);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        OperationService operationService = (OperationService) objectInputStream.readObject();
        System.out.println("Десериализованный объект:");
        System.out.println(operationService);
    }
}
