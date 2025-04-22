package com.arqui.soft.freemarket.seller.domain.model;

import com.arqui.soft.freemarket.commons.Email;
import com.arqui.soft.freemarket.commons.exceptions.InvalidEmailException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
class SellerTest {

    @Test
    void whenCreateSellerWithInvalidEmailRaiseInvalidEmailException() {

        var exception = assertThrows(InvalidEmailException.class, ()-> Seller.builder()
                .email(new Email("test"))
                .build()
        );

        assertEquals("Email inválido", exception.getMessage());
    }

    @Test
    void whenCreateSellerWithValidEmailThenCreates() throws InvalidEmailException {
        var seller = Seller.builder()
                .email(new Email("test@gmail.com"))
                .build();

        assertEquals("test@gmail.com", seller.getEmail().getValue());
    }
}
