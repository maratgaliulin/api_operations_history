package ru.netology.maratgaliulin.exceptions;

public class NameInputMismatchException extends RuntimeException {
    public NameInputMismatchException(String text1, String text2){
        super("В данном поле надо указать " + text1 + " но было указано: " + text2);
    }
}
