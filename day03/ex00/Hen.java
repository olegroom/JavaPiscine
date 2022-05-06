public class Hen extends Thread {
    final private int count;

    public Hen(int count) {
        this.count = count;
    }

    @Override
    public void run() {
        for (int i = 0; i < this.count; i++)
            System.out.println("HEN");
    }
}
