package school21.spring.service.application;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import school21.spring.service.config.ApplicationConfig;
import school21.spring.service.repositories.UsersRepositoryJdbcImpl;
import school21.spring.service.repositories.UsersRepositoryJdbcTemplateImpl;
import school21.spring.service.services.UserService;
import school21.spring.service.services.UserServiceImpl;


public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);

        UserService userService = context.getBean("userService", UserService.class);

        String tempPassword = userService.signUp("newEmail@mail.ru");

        System.out.println(tempPassword);

        context.close();
    }
}
