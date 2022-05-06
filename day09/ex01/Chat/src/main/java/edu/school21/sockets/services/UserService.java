package edu.school21.sockets.services;


import org.springframework.stereotype.Component;

@Component
public interface UserService {
    boolean signUp(String username, String password);
    boolean signIn(String username, String password);
    void saveMessage();
}
