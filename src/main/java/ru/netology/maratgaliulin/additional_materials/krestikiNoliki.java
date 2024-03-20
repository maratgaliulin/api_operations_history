package ru.netology.maratgaliulin.additional_materials;

import java.util.Scanner;

public class krestikiNoliki {

    public static final int SIZE = 3;
    public static final char EMPTY = '-';
    public static final char CROSS = 'X';
    public static final char ZERO = '0';
    public static void main(String[] args) {
        char[][] field = new char[SIZE][SIZE];

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                field[i][j] = EMPTY;
            }
        }

        Scanner sc = new Scanner(System.in);
        boolean isCrossTurn = true;

        while (true) {
            System.out.println("Ходят " + (isCrossTurn ? "крестики" : "нолики") + ". Введи координаты: ");
            printField(field);
            String input = sc.nextLine();
            String[] parts = input.split(" ");
            int x = Integer.parseInt(parts[0]) - 1;
            int y = Integer.parseInt(parts[1]) - 1;

            if (field[x][y] != EMPTY) {
                continue;
            }

            field[x][y] = isCrossTurn ? CROSS : ZERO;

            if (isWin(field, isCrossTurn ? CROSS : ZERO)) {
                System.out.println("Выиграли " + (isCrossTurn ? "крестики" : "нолики") + "!");
                printField(field);
                break;
            } else {
              if(isCrossTurn){
                  isCrossTurn = false;
              }else {
                  isCrossTurn = true;
              }
            }
        }
    }

    public static void printField(char[][] chField){
        for (char[] rw : chField){
            for (char cell : rw){
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }

//    FOR 3x3 SIZE ONLY!!!
    public static boolean isWin(char[][] field, char player){
        for (char[] row : field){
            if(row[0] == player && row[1] == player && row[2] == player){
                return true;
            }
        }
        for (int i = 0; i < SIZE; i ++){
            if (field[0][i] == player && field[1][i] == player && field[2][i] == player){
                return true;
            }
        }
        if(field[0][0] == player && field[1][1] == player && field[2][2] == player
        || field[0][2] == player && field[1][1] == player && field[2][0] == player
        ){
            return true;
        }
        return false;
    }
}
