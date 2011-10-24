package ru.sgu.pp.java.framework.exception;

/**
 * @author Elena Fedorova
 */
public class CommandException extends Exception {
    private String message;

    public CommandException(String message, String message1) {
        super(message);
        message = message1;
    }

    public String getMessage() {
        return message;
    }

}
