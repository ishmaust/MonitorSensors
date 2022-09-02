package com.example.monitorsensors.exception;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionController {

  private final ValidationErrorBuilder validationErrorBuilder;

  @Autowired
  public ExceptionController(ValidationErrorBuilder validationErrorBuilder) {
    this.validationErrorBuilder = validationErrorBuilder;
  }

  @ExceptionHandler(MethodArgumentNotValidException .class)
  public ResponseEntity<ValidationError> methodArgumentNotValidExceptionHandler(
      MethodArgumentNotValidException ex) {
    return new ResponseEntity<>(validationErrorBuilder.fromBindingErrors(ex.getBindingResult()), HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(NotFoundEntityException.class)
  public ResponseEntity<String> notFoundEntityExceptionHandler(NotFoundEntityException ex) {
    return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(RangeException.class)
  public ResponseEntity<String> rangeExceptionHandler(RangeException ex) {
    return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
  }
}
