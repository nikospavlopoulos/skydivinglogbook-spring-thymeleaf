package com.nikospavlopoulos.skydivinglogbook.core.exceptions;

/**
 * A custom exception to indicate that an entity was not found.
 * This exception is thrown when a requested resource or entity cannot be located
 * in the system (e.g., a missing record in the database).
 */

public class EntityNotFoundException extends EntityGenericException { /// Question: What does this do? Explain in detail

    // Default code used to specify the nature of this exception.
    private static final String DEFAULT_CODE = " Not Found ";

    /**
     * Constructs a new EntityNotFoundException with a specific error code and message.
     * The code provided by the caller is concatenated with the default "NotFound" suffix.
     *
     * @param code    A unique identifier for the error type.
     * @param message A human-readable explanation of the error.
     */
    public EntityNotFoundException(String code, String message) {
        super(code + DEFAULT_CODE, message);
    }
}
