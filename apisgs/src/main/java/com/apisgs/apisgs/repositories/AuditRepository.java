package com.apisgs.apisgs.repositories;

import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

@Repository
public class AuditRepository {
  
  private final JdbcTemplate jdbc;
  
  public AuditRepository(JdbcTemplate jdbc) {
    this.jdbc = jdbc;
  }
  
  public List<Map<String, Object>> getAudit() {
    String sql = " select u.nombre as u_nombre, gu.nombre as gu_nombre, a.operacion, a.fecha " +
                 " from auditoria a inner join grupo_usuarios gu " +
                 " on a.id_usuario = gu.id_usuario " +
                 " inner join usuarios u on u.id_usuario = gu.id_usuario ";
    return jdbc.queryForList(sql);
  }
  
}
