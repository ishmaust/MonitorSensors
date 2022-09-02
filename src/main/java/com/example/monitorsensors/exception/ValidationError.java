package com.example.monitorsensors.exception;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.ArrayList;
import java.util.List;

public class ValidationError {
  @JsonInclude(JsonInclude.Include.NON_EMPTY)
  private List<ValidationObjectError> errors = new ArrayList<>();

  private final String errorMessage;

  public ValidationError(String errorMessage) {
    this.errorMessage = errorMessage;
  }

  public void addValidationError(String objectName, String error) {
    errors.add(new ValidationObjectError(objectName, error));
  }

  public List<ValidationObjectError> getErrors() {
    return errors;
  }

  public String getErrorMessage() {
    return errorMessage;
  }
}
