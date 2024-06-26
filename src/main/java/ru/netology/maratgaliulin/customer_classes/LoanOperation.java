package ru.netology.maratgaliulin.customer_classes;

public class LoanOperation extends Operation{
    private final String operationType = "Loan";
    public LoanOperation() {
    }

    public LoanOperation(String clientID, String amount) {
        super(clientID, amount);
    }

    public String getOperationType() {
        return operationType;
    }

    @Override
    public void print() {
        System.out.println("Детали операции:");
        System.out.println("Тип операции: " + this.operationType + ".");
        System.out.println("ID клиента: " + super.getClientID() + ". \n" + "ID операции: " + super.getOperationID() + ".\n" + "Сумма операции: " + super.getAmount() + ". \n");
    }
}
