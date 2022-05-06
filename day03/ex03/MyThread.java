import java.util.Queue;

public class MyThread extends Thread {

    @Override
    public void run() {
        String urlToDown;

        while ((urlToDown = Downloader.getNextUrl()) != null)
            Downloader.downloadFile(urlToDown);
    }
}
