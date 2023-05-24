package models;

public class invalidEmailException extends Exception {
    public invalidEmailException(String errorMessage) {
        super(errorMessage);
    }
}