package com.arqui.soft.freemarket.user.application.usecase;

import com.arqui.soft.freemarket.user.domain.ports.out.DeleteUserAdapter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class DeleteUserUseCaseTest {


    @Mock
    private DeleteUserAdapter deleteUserAdapter;

    private DeleteUserUseCase useCase;

    @BeforeEach
    void setUp(){
        useCase = new DeleteUserUseCase(deleteUserAdapter);
    }


    @Test
    void whenDeleteUserVerifyAdapterIsCalled() {

        useCase.delete(UUID.randomUUID().toString());

        verify(deleteUserAdapter).delete(anyString());
    }

}
