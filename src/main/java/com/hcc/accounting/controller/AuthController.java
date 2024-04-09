package com.hcc.accounting.controller;

import com.hcc.accounting.manager.UserManager;
import com.hcc.accounting.model.vo.LoginRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class AuthController {
    private UserManager userManager;

    @Autowired
    public AuthController(UserManager userManager) {
        this.userManager = userManager;
    }

    @PostMapping(path = "v1/token")
    public ResponseEntity<String> login(@RequestBody LoginRequest loginRequest) {
        // request 校验

        String token = userManager.login(loginRequest);

        return ResponseEntity.ok(token);
    }
}
