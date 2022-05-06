import java.util.List;

public class OrchestrateThreads extends Thread {

    private static int sumOfThreads = 0;
    int bI;
    int lI;
    int localSum;



    private static synchronized void addToSum(int localSum, int b, int l) {
        System.out.println(Thread.currentThread().getName() +
                ": from " + b + " to " + l + " sum is " + localSum);
        sumOfThreads += localSum;
    }

    public static int getSumOfThreads() {
        return sumOfThreads;
    }

    public OrchestrateThreads(List<Integer> sublist, int b, int l) {
        this.bI = b;
        this.lI = l;
        localSum = 0;
        for (int x : sublist) {
            localSum += x;
        }
    }

    @Override
    public void run() {
        addToSum(localSum, bI, lI);
    }
}
