package ru.vsu.cs.smart.common.exception;

public class ResourceNotFoundException extends Exception {
    public ResourceNotFoundException() {

    }

    public ResourceNotFoundException(String msg) {
        super(msg);
    }
}
