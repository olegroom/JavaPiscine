import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;

import javax.swing.*;
import java.io.*;
import java.net.Socket;
import java.util.Scanner;


@Parameters(separators = "=")
public class Main {

    @Parameter(names = "--server-port")
    private Integer portConnectTo;

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        JCommander.newBuilder().addObject(main).build().parse(args);
        main.run();

    }

    private void run() throws IOException {
        Socket socket = new Socket("127.0.0.1", portConnectTo);

        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        Scanner scanner = new Scanner(System.in);


        while (true) {
            String s = reader.readLine();
            System.out.println(s);
            System.out.print("> ");
            String clientMsg = scanner.nextLine();
            writer.write(clientMsg + '\n');
            writer.flush();
            if (clientMsg.equals("exit")) {
                closeConnections(socket, reader, writer);
                return;
            }
        }
    }

    private void closeConnections(Socket socket, BufferedReader reader, BufferedWriter writer) throws IOException {
        if (!socket.isClosed())
            socket.close();
        writer.close();
        reader.close();
    }
}
