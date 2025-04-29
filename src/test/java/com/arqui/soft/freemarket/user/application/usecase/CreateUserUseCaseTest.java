package com.arqui.soft.freemarket.user.application.usecase;

import com.arqui.soft.freemarket.commons.exceptions.EmailAlreadyExistException;
import com.arqui.soft.freemarket.commons.exceptions.InvalidEmailException;
import com.arqui.soft.freemarket.user.domain.ports.out.CreateUserAdapter;
import com.arqui.soft.freemarket.user.domain.ports.out.GetUserAdapter;
import com.arqui.soft.freemarket.user.infrastructure.adapters.in.request.CreateUserRequest;
import com.arqui.soft.freemarket.user.infrastructure.adapters.in.request.CreateUserRequestFixture;
import com.arqui.soft.freemarket.user.infrastructure.adapters.out.UserEntity;
import com.arqui.soft.freemarket.user.infrastructure.adapters.out.UserEntityFixture;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CreateUserUseCaseTest {

    @Mock
    private CreateUserAdapter createUserAdapter;

    @Mock
    private GetUserAdapter getUserAdapter;

    private CreateUserUseCase useCase;
    private CreateUserRequest request;

    @BeforeEach
    void setUp(){
        useCase = new CreateUserUseCase(createUserAdapter, getUserAdapter);
    }

    @Test
    void whenCreateUserHasInvalidEmailThenRaiseInvalidEmailException(){
        request = CreateUserRequestFixture.withWrongEmail();
        var exception = assertThrows(InvalidEmailException.class, ()-> useCase.create(request));

        assertNotNull(exception);
        assertEquals("Email inválido", exception.getMessage());
    }

    @Test
    void whenCreateUserAndEmailAlReadyExistThenRaiseEmailAlreadyExistException() throws InvalidEmailException {
        request = CreateUserRequestFixture.withDefaults();

        when(getUserAdapter.getById(anyString()))
                .thenReturn(Optional.of(UserEntityFixture.withDefaults()));

        var exception = assertThrows(EmailAlreadyExistException.class, ()-> useCase.create(request));

        assertNotNull(exception);
        assertEquals("Email ya existente.", exception.getMessage());
        verify(getUserAdapter).getById(anyString());
    }

    @Test
    void whenCreateProductAndUserExistThenProductIsCreated() throws InvalidEmailException, EmailAlreadyExistException {
        request = CreateUserRequestFixture.withDefaults();

        when(getUserAdapter.getById(anyString()))
                .thenReturn(Optional.empty());

        when(createUserAdapter.create(any(UserEntity.class)))
                .thenReturn(UserEntity.builder()
                        .id(UUID.randomUUID().toString())
                        .build());

        var seller = useCase.create(request);

        assertNotNull(seller);
        assertNotNull(seller.getId());
        verify(getUserAdapter).getById(anyString());
        verify(createUserAdapter).create(any(UserEntity.class));
    }

}
