package edu.school21.chat.models;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Message {
    private int id;
    private User author;
    private Chatroom room;
    private String text;
    private LocalDateTime date;

    public Message(int id, User author, Chatroom room, String text, LocalDateTime date) {
        this.id = id;
        this.author = author;
        this.room = room;
        this.text = text;
        this.date = date;
    }


    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object e) {
        return super.equals(e);
    }

    @Override
    public String toString() {
        return "Message : {" + "\n" +
                "\tid=" + id + "\n" +
                "\tauthor=" + author + "\n" +
                "\troom=" + room + "\n" +
                "\ttext='" + text + '\'' + "\n" +
                "\tdate=" + date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")) + '\n' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public Chatroom getRoom() {
        return room;
    }

    public void setRoom(Chatroom room) {
        this.room = room;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}
