package edu.school21.numbers;

public class NumberWorker {

    public boolean isPrime(int number) {
        int i = 2;
        if (number <= 1) {
            throw new IllegalNumberException("number <= 1");
        }
        if (number == 2 || number == 3) {
            return true;
        }
        int res = 0;
        while (res < number) {
            res = i * i;
            if (number % i == 0) {
                return false;
            }
            i++;
        }
        return true;
    }

    public int digitsSum(int number) {
        int result = 0;
        while (number > 0) {
            int tmp = number % 10;
            result += tmp;
            number /= 10;
        }
        return result;
    }

}

class IllegalNumberException extends RuntimeException {
    public IllegalNumberException(String message) {
        super(message);
    }
}
