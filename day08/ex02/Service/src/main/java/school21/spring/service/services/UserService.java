package school21.spring.service.services;


import org.springframework.stereotype.Component;

@Component
public interface UserService {
    String signUp(String email);
}
