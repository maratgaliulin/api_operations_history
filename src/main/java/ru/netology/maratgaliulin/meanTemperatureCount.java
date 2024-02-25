package ru.netology.maratgaliulin;

import java.util.Scanner;

public class meanTemperatureCount {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] temps = new int[30];
        boolean[] isFilled = new boolean[30];

        while(true){
            System.out.println("Введите число и температуру: ");
            String input = sc.nextLine();
            if (input.equals("end")){
                break;
            }

            String[] parts = input.split(" ");
            int day = Integer.parseInt(parts[0]);
            int t = Integer.parseInt(parts[1]);

            if(day == 30){
                break;
            }

            temps[day] = t;
            isFilled[day] = true;

            double sum = 0;
            for (int tt : temps){
                sum += tt;
            }
            int cnt = 0;
            for (boolean f : isFilled){
                if (f){
                    cnt ++;
                }
            }
            if(cnt == 0){
                System.out.println("Average temperature: " +sum );
            }else{
                System.out.println("Average temperature: " + sum / cnt );
            }
        }
    }
}
