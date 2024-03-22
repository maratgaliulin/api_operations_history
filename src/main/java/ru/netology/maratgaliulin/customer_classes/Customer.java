package ru.netology.maratgaliulin.customer_classes;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Customer implements Serializable {
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNo;
    private LocalDate DOB;
    private int clientID;

    public int getClientID() {
        return clientID;
    }

    public void setClientID(int clientID) {
        this.clientID = clientID;
    }

    public Customer() {}

    public Customer(int clientID, String firstName, String lastName, String email, String phoneNo, String DOB) {
        var f = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        this.clientID = clientID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNo = phoneNo;
        this.DOB = LocalDate.parse(DOB, f);
    }

    public int getId(){
        return clientID;
    }
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public LocalDate getDOB() {
        return DOB;
    }

    public void setDOB(String DOB) {
        var f = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        this.DOB = LocalDate.parse(DOB, f);
    }

    public void print(){
        var f = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        System.out.println("Информация о клиенте:");
        System.out.println("ID клиента: " + this.clientID + ".\n" + "ФИО клиента: " + this.firstName + " " + this.lastName + ".\n" + "Дата рождения: " + this.DOB.format(f) + ".\n" + "Email: " + this.email + ".\n" + "Номер телефона: " + this.phoneNo + ".\n");
    }
}
