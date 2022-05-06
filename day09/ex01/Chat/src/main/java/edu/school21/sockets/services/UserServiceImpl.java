package edu.school21.sockets.services;

import edu.school21.sockets.models.User;
import edu.school21.sockets.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component("userService")
public class UserServiceImpl implements UserService {

    UsersRepository repository;
    PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(@Qualifier("jdbcTemplate") UsersRepository repository, @Qualifier("getPasswordEncoder") PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
        this.repository = repository;
    }

    @Override
    public boolean signIn(String username, String password) {
        return false;
    }

    @Override
    public void saveMessage() {

    }

    @Override
    public boolean signUp(String username, String password) {
        String hashedPas = passwordEncoder.encode(password);
        repository.save(new User(null, username, hashedPas));
        return true;
    }

}
