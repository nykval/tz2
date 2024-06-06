package main;

import org.junit.Test;
import org.junit.Before;
import org.junit.Assert;

import java.io.IOException;
import java.util.List;
import java.math.BigInteger;

public class NumberProcessorTest {
    private List<Integer> testNumbers;

    /**
     * Устанавливает тестовые данные перед каждым тестом.
     * Читает числа из файла для использования в тестах.
     * @throws IOException если возникает ошибка при чтении файла
     */
    @Before
    public void setUp() throws IOException {
        testNumbers = NumberProcessor.readNumbersFromFile("tests/numbers_10.txt");
    }

    /**
     * Тестирует функцию _min, проверяя, что результат находится в списке чисел.
     */
    @Test
    public void testMinFunction() {
        int actualMin = NumberProcessor._min(testNumbers);
        Assert.assertTrue(testNumbers.contains(actualMin));
    }

    /**
     * Тестирует функцию _max, проверяя, что результат находится в списке чисел.
     */
    @Test
    public void testMaxFunction() {
        int actualMax = NumberProcessor._max(testNumbers);
        Assert.assertTrue(testNumbers.contains(actualMax));
    }

    /**
     * Тестирует функцию _sum, сравнивая результат с ожидаемой суммой.
     */
    @Test
    public void testSumFunction() {
        long actualSum = NumberProcessor._sum(testNumbers);
        long expectedSum = testNumbers.stream().mapToLong(Integer::intValue).sum();
        Assert.assertEquals(expectedSum, actualSum);
    }

    /**
     * Тестирует функцию _mult, сравнивая результат с ожидаемым произведением.
     */
    @Test
    public void testProductFunction() {
        BigInteger actualProduct = NumberProcessor._mult(testNumbers);
        BigInteger expectedProduct = testNumbers.stream().map(BigInteger::valueOf).reduce(BigInteger.ONE, BigInteger::multiply);
        Assert.assertEquals(expectedProduct, actualProduct);
    }

    /**
     * Тестирует обработку IOException в функции readNumbersFromFile.
     * Ожидается, что будет выброшено исключение IOException.
     * @throws IOException если возникает ошибка при чтении файла
     */
    @Test(expected = IOException.class)
    public void testIOExceptionInReadNumbers() throws IOException {
        String nonExistingFile = "non_existing_file.txt";
        NumberProcessor.readNumbersFromFile(nonExistingFile);
    }

    /**
     * Тестирует производительность функции measureSumPerformance.
     * Проверяет, что время выполнения не превышает ожидаемого значения.
     * @throws IOException если возникает ошибка при чтении файла
     */
    @Test(timeout = 10)
    public void testSumPerformance() throws IOException {
        long startTime = System.currentTimeMillis();
        NumberProcessor.measureSumPerformance("tests/numbers_10.txt");
        long endTime = System.currentTimeMillis();
        long actualExecutionTime = endTime - startTime;
        Assert.assertTrue(actualExecutionTime <= 10);
    }
}
