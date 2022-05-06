package edu.school21.sockets.server;

import edu.school21.sockets.config.SocketsApplicationConfig;
import edu.school21.sockets.models.User;
import edu.school21.sockets.services.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;


public class Server {

    public enum typeOfSign {
        SIGNIN, SIGNUP
    }

    private final AnnotationConfigApplicationContext context;
    private final ServerSocket serverSocket;
    private final UserService userService;

    public Server(int port) throws IOException {
        this.context = new AnnotationConfigApplicationContext(SocketsApplicationConfig.class);
        serverSocket = new ServerSocket(port);
        userService = context.getBean("userService", UserService.class);
    }

    public boolean signUpOrInTheUser(BufferedWriter writer, BufferedReader reader, typeOfSign type) throws IOException {

        String username = "";
        String password = "";

        writer.write("Enter username:\n");
        writer.flush();
        username = reader.readLine();
        writer.write("Enter password:\n");
        writer.flush();
        password = reader.readLine();

        boolean retState = false;
        if (type == typeOfSign.SIGNIN)
            retState = userService.signIn(username, password);
        else if (type == typeOfSign.SIGNUP)
            retState = userService.signUp(username, password);
        return retState;
    }


    public void run() throws IOException, InterruptedException {

        Socket clientSocket;

        clientSocket = serverSocket.accept();

        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
        BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));


        writer.write("Hello from server!\n");
        writer.flush();
        boolean isSigned = false;
        while(true) {
            String s = reader.readLine();
            if (s.equals("signUp")) {
                signUpOrInTheUser(writer, reader, typeOfSign.SIGNUP);
                writer.write("Start messaging\n");
                writer.flush();
                startMessaging(clientSocket, writer, reader);
                clientSocket.close();
            }
            else if (s.equals("signIn")) {
                if (signUpOrInTheUser(writer, reader, typeOfSign.SIGNIN)) {
                    writer.write("Start messaging\n");
                    writer.flush();
                    startMessaging(clientSocket, writer, reader);
                    clientSocket.close();
                }
                else
                    clientSocket.close();
            }
            else {
                writer.write("Unknown state\n");
                writer.flush();
                break;
            }
        }
        closeConnections(clientSocket);
    }

    private void startMessaging(Socket clientSocket, BufferedWriter writer, BufferedReader reader) throws IOException {
        String innerString;
        while (!(innerString = reader.readLine()).equals("exit")) {
            writer.write("You just write: " + innerString + "\n");
            writer.flush();
        }
    }

    private void closeConnections(Socket clientSocket) throws IOException {
        if (!clientSocket.isClosed())
            clientSocket.close();
        serverSocket.close();
        context.close();
    }


}
