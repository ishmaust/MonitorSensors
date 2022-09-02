package com.example.monitorsensors.exception;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;

@Component
public class ValidationErrorBuilder {

  public ValidationError fromBindingErrors(Errors errors) {
    ValidationError error = new ValidationError("Validation failed. " + errors.getErrorCount() + " error(s)");
    for (ObjectError objectError : errors.getAllErrors()) {
      error.addValidationError(objectError.getObjectName(), objectError.getDefaultMessage());
    }
    return error;
  }
}
