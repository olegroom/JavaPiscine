package edu.school21.chat.models;

import java.util.List;

public class User {
    int id;
    String login;
    String password;
    List<Chatroom> createdChatrooms;
    List<Chatroom> joinedChatrooms;

    public User(int id, String login, String password, List<Chatroom> createdChatrooms, List<Chatroom> joinedChatrooms) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.createdChatrooms = createdChatrooms;
        this.joinedChatrooms = joinedChatrooms;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", createdChatrooms=" + createdChatrooms +
                ", joinedChatrooms=" + joinedChatrooms +
                '}';
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Chatroom> getCreatedChatrooms() {
        return createdChatrooms;
    }

    public void setCreatedChatrooms(List<Chatroom> createdChatrooms) {
        this.createdChatrooms = createdChatrooms;
    }

    public List<Chatroom> getJoinedChatrooms() {
        return joinedChatrooms;
    }

    public void setJoinedChatrooms(List<Chatroom> joinedChatrooms) {
        this.joinedChatrooms = joinedChatrooms;
    }
}



