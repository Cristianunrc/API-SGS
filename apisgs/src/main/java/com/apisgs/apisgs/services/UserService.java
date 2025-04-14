package com.apisgs.apisgs.services;

import com.apisgs.apisgs.repositories.UserRepository;
import com.apisgs.apisgs.exceptions.LoginException;

import org.springframework.stereotype.Service;
import org.springframework.dao.DataAccessException;

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
    } catch (DataAccessException e) { 
      throw new LoginException("error en la ejecución de la query", e.getCause());
    }
  }
}
