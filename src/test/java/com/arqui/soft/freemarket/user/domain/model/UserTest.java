package com.arqui.soft.freemarket.user.domain.model;

import com.arqui.soft.freemarket.commons.Email;
import com.arqui.soft.freemarket.commons.exceptions.InvalidEmailException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
class UserTest {

    @Test
    void whenCreateUserWithInvalidEmailRaiseInvalidEmailException() {

        var exception = assertThrows(InvalidEmailException.class, ()-> User.builder()
                .email(new Email("test"))
                .build()
        );

        assertEquals("Email inválido", exception.getMessage());
    }

    @Test
    void whenCreateUserWithoutAtRaiseInvalidEmailException() {

        var exception = assertThrows(InvalidEmailException.class, ()-> User.builder()
                .email(new Email("test.com"))
                .build()
        );

        assertEquals("Email inválido", exception.getMessage());
    }

    @Test
    void whenCreateUserWithValidEmailThenCreates() throws InvalidEmailException {
        var seller = User.builder()
                .email(new Email("test@gmail.com"))
                .build();

        assertEquals("test@gmail.com", seller.getEmail().getValue());
    }
}
