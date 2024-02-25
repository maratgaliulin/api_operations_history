package ru.netology.maratgaliulin;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        fiveTransactionsInput fv = new fiveTransactionsInput();
        Scanner scanner = new Scanner(System.in);

        while (true){
            fv.setPassportCredentials();
            fv.setAddressInfo();
            fv.setfinancialInfo();

            System.out.println(fv);
            System.out.println("Желаете продолжить? ");
            String shallContinue = scanner.nextLine();

            if(shallContinue.equals("no")){
                break;
            }
        }

    }
}