package edu.school21.printer.app;
import com.beust.jcommander.JCommander;
import java.io.*;

class Program {
    public static void main(String[] args) throws IOException {
        Args args1 = new Args();
        JCommander.newBuilder()
                .addObject(args1)
                .build()
                .parse(args);
        args1.run();
    }
}