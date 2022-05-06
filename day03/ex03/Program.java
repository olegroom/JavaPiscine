import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Program {
    public static void main(String[] args) throws IOException {
        int numOfThreads = Integer.parseInt(args[0].substring(15));
        BufferedReader br = new BufferedReader(new FileReader("files_urls.txt"));
        Queue<String> urls = new LinkedList<>();

        String url;
        while ((url = br.readLine()) != null)
            urls.add(url);

        Downloader.initQ(urls);

        for (int i = 0 ; i < numOfThreads; i++)
            new MyThread().start();

    }
}
