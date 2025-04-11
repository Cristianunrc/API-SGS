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
  
  @GetMapping("/audit")
  public ResponseEntity<Object> audit() {
    auditory = service.getAuditInfo();
    
    if (auditory != null) {
      return ResponseEntity.ok(auditory); //http 200
    }
    
    response = new HashMap<>();
    response.put("error", "error al obtener los datos.");
    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response); //http 500
  }
  
}
