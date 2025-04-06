/**
 *   EXPLANATION OF THIS FILE and ApiError.java.
 *   https://docs.google.com/document/d/1dtdmFYTZ5Hab89zDbGTk9OqhHjOS4xp3VFvVWkRPv9s/edit?usp=sharing
 */
package com.samettok.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.*;

/**
 * Global Exception Handler for the Spring Boot application.
 * Uses @ControllerAdvice to intercept exceptions thrown by any @Controller or @RestController.
 * Provides centralized exception handling logic.
 */
@ControllerAdvice // Marks this class as a global handler for exceptions, model attributes, and data binding.
public class GlobalExceptionHandler {

    /**
     * Helper method to add a new error message string to a list of strings.
     * If the list exists, the value is added to it.
     * This method modifies the list passed as an argument.
     *
     * @param list     The list of strings to add the new value to.
     * @param newValue The new string value (error message) to add.
     * @return The modified list containing the new value.
     */
    private List<String> addMapValue(List<String> list, String newValue) {
        // Add the new error message to the provided list.
        list.add(newValue);
        // Return the same list reference (now modified).
        return list;
    }

    /**
     * Handles MethodArgumentNotValidException, which occurs when request body validation fails.
     * This typically happens when an object annotated with @Valid in a controller method parameter
     * fails validation constraints (e.g., @NotNull, @Size).
     *
     * @param exception The caught MethodArgumentNotValidException containing validation error details.
     * @return A ResponseEntity with HTTP status 400 (Bad Request) and a body containing
     * an ApiError object detailing the validation failures (field -> list of error messages).
     */
    @ExceptionHandler(value = MethodArgumentNotValidException.class) // Specifies this method handles MethodArgumentNotValidException
    public ResponseEntity<ApiError<Map<String, List<String>>>> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception) {
        // Initialize a map to store validation errors, mapping field names to a list of error messages.
        Map<String, List<String>> errorMap = new HashMap<>();

        // Iterate over all validation errors obtained from the exception's BindingResult.
        for (ObjectError objError : exception.getBindingResult().getAllErrors()) {
            // Cast the ObjectError to FieldError to get the specific field name.
            String fieldName = ((FieldError) objError).getField();
            // Get the default error message associated with the validation failure.
            String errorMessage = objError.getDefaultMessage();

            // Check if errors for this field name are already present in the map.
            if (errorMap.containsKey(fieldName)) {
                // If yes, add the new error message to the existing list for that field.
                errorMap.put(fieldName, addMapValue(errorMap.get(fieldName), errorMessage));
            } else {
                // If no, create a new list, add the error message, and put the field name and new list into the map.
                errorMap.put(fieldName, addMapValue(new ArrayList<>(), errorMessage));
            }
        }

        // Create the standardized ApiError response body using the helper method.
        ApiError<Map<String, List<String>>> apiError = createApiError(errorMap);

        // Return an HTTP 400 Bad Request response with the ApiError object as the body.
        return ResponseEntity.badRequest().body(apiError);
    }

    /**
     * Private helper method to create and populate an ApiError object.
     * This standardizes the creation of error responses.
     *
     * @param errors The error details payload (e.g., a Map, String, List). The specific type is determined by T.
     * @param <T>    The generic type parameter representing the type of the 'errors' payload.
     * @return A fully populated ApiError object containing the errors, a unique ID, and a timestamp.
     */
    private <T> ApiError<T> createApiError(T errors) {
        // Instantiate a new ApiError object.
        ApiError<T> apiError = new ApiError<>();

        // Set the specific error details.
        apiError.setErrors(errors);
        // Generate and set a unique identifier for this error instance.
        apiError.setId(UUID.randomUUID().toString());
        // Set the timestamp to the current date and time.
        apiError.setTimestamp(new Date());

        // Return the created ApiError object.
        return apiError;
    }

}

