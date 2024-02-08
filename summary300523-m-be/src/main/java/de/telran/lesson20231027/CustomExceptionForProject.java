package de.telran.lesson20231027;

public class CustomExceptionForProject extends Exception {

    public CustomExceptionForProject() {
    }

    public CustomExceptionForProject(String message) {
        super(message);
    }
}
