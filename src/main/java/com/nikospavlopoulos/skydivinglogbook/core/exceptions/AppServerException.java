package com.nikospavlopoulos.skydivinglogbook.core.exceptions;

/**
 * A custom exception class that extends {@link EntityGenericException} to represent
 * server-side errors specific to the application.
 * This class allows you to handle exceptions that occur due to server-related issues
 * (e.g., internal server errors, misconfigurations) while maintaining a consistent
 * exception hierarchy.
 */

public class AppServerException extends EntityGenericException {

    /**
     * Constructs a new AppServerException with a specified error code and detailed message.
     * @param code    a unique identifier for the server error (e.g., "500", "501").
     * @param message a human-readable message explaining the server error.
     */
    public AppServerException(String code, String message) {
        super(code, message);
    }
}
