package school21.spring.service.application;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import school21.spring.service.repositories.UsersRepositoryJdbcImpl;
import school21.spring.service.repositories.UsersRepositoryJdbcTemplateImpl;


public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");

        UsersRepositoryJdbcImpl usersRepositoryJdbc = context.getBean("usrRepJdbcImpl", UsersRepositoryJdbcImpl.class);
        System.out.println(usersRepositoryJdbc.findAll());

        System.out.println("--------------------------------------");

        UsersRepositoryJdbcTemplateImpl templateImpl = context.getBean(UsersRepositoryJdbcTemplateImpl.class);
        System.out.println(templateImpl.findAll());



    }
}
