import java.io.*;
import java.util.*;

public class Program {

    public static List<String> inputB = new ArrayList<>();
    public static List<String> inputA = new ArrayList<>();
    public static TreeSet<String> dictionary = new TreeSet<>();
    static boolean isAZero = false;
    static boolean isBZero = false;


    public static void openFilesAndWriteToArrays(String filenameA, String filenameB) throws FileNotFoundException {
        BufferedReader inA = null;
        BufferedWriter writer;
        BufferedReader inB = null;

        try {
            inA = new BufferedReader(new FileReader(filenameA));
            inB = new BufferedReader(new FileReader(filenameB));

            if (!inA.ready()) {
                isAZero = true;
                return;
            }
            else if (!inB.ready()) {
                isBZero = true;
                return;
            }
            writer = new BufferedWriter(new FileWriter("dictionary.txt"));


            String line;
            while ((line = inA.readLine()) != null) {
                String[] arrayOfStrings = line.split(" ");
                inputA.addAll(Arrays.asList(arrayOfStrings));
                dictionary.addAll(inputA);
            }

            while ((line = inB.readLine()) != null) {
                String[] arrayOfStrings = line.split(" ");
                inputB.addAll(Arrays.asList(arrayOfStrings));
                dictionary.addAll(inputB);
            }

            for (String word : dictionary)
                writer.write(word + " ");

            inA.close();
            inB.close();
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void fillFrequencyOfOccurencesArrays(List<Integer> a, List<Integer> b) {
        int countA = 0;
        int i = 0;
        for (String elem : dictionary) {
            for (String elemFromA : inputA)
                if (elem.equals(elemFromA))
                    countA++;
            a.add(i, countA);
            countA = 0;
            i++;
        }
        i = 0;
        for (String elem : dictionary) {
            for (String elemFromB : inputB)
                if (elem.equals(elemFromB))
                    countA++;
            b.add(i, countA);
            countA = 0;
            i++;
        }
    }

    public static int findNumerator(List<Integer> a, List<Integer> b) {
        int sumOfMulRess = 0;
        for (int i = 0; i < dictionary.size(); i++)
            sumOfMulRess += a.get(i) * b.get(i);
        return sumOfMulRess;
    }

    public static double findDenominator(List<Integer> a, List<Integer> b) {
        double sumOfElementSquaredinA = 0;
        for (Integer x : a)
            sumOfElementSquaredinA += x * x;
        double sumOfElementSquaredinB = 0;
        for (Integer x : b)
            sumOfElementSquaredinB += x * x;
        return Math.sqrt(sumOfElementSquaredinA) * Math.sqrt(sumOfElementSquaredinB);

    }

    public static double calculateSimilarity() {
        List<Integer> frequencyOfiInA = new ArrayList<>(dictionary.size());
        List<Integer> frequencyOfiInB = new ArrayList<>(dictionary.size());

        Scanner scanner = new Scanner(System.in);


        fillFrequencyOfOccurencesArrays(frequencyOfiInA, frequencyOfiInB);
        int numerator = findNumerator(frequencyOfiInA, frequencyOfiInB);
        double denominator = findDenominator(frequencyOfiInA, frequencyOfiInB);
        return numerator / denominator;
    }

    public static void main(String[] args) throws FileNotFoundException {
        openFilesAndWriteToArrays(args[0], args[1]);
        if (isAZero && isBZero)
            System.out.println("Similarity = 1.00");
        else if (isAZero || isBZero)
            System.out.println("Similarity = 0.00");
        else {
            String str = String.format("%.3f", calculateSimilarity());
            System.out.println("Similarity = " + str.substring(0, str.length() - 1));
        }
    }
}
