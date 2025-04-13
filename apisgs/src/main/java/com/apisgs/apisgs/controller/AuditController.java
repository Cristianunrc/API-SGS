package com.apisgs.apisgs.controller;

import com.apisgs.apisgs.services.AuditService;

import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/info")
public class AuditController {

  private final AuditService service;
  
  private Map<String, Object> response;
  
  private List<Map<String, Object>> auditory;
  
  public AuditController(AuditService service) {
    this.service = service;
  }
  
  /**
   * GET endpoint that returns auditory information.
   * @return a response with information and http status code 200 if ok,
   * or 500 if an error was ocurred.
   */
  @GetMapping("/audit")
  public ResponseEntity<Object> audit() {
    auditory = service.getAuditInfo();   
    return ResponseEntity.ok(auditory);
  }
  
}
