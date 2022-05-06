import java.lang.*;
import java.util.Scanner;

public class Program {
    static char[] topTenArray = new char[10];
    static short[] topTenCharsOccurs = new short[10];
    static short[] hashes = new short[10];
    static short[] occurrences = new short[65535];
    static boolean[] isNumberPrinted = new boolean[10];
    static int tmpIndex;

    static void printTopTen() {
        for (int i = 0; i < 10 && topTenCharsOccurs[i] != 0; ++i)
            System.out.printf("%3c", topTenArray[i]);
    }

    private static void sortTopTenByNumberOfOccurs() {
        for (int i = 0; i < topTenCharsOccurs.length; i++) {
            for (int j = 0; j < topTenCharsOccurs.length - i - 1; j++) {
                if (topTenCharsOccurs[j] < topTenCharsOccurs[j + 1]) {
                    short tmpSh = topTenCharsOccurs[j];
                    topTenCharsOccurs[j] = topTenCharsOccurs[j + 1];
                    topTenCharsOccurs[j + 1] = tmpSh;
                    char tmpChar = topTenArray[j];
                    topTenArray[j] = topTenArray[j + 1];
                    topTenArray[j + 1] = tmpChar;
                }
            }
        }
    }

    private static void findTopTen() {
        for (int i = 0; i < occurrences.length; i++) {
            if (occurrences[i] > getMinValueFromTopTenArr()) {
                topTenCharsOccurs[tmpIndex] = occurrences[i];
                topTenArray[tmpIndex] = (char)i;
            }
        }
    }

    private static int getMinValueFromTopTenArr() {
        int min = 1000;
        for (int i = 0; i < 10; i++)
            if (topTenCharsOccurs[i] < min) {
                min = topTenCharsOccurs[i];
                tmpIndex = i;
            }
        return min;
    }

    private static short findHowManyDivIsNeededToGetN(float div, float num) {
        short result = 0;
        for (float tmpSum = div; tmpSum <= num; tmpSum += div)
            result++;
        return result;
    }

    private static void findNumberOfHashes() {
        float div = topTenCharsOccurs[0] / 10.0f;
        for (int i = 0; i < 10; i++)
            hashes[i] = findHowManyDivIsNeededToGetN(div, topTenCharsOccurs[i]);
    }

    private static void printOccursWithHashes() {
        for (int i = 0; i < 11; i++) {

            for (int j = 0; j < 10 && topTenCharsOccurs[j] != 0; j++) {
                if (isNumberPrinted[j]) {
                    System.out.printf("%3c", '#');
                    hashes[j]--;
                }
                else {
                    if (j == 0 || (hashes[j] - hashes[j - 1] == 0)) {
                        System.out.printf("%3d", topTenCharsOccurs[j]);
                        isNumberPrinted[j] = true;
                    }
                    else
                        break;

                    for (int l = j + 1; l < 10; l++) {
                        if (topTenCharsOccurs[l] == topTenCharsOccurs[j]) {
                            System.out.printf("%3d", topTenCharsOccurs[j]);
                            isNumberPrinted[l] = true;
                            j = l;
                        }
                    }
                }

            }

            System.out.println();

        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String line = scan.nextLine();
        if (line.isEmpty())
            System.exit(-1);
        char[] inputLine = line.toCharArray();
        for (int i = 0; i < line.length(); ++i)
            occurrences[inputLine[i]]++;
        findTopTen();
        sortTopTenByNumberOfOccurs();
        findNumberOfHashes();
        printOccursWithHashes();

        printTopTen();
    }

}