package com.arqui.soft.freemarket.user.architecture.adapters.in;

import com.arqui.soft.freemarket.user.architecture.adapters.in.request.CreateUserRequest;
import com.arqui.soft.freemarket.user.architecture.adapters.in.request.UpdateUserRequest;
import com.arqui.soft.freemarket.user.domain.model.User;
import com.arqui.soft.freemarket.user.domain.ports.in.CreateUserPort;
import com.arqui.soft.freemarket.user.domain.ports.in.DeleteUserPort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/users")
public class UserController {

    private final CreateUserPort createUserPort;
    private final UpdateUserPort updateUserPort;
    private final DeleteUserPort deleteUserPort;

    public UserController(CreateUserPort createUserPort, UpdateUserPort updateUserPort, DeleteUserPort deleteUserPort) {
        this.createUserPort = createUserPort;
        this.updateUserPort = updateUserPort;
        this.deleteUserPort = deleteUserPort;
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody CreateUserRequest user){
        return ResponseEntity.ok(createUserPort.create(user));
    }

    @PatchMapping(path = "/{userId}")
    public ResponseEntity<User> updateUser(@PathVariable String userId, @RequestBody UpdateUserRequest user){
        return ResponseEntity.ok(updateUserPort.update(userId, user));
    }

    @DeleteMapping(path = "/{userId}")
    public ResponseEntity<String> deleteUser(@PathVariable Integer userId){
        deleteUserPort.delete(userId);
        return ResponseEntity.accepted().build();
    }
}
