package com.chubanova.exception;

public class CommandException extends RuntimeException {
    public CommandException(String message) {
        System.out.println(message);
    }
}
