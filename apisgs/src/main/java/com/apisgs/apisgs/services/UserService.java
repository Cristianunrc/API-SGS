
package com.apisgs.apisgs.services;

import com.apisgs.apisgs.repositories.UserRepository;

import org.springframework.stereotype.Service;
import java.util.Map;

@Service
public class UserService {
  
  private final UserRepository userRep;
  
  public UserService(UserRepository userRep) {
    this.userRep = userRep;
  }
  
  public Map<String, Object> findUserByUsername(String username, String password) {
    try {
      return userRep.findUser(username, password);
    } catch (Exception e) { 
      return null;
    }
  }
}
