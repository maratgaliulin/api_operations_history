package ru.netology.maratgaliulin.exceptions;

import java.util.InputMismatchException;

public class EmailInputMismatchException extends InputMismatchException {
    public EmailInputMismatchException(String text1, String text2){
        super(text1 + text2);
    }
}
