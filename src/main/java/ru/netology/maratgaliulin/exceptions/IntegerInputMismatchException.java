package ru.netology.maratgaliulin.exceptions;

import java.util.InputMismatchException;

public class IntegerInputMismatchException extends InputMismatchException {
    public IntegerInputMismatchException(String text){
        super("В данном поле надо указать число, но было указано: " + text);
    }
}
