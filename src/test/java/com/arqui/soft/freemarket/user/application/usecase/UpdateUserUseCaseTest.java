package com.arqui.soft.freemarket.user.application.usecase;

import com.arqui.soft.freemarket.commons.exceptions.InvalidEmailException;
import com.arqui.soft.freemarket.commons.exceptions.UserDoesNotExistException;
import com.arqui.soft.freemarket.user.domain.ports.out.GetUserAdapter;
import com.arqui.soft.freemarket.user.domain.ports.out.UpdateUserAdapter;
import com.arqui.soft.freemarket.user.infrastructure.adapters.in.request.UpdateUserRequest;
import com.arqui.soft.freemarket.user.infrastructure.adapters.in.request.UpdateUserRequestFixture;
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
class UpdateUserUseCaseTest {

    @Mock
    private UpdateUserAdapter updateUserAdapter;

    @Mock
    private GetUserAdapter getUserAdapter;

    private UpdateUserUseCase useCase;
    private UpdateUserRequest request;
    private String userId;

    @BeforeEach
    void setUp(){
        useCase = new UpdateUserUseCase(updateUserAdapter, getUserAdapter);
        userId = UUID.randomUUID().toString();
    }

    @Test
    void whenUpdateUserAndUserDoestNotExistThrowUserDoesNotExistException(){
        request = UpdateUserRequestFixture.withDefaults();

        var exception = assertThrows(UserDoesNotExistException.class, ()->
                useCase.update(userId, request));

        assertNotNull(exception);
        assertEquals(String.format("El usuario con id %s no existe.", userId), exception.getMessage());
    }

    @Test
    void whenUpdateUserWithStockAndPriceAndUserExistThenUserIsCreated() throws UserDoesNotExistException, InvalidEmailException {
        request = UpdateUserRequestFixture.withDefaults();

        when(getUserAdapter.getById(anyString()))
                .thenReturn(Optional.of(UserEntityFixture.withDefaults()));

        when(updateUserAdapter.update(any(UserEntity.class)))
                .thenReturn(UserEntityFixture.withDefaults());

        var user = useCase.update(UserEntityFixture.ID, request);

        assertNotNull(user);
        assertNotNull(user.getId());
        verify(getUserAdapter).getById(anyString());
        verify(updateUserAdapter).update(any(UserEntity.class));
    }

    @Test
    void whenUpdateUserWithValuesAndUserExistThenUserIsCreated() throws UserDoesNotExistException, InvalidEmailException {
        request = UpdateUserRequestFixture.withoutName();

        when(getUserAdapter.getById(anyString()))
                .thenReturn(Optional.of(UserEntityFixture.withDefaults()));

        when(updateUserAdapter.update(any(UserEntity.class)))
                .thenReturn(UserEntityFixture.withDefaults());

        var user = useCase.update(UserEntityFixture.ID, request);

        assertNotNull(user);
        assertNotNull(user.getId());
        verify(getUserAdapter).getById(anyString());
        verify(updateUserAdapter).update(any(UserEntity.class));
    }

}
