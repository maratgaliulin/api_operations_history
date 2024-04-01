package ru.netology.maratgaliulin.service_classes;

import ru.netology.maratgaliulin.customer_classes.Operation;

import java.util.LinkedList;
import java.util.Queue;

public class AsyncInputOperationService {
    private Queue<Operation> queue = new LinkedList<>();
    private final OperationService operationService;

//    КОНСТРУКТОРЫ

    public AsyncInputOperationService(Queue<Operation> queue, OperationService operationService) {
        this.queue = queue;
        this.operationService = operationService;
    }

    public boolean offerOperation(Operation operation){
        return queue.offer(operation);
    }
    public void addOperation(Operation operation){
        queue.add(operation);
    }


    private void processQueue() {
        int i = 0;
        while (i < 10) {
            Operation operation = queue.poll();
            if (operation == null) {
                try { System.out.println("Waiting for next operation in queue");
                    Thread.sleep(1_000); }
                catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } }
            else {
                System.out.println("Processing operation:" + operation);
                operationService.addOperation(operation);
            }

            i++;
        }
    }

    public void startAsyncOperationProcessing() {
        Thread t = new Thread()
        { @Override public void run() {
            processQueue(); }
        }; t.start(); }
}
