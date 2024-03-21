package ru.netology.maratgaliulin.exceptions;

public class NameInputMismatchException extends RuntimeException {
    public NameInputMismatchException(String text1, String text2){
        super(text1 + text2);
    }
}
