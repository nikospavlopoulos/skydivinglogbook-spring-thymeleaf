package com.nikospavlopoulos.skydivinglogbook.core.exceptions;

/**
 * A custom exception to indicate invalid arguments passed to a method or operation.
 * This exception is thrown when the provided input arguments violate constraints
 * or do not meet expected requirements.
 */

public class EntityInvalidArgumentException extends EntityGenericException {

    // Default code used to specify the nature of this exception.
    private static final String DEFAULT_CODE = " Invalid Argument ";

    /**
     * Constructs a new EntityInvalidArgumentException with a specific error code and message.
     * The code provided by the caller is concatenated with the default "InvalidArgument" suffix.
     * @param code    A unique identifier for the error type.
     * @param message A human-readable explanation of the error.
     */
    public EntityInvalidArgumentException(String code, String message) {
        super(code + DEFAULT_CODE, message);
    }
}

