package edu.school21.services;

import edu.school21.models.User;
import edu.school21.repositories.UsersRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class UserServiceImplTest {

    UsersRepository repository;

    @BeforeEach
    void init() {
        repository = Mockito.mock(UsersRepository.class);
    }


    @Test
    void correctLoginAndPassword() {
        Mockito.when(repository.findByLogin("rosfryd")).thenReturn(new User(1L, "rosfryd", "123", false));
        UserServiceImpl userService = new UserServiceImpl(repository);
        Assertions.assertTrue(userService.authenticate("rosfryd", "123"));
        Mockito.verify(repository).update(Mockito.any());
    }

    @Test
    void incorrectLogin() {
        Mockito.when(repository.findByLogin("rosf")).thenReturn(null);
        UserServiceImpl service = new UserServiceImpl(repository);
        Assertions.assertFalse(service.authenticate("rosf", "123"));
        Mockito.verify(repository, Mockito.never()).update(Mockito.any());
    }

    @Test
    void incorrectPassword() {
        Mockito.when(repository.findByLogin("rosfryd")).thenReturn(new User(1L, "rosfryd", "123", false));
        UserServiceImpl service = new UserServiceImpl(repository);
        Assertions.assertFalse(service.authenticate("rosfryd", "321"));

    }


}