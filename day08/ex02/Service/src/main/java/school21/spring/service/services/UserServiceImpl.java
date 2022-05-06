package school21.spring.service.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import school21.spring.service.models.User;
import school21.spring.service.repositories.UsersRepository;

@Component("userService")
public class UserServiceImpl implements UserService {

    UsersRepository repository;

    @Autowired
    public UserServiceImpl(@Qualifier("jdbcTemplate") UsersRepository repository) {
        this.repository = repository;
    }

    @Override
    public String signUp(String email) {
        String password = generatePassword();
        repository.save(new User(null, email), password);
        return password;
    }

    public String generatePassword() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 15; i++) {
            double v = Math.random() * 4453 % 128;
            if ((int)v >= 40 && (int)v <= 120) {
                builder.append((char)v);
            }
        }

        return builder.toString();
    }
}
