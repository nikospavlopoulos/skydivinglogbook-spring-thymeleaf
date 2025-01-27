package com.nikospavlopoulos.skydivinglogbook.core.exceptions;

/**
 * A custom exception to indicate unauthorized access or actions.
 * This exception is thrown when a user or process attempts to access a resource
 * or perform an action without the necessary permissions or authorization.
 */

public class EntityNotAuthorizedException extends EntityGenericException {

    // Default code used to specify the nature of this exception.
    private static final String DEFAULT_CODE = " Not Authorized ";

    /**
     * Constructs a new EntityNotAuthorizedException with a specific error code and message.
     * The code provided by the caller is concatenated with the default "NotAuthorized" suffix.
     * @param code    A unique identifier for the error type.
     * @param message A human-readable explanation of the error.
     */
    public EntityNotAuthorizedException(String code, String message) {
        super(code + DEFAULT_CODE, message);
    }
}
