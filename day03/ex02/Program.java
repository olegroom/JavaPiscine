import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Program {

    private static int calculateSumOfList(List<Integer> list) {
        int tmp = 0;
        for (int x : list)
            tmp += x;
        return tmp;
    }

    public static void main(String[] args) {

        int arrLength = Integer.parseInt(args[0].substring(12));
        int numOfThreads = Integer.parseInt(args[1].substring(15));
        List<Integer> generalList = new ArrayList<>(arrLength);

        for (int i = 0; i < arrLength; i++) {
            int rand = ThreadLocalRandom.current().nextInt() % 1000;
            generalList.add(rand < 0 ? rand * -1 : rand);
        }

        System.out.println("Sum: " + calculateSumOfList(generalList));

        int regRange = arrLength / (numOfThreads - 1);

        List<Thread> threadsList = new ArrayList<>(numOfThreads);

        int beginInd = 0;
        int lastInd = 0;
        for (int i = 0; i < numOfThreads - 1; i++) {
            beginInd = i * regRange;
            lastInd = (i + 1) * regRange;
            threadsList.add(new OrchestrateThreads(generalList.subList(beginInd, lastInd), beginInd, lastInd - 1));

        }
        beginInd = (numOfThreads - 1) * regRange;
        lastInd = arrLength;
        threadsList.add(new OrchestrateThreads(generalList.subList(beginInd, lastInd), beginInd, lastInd - 1));

        for (Thread thread : threadsList) thread.start();

        for (Thread thread : threadsList) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Sum by threads: " + OrchestrateThreads.getSumOfThreads());
    }
}
