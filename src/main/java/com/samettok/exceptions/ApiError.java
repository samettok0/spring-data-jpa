/**
 *  EXPLANATION OF THIS FILE and ApiError.java.
 *  https://docs.google.com/document/d/1dtdmFYTZ5Hab89zDbGTk9OqhHjOS4xp3VFvVWkRPv9s/edit?usp=sharing
 */
package com.samettok.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * Represents a standardized API error response structure.
 * This class is typically converted to JSON and sent back to the client upon an error.
 * Uses Lombok annotations (@Data, @NoArgsConstructor, @AllArgsConstructor) to reduce boilerplate code
 * (getters, setters, constructors, toString, equals, hashCode).
 *
 * @param <T> The type of the 'errors' field, allowing flexibility in the error details payload.
 */
@Data // Lombok: Generates getters, setters, toString(), equals(), hashCode()
@NoArgsConstructor // Lombok: Generates a no-argument constructor
@AllArgsConstructor // Lombok: Generates a constructor with arguments for all fields
public class ApiError<T> {

    /**
     * A unique identifier for this specific error instance (e.g., a UUID).
     * Useful for logging and tracking purposes.
     */
    private String id;

    /**
     * The timestamp indicating when the error occurred.
     */
    private Date timestamp;

    /**
     * The payload containing specific details about the error(s).
     * The type 'T' makes this flexible; it could be a String, List, Map, or custom object.
     * In the context of GlobalExceptionHandler, this is often a Map<String, List<String>>
     * mapping field names to validation error messages.
     */
    private T errors;
}
