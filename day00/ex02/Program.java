import java.util.Scanner;

public class Program {
    static int takeSumOfDigits(int num) {
        int	result = 0;
        while (num > 0) {
            int tmp = num % 10;
            result += tmp;
            num /= 10;
        }
        return result;
    }

    static boolean isPrime(int num) {
        int count = 0;
        int i = 2;
        if (num <= 1)
            return false;
        if (num == 2 || num == 3)
            return true;
        int res = 0;
        while (res < num) {
            res = i * i;
            count++;
            if (num % i == 0) {
                return false;
            }
            i++;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int quire;
        int sumOfDigits;
        boolean prime;
        int count = 0;
        while (true) {
            quire = scan.nextInt();
            if (quire == 42)
                break;
            sumOfDigits = takeSumOfDigits(quire);
            if (isPrime(sumOfDigits))
                count++;
        }
        System.out.println("Count of coffee-request – " + count);
    }

}