package models;

public class invalidNameException extends Exception {
    public invalidNameException(String errorMessage) {
        super(errorMessage);
    }
}