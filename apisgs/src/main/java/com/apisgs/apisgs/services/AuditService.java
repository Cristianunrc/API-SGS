package com.apisgs.apisgs.services;

import com.apisgs.apisgs.exceptions.AuditException;

import com.apisgs.apisgs.repositories.AuditRepository;
import org.springframework.stereotype.Service;
import org.springframework.dao.DataAccessException;

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
    } catch (DataAccessException e) {
      throw new AuditException("error en la ejecución de la query", e.getCause());
    }
  }
  
}
