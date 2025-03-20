package com.arqui.soft.freemarket.user.architecture.adapters.in;

import com.arqui.soft.freemarket.user.architecture.adapters.in.request.CreateUserRequest;
import com.arqui.soft.freemarket.user.domain.ports.in.CreateUserPort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/users")
public class UserController {

    private final CreateUserPort createUserPort;

    public UserController(CreateUserPort createUserPort) {
        this.createUserPort = createUserPort;
    }

    @PostMapping
    public ResponseEntity<String> createUser(@RequestBody CreateUserRequest user){
        return ResponseEntity.ok(user.getName());
    }
}
