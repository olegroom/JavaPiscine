public class Egg extends Thread {
    final private int count;

    public Egg(int count) {
        this.count = count;
    }

    @Override
    public void run() {
        for (int i = 0; i < this.count; i++)
            System.out.println("EGG");
    }
}
