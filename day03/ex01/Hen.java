public class Hen implements Runnable {
    int count = 0;

    public Hen(int count) {
        this.count = count;
    }


    @Override
    public void run() {
        for (int i = 0; i < count; i++) {
            Program.sayHen();
        }
    }
}
