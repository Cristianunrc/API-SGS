
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
  
  public UserController(UserService service) {
    this.service = service;
  }
  
  @PostMapping("/login")
  public ResponseEntity<Object> login(@RequestBody Map<String, String> credentials) {
    String username = credentials.get("username");
    String password = credentials.get("password");
    
    //validaciones de credenciales
    
    Map<String, Object> user = service.findUserByUsername(username, password);
    
    if (user != null) {
      return ResponseEntity.ok(user); //se retorna el objeto junto con el codigo de estado http 200
    }
    
    Map<String, Object> response = new HashMap<>();
    response.put("error", "Nombre de usuario o contraseña incorrectos.");
    return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
  }
  
}
