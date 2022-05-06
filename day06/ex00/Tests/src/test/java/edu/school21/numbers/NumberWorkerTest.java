package edu.school21.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.ValueSource;

class NumberWorkerTest {

    NumberWorker nw;

    @BeforeEach
    void beforeEachMethod() {
        nw = new NumberWorker();
    }

    @ParameterizedTest
    @ValueSource(ints = {95219, 11329, 10091})
    void isPrimeForPrimes(int number) {
        Assertions.assertTrue(nw.isPrime(number));
    }

    @ParameterizedTest
    @ValueSource(ints = {91239, 12319, 19011})
    void isPrimeForNotPrimes(int number) {
        Assertions.assertFalse(nw.isPrime(number));
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 0, -5, -15, -4545})
    void isPrimeForIncorrectNumbers(int number) {
        Assertions.assertThrows(IllegalNumberException.class, () -> nw.isPrime(number));
    }

    @ParameterizedTest
    @CsvFileSource(resources = {"/data.csv"}, delimiter = ',')
    void checkDigitSum(int x, int y) {
        Assertions.assertEquals(nw.digitsSum(x), y);
    }
}