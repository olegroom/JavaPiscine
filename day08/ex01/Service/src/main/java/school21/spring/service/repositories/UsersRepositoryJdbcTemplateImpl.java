package school21.spring.service.repositories;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import school21.spring.service.models.User;
import java.util.List;
import java.util.Optional;

public class UsersRepositoryJdbcTemplateImpl implements UsersRepository {
    public JdbcTemplate jdbcTemplate;

    public UsersRepositoryJdbcTemplateImpl(DriverManagerDataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public User findById(Long id) {
        return jdbcTemplate.query("SELECT * FROM roomdb.users WHERE id = ?", (rs, rowNum) -> new User(rs.getLong(1), rs.getString(2)) , new Object[]{id})
                .stream().findAny().orElse(null);
    }

    @Override
    public List<User> findAll() {
        return jdbcTemplate.query("select * from roomdb.users", (rs, rowNum) -> new User(rs.getLong(1), rs.getString(2)));
    }

    @Override
    public void save(User entity) {
        jdbcTemplate.update("insert into roomdb.users (email) values (?)", entity.getEmail());
    }

    @Override
    public void update(User entity) {
        jdbcTemplate.update("UPDATE roomdb.users SET email = ? WHERE id=?", entity.getEmail(), entity.getId());
    }

    @Override
    public void delete(Long id) {
        jdbcTemplate.update("DELETE FROM roomdb.users WHERE id=?", id);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        User user = jdbcTemplate.query("SELECT * FROM roomdb.users WHERE email = ?", (rs, rowNum) -> new User(rs.getLong(1), rs.getString(2)),  new Object[]{email})
                .stream().findAny().orElse(null);
        return Optional.of(user);
    }
}
