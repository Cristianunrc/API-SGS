
package com.apisgs.apisgs.controller;

import com.apisgs.apisgs.services.UserService;

import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/users")
public class UserController {
  
  private final UserService service;
  
  private Map<String, Object> response;
  
  private Map<String, Object> user;
  
  public UserController(UserService service) {
    this.service = service;
  }
  
  @PostMapping("/login")
  public ResponseEntity<Object> login(@RequestBody Map<String, String> credentials) {
    String username = credentials.get("username");
    String password = credentials.get("password");
    
    response = new HashMap<>();
    
    if (username.isEmpty() || password.isEmpty()) {
      response.put("error", "Nombre de usuario o contraseña no pueden estar vacios.");
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response); //http 400
    }
    
    user = service.findUserByUsername(username, password);
    
    if (user != null) {
      return ResponseEntity.ok(user); //http 200
    }
    
    response.put("error", "Nombre de usuario o contraseña incorrectos.");
    return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response); //HTTP 401
  }
  
}
