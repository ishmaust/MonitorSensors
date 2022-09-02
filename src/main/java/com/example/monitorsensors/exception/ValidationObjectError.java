package com.example.monitorsensors.exception;

public class ValidationObjectError {

  private String objectName;
  private String message;

  public ValidationObjectError(String objectName, String message) {
    this.objectName = objectName;
    this.message = message;
  }

  public String getObjectName() {
    return objectName;
  }

  public void setObjectName(String objectName) {
    this.objectName = objectName;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }
}
