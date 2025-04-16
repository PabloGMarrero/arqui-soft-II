package com.arqui.soft.freemarket.user.architecture.adapters.in;

import com.arqui.soft.freemarket.commons.exceptions.EmailAlreadyExistException;
import com.arqui.soft.freemarket.commons.exceptions.InvalidEmailException;
import com.arqui.soft.freemarket.user.architecture.adapters.in.request.CreateUserRequest;
import com.arqui.soft.freemarket.user.domain.model.User;
import com.arqui.soft.freemarket.user.domain.ports.in.CreateUserPort;
import com.arqui.soft.freemarket.user.domain.ports.in.DeleteUserPort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/users")
public class UserController {

    private final CreateUserPort createUserPort;
    private final DeleteUserPort deleteUserPort;

    public UserController(CreateUserPort createUserPort, DeleteUserPort deleteUserPort) {
        this.createUserPort = createUserPort;
        this.deleteUserPort = deleteUserPort;
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody CreateUserRequest user) throws InvalidEmailException, EmailAlreadyExistException {
        return ResponseEntity.ok(createUserPort.create(user));
    }

    @DeleteMapping(path = "/{userId}")
    public ResponseEntity<String> deleteUser(@PathVariable String userId){
        deleteUserPort.delete(userId);
        return ResponseEntity.accepted().build();
    }
}
