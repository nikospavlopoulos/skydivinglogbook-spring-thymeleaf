package com.nikospavlopoulos.skydivinglogbook.core.exceptions;

/**
 * A custom exception class used for handling generic entity-related exceptions.
 * This class extends {@link Exception}, allowing it to be used as a checked exception
 * in the application to indicate and handle specific error conditions related to entities.
 */

public class EntityGenericException extends Exception {

    private final String code;

    /**
     * Constructs a new EntityGenericException with a specified error code and detailed message.
     * @param code    a unique identifier for the type of error (e.g., "404", "500", or custom codes).
     * @param message a human-readable message explaining the cause of the exception.
     */
    public EntityGenericException(String code, String message) {
        super(message);
        this.code = code;
    }

//    /**
//     * Retrieves the error code associated with this exception.
//     * @return the custom error code as a String.
//     */
//    public String getCode() {
//        return code;
//    }

}