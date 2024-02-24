package ru.netology.maratgaliulin;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class fiveTransactionsInput {
    private Map<String, String> passportCredentials = new HashMap<>();
    private Map <String, String> addressInfo = new HashMap<>();
    private Map <String, BigDecimal> financialInfo = new HashMap<>();

    public void setPassportCredentials() {
        Map<String, String> passportCredentials = new HashMap<>();
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите фамилию: ");
        String lastName = scan.nextLine();
        System.out.println("Введите имя: ");
        String firstName = scan.nextLine();
        System.out.println("Введите дату рождения: ");
        String dateOfBirth = scan.nextLine();

        passportCredentials.put("LastName", lastName);
        passportCredentials.put("FirstName", firstName);
        passportCredentials.put("DOB", dateOfBirth);

        this.passportCredentials = passportCredentials;
    }

    public void setAddressInfo() {
        Map<String, String> addressInfo = new HashMap<>();
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите адрес: ");
        String address = scan.nextLine();
        System.out.println("Введите адрес электронной почты: ");
        String email = scan.nextLine();
        System.out.println("Введите номер телефона: ");
        String tphNo = scan.nextLine();

        addressInfo.put("Address", address);
        addressInfo.put("email", email);
        addressInfo.put("phN", tphNo);

        this.addressInfo = addressInfo;
    }

    public void setfinancialInfo() {
        Map<String, BigDecimal> financialInfo = new HashMap<>();
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите номер банковского счета: ");
        BigDecimal accountID = BigDecimal.valueOf(Integer.parseInt(scan.nextLine()));
        System.out.println("Введите баланс клиента: ");
        BigDecimal accountBalance = BigDecimal.valueOf(scan.nextFloat());
        System.out.println("Введите прибыль клиента: ");
        BigDecimal profit = BigDecimal.valueOf(scan.nextFloat());
        BigDecimal taxAmount;
        BigDecimal ebitda;
        if (profit.compareTo(BigDecimal.valueOf(0.0)) > 0){
            taxAmount = profit.multiply(BigDecimal.valueOf(0.13));
            ebitda = profit.subtract(taxAmount);
        } else {
            ebitda = profit;
            taxAmount = BigDecimal.valueOf(0);
        }
        BigDecimal adjustedAccountBalance = accountBalance.add(ebitda);

        financialInfo.put("accountID", accountID);
        financialInfo.put("accountBalance", accountBalance);
        financialInfo.put("profit", profit);
        financialInfo.put("taxAmount", taxAmount);
        financialInfo.put("ebitda", ebitda);
        financialInfo.put("adjustedAccountBalance", adjustedAccountBalance);

        this.financialInfo = financialInfo;
    }


    @Override
    public String toString(){
        return String.format(
                "ФИО: " + passportCredentials.get("LastName") + " " + passportCredentials.get("FirstName") + "\n"
                + "Дата рождения: " + passportCredentials.get("DOB")  + "\n"
                + "Адрес: " + addressInfo.get("Address")  + "\n"
                + "email: " + addressInfo.get("email")  + "\n"
                + "Телефон: " + addressInfo.get("phN")  + "\n"
                + "\n"
                + "Номер банковского счета: " + financialInfo.get("accountID")  + "\n"
                + "Исходный баланс: " + financialInfo.get("accountBalance")  + "\n"
                + "Прибыль по итогам года: " + financialInfo.get("profit")  + "\n"
                + "Сумма налога: " + financialInfo.get("taxAmount")  + "\n"
                + "Чистая прибыль: " + financialInfo.get("ebitda")  + "\n"
                + "Итоговое состояние счета: " + financialInfo.get("adjustedAccountBalance")  + "\n"
        );
    }
}
