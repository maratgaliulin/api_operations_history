package ru.netology.maratgaliulin.customer_classes;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.format.DateTimeFormatter;

public class Operation implements Serializable {
    private int clientID;

    private int operationID;
    private BigDecimal amount;
    private String operationType;


    public Operation() {}

    public Operation(int clientID, int operationID, double amount) {
        this.clientID = clientID;
        this.operationID = operationID;
        this.amount = BigDecimal.valueOf(amount);
    }

    public int getClientID() {
        return clientID;
    }

    public String getOperationType() {
        return operationType;
    }

    public void setClientID(int clientID) {
        this.clientID = clientID;
    }

    public int getOperationID() {
        return operationID;
    }

    public void setOperationID(int operationID) {
        this.operationID = operationID;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = BigDecimal.valueOf(amount);
    }

    public void print(){

    }
}
