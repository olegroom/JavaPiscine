package edu.school21.chat.repositories;

import edu.school21.chat.exceptions.NotSavedSubEntityException;
import edu.school21.chat.models.Chatroom;
import edu.school21.chat.models.Message;
import edu.school21.chat.models.User;

import javax.sql.DataSource;
import java.sql.*;
import java.time.LocalDate;
import java.util.Optional;

public class MessagesRepositoryJdbcImpl implements MessagesRepository {

    private final DataSource ds;
    public MessagesRepositoryJdbcImpl(DataSource ds) {
        this.ds = ds;
    }

    @Override
    public Optional<Message> findById(Long id) throws SQLException {
        Optional<Message> optionalMessage;

        try(Connection connection = ds.getConnection();
            Statement statement = connection.createStatement()) {

        String query = "SELECT * FROM chat.msgs WHERE id = " + id;
        ResultSet resultSet = statement.executeQuery(query);
        resultSet.next();

        User user = new User(1, "rosfryd", "sdf", null, null);
        Chatroom chatroom = new Chatroom(1, "chatroom", null, null);
        optionalMessage = Optional.of(new Message(resultSet.getInt(1), user, chatroom, resultSet.getString("message"), LocalDate.of(2014, 9, 19)));

        }
        return optionalMessage;
    }


    @Override
    public boolean save(Message message) throws NotSavedSubEntityException{
        String sqlQuery = "INSERT into chat.msgs (room_id, sender, message, time)" +
                " VALUES (" +
                message.getRoom().getId() + ", " +
                message.getAuthor().getId() + ", " +
                "'" + message.getText() + "'" + ", " +
                "'" + message.getDate() + "'" +
                ");";

        try(Connection connection = ds.getConnection();
            PreparedStatement statement = connection.prepareStatement(sqlQuery, Statement.RETURN_GENERATED_KEYS)) {

            statement.execute();

            ResultSet key = statement.getGeneratedKeys();
            key.next();
            message.setId(key.getInt(1));
        } catch (SQLException e) {
            throw new NotSavedSubEntityException();
        }
        return true;
    }
}
