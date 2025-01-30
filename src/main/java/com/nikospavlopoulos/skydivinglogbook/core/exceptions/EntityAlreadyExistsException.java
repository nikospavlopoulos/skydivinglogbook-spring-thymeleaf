package com.nikospavlopoulos.skydivinglogbook.core.exceptions;

/**
 * A custom exception to indicate that an entity already exists.
 * This exception is thrown when an attempt is made to create an entity that
 * already exists in the system (e.g., duplicate entry).
 */

public class EntityAlreadyExistsException extends EntityGenericException {

    // Default code used to specify the nature of this exception.
    private static final String DEFAULT_CODE = " Already Exists ";

    /**
     * Constructs a new EntityAlreadyExistsException with a specific error code and message.
     * The code provided by the caller is concatenated with the default "AlreadyExists" suffix.
     *
     * @param code    A unique identifier for the error type.
     * @param message A human-readable explanation of the error.
     */
    public EntityAlreadyExistsException(String code, String message) {
        super(code + DEFAULT_CODE, message);
    }
}
