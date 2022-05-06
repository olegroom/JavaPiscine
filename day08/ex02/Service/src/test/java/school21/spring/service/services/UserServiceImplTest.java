package school21.spring.service.services;


import org.junit.jupiter.api.*;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import school21.spring.service.config.TestApplicationConfig;


class UserServiceImplTest {


    static AnnotationConfigApplicationContext context;

    @BeforeAll
    static void initContext() {
        context = new AnnotationConfigApplicationContext(TestApplicationConfig.class);
    }


    @Test
    void signUp() {
        UserService bean = context.getBean(UserService.class);

        String s = bean.signUp("newEmail@email.com");
        Assertions.assertNotEquals(s, "");
    }


    @AfterAll
    static void closeContext() {
        context.close();
    }
}