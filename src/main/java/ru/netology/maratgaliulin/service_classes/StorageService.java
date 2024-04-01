package ru.netology.maratgaliulin.service_classes;

import java.io.*;

public class StorageService {

    public static <T> void SerializeOpData(T obj) throws IOException {
        String filePath = "E:\\1.WORKING-FOLDER\\3.Study\\4.Финтех_бакалавриат\\011.Программирование_на_Java\\api_operations_history\\Files\\save.ser";
        FileOutputStream outputStream = new FileOutputStream(filePath);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
        objectOutputStream.writeObject(obj);
    }


}
