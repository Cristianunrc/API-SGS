package com.apisgs.apisgs.services;

import com.apisgs.apisgs.repositories.AuditRepository;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.List;

@Service
public class AuditService {
  
  private final AuditRepository auditRep;
  
  public AuditService(AuditRepository auditRep) {
    this.auditRep = auditRep;
  }
  
  public List<Map<String, Object>> getAuditInfo() {
    try {
      return auditRep.getAudit();
    } catch (Exception e) { //capturar error en la ejecucion de la query
      System.err.println(e.getMessage());
      return null;
    }
  }
  
}
