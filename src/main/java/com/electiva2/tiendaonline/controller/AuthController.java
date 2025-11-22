
package com.electiva2.tiendaonline.controller;

import com.electiva2.tiendaonline.dto.JwtResponse;
import com.electiva2.tiendaonline.dto.LoginRequest;
import com.electiva2.tiendaonline.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public ResponseEntity<JwtResponse> login(@RequestBody LoginRequest request) {
        return ResponseEntity.ok(authService.login(request));
    }
}
