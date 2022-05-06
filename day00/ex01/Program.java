import java.lang.*;
import java.util.Scanner;

public class Program {

    static boolean isPrime(int num) {
        int count = 0;
        int i = 2;
        if (num <= 1) {
            System.err.println("IllegalArgument");
            System.exit(-1);
        }
        if (num == 2 || num == 3) {
            System.out.println("true " + 1);
            return true;
        }
        int res = 0;
        while (res < num) {
            res = i * i;
            count++;
            if (num % i == 0) {
                System.out.println("false " + count);
                return false;
            }
            i++;
        }
        System.out.println("true " + count);
        return true;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        isPrime(Integer.parseInt(scan.nextLine()));
    }
}
