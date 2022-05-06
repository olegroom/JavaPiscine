package edu.school21.chat.app;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import edu.school21.chat.models.Chatroom;
import edu.school21.chat.models.Message;
import edu.school21.chat.models.User;
import edu.school21.chat.repositories.MessagesRepository;
import edu.school21.chat.repositories.MessagesRepositoryJdbcImpl;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

public class Program {
    public static void main(String[] args) throws SQLException {


        HikariDataSource ds = new HikariDataSource();
        ds.setJdbcUrl("jdbc:postgresql://localhost:5432/postgres");
        ds.setUsername("rosfryd");
        ds.setPassword("");


        MessagesRepository repository = new MessagesRepositoryJdbcImpl(ds);


        User author = new User(1, "rosfryd", "123456", new ArrayList(), new ArrayList());
        Chatroom room = new Chatroom(1, "chat1", author, new ArrayList());

        Message msg = new Message(null, author, room, "new text", LocalDate.now());

        repository.save(msg);

        System.out.println(msg.getId());

    }
}
