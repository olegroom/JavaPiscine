package edu.school21.services;

import edu.school21.exceptions.AlreadyAuthenticatedException;
import edu.school21.models.User;
import edu.school21.repositories.UsersRepository;

public class UserServiceImpl {

    private UsersRepository repository;

    public UserServiceImpl(UsersRepository repository) {
        this.repository = repository;
    }

    boolean authenticate(String login, String password) throws AlreadyAuthenticatedException {
        User byLogin = repository.findByLogin(login);
        if (byLogin == null)
            return false;

        if (byLogin.getAuthStatus())
            throw new AlreadyAuthenticatedException("Error");

        if (byLogin.getPassword().equals(password)) {
            byLogin.setAuthStatus(true);
            repository.update(byLogin);
            return true;
        }

        return false;
    }

}
