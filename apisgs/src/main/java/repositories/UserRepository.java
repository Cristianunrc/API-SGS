
package repositories;

import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.JdbcTemplate;
import java.util.Map;

/**
 *
 * @author Usuario
 */
@Repository
public class UserRepository {
  
  private final JdbcTemplate jdbcTemplate;
  
  public UserRepository(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }
  
  public Map<String, Object> findUser(String user, String password) {
    String sql = " select * from usuarios where nombre = ? and clave = ? ";
    return jdbcTemplate.queryForMap(sql, user, password);
  }
  
}
