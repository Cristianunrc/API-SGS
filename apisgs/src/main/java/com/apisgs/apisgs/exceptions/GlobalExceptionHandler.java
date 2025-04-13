package com.apisgs.apisgs.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {
  
  /**
   * Handle global exception for auditory.
   * @param auditExcep an instance AuditException
   * @return a response with a message and http status code 500
   */
  @ExceptionHandler(AuditException.class)
  public ResponseEntity<Object> handleAuditException(AuditException auditExcep) {
    Map<String, Object> response = new HashMap<>();
    response.put("error", auditExcep.getMessage());
    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
  }

}
