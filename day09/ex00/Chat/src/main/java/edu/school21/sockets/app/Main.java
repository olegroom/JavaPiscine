package edu.school21.sockets.app;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;
import edu.school21.sockets.server.Server;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import edu.school21.sockets.config.SocketsApplicationConfig;
import edu.school21.sockets.services.UserService;

import java.io.IOException;


@Parameters(separators = "=")
public class Main {

    @Parameter(names = "--port")
    private Integer port;

    public static void main(String[] args) throws IOException, InterruptedException {

        Main main = new Main();
        JCommander.newBuilder().addObject(main).build().parse(args);
        main.run();
    }

    public void run() throws IOException, InterruptedException {
        Server server = new Server(port);
        server.run();
    }

}
