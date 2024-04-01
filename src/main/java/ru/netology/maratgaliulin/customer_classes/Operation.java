package ru.netology.maratgaliulin.customer_classes;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

public class Operation implements Serializable {
    private String clientID;

    private final String operationID = UUID.randomUUID().toString();;
    private BigDecimal amount;
    private String operationType;


    public Operation() {}

    public Operation(String clientID, double amount) {
        this.clientID = clientID;
        this.amount = BigDecimal.valueOf(amount);
    }

    public String getClientID() {
        return clientID;
    }

    public String getOperationType() {
        return operationType;
    }

    public void setClientID(String clientID) {
        this.clientID = clientID;
    }

    public String getOperationID() {
        return operationID;
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
