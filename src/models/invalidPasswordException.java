package models;

public class invalidPasswordException extends Exception {
    public invalidPasswordException(String errorMessage) {
        super(errorMessage);
    }
}