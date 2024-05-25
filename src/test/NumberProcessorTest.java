package main;

import org.junit.Test;
import org.junit.Before;
import org.junit.Assert;
import main.NumberProcessor;

import java.io.IOException;
import java.util.List;
import java.math.BigInteger;

public class NumberProcessorTest {
    private List<Integer> testNumbers;

    @Before
    public void setUp() throws IOException {
        testNumbers = NumberProcessor.readNumbersFromFile("tests/numbers_10.txt");
    }

    @Test
    public void testMinFunction() {
        int actualMin = NumberProcessor._min(testNumbers);
        Assert.assertTrue(testNumbers.contains(actualMin));
    }

    @Test
    public void testMaxFunction() {
        int actualMax = NumberProcessor._max(testNumbers);
        Assert.assertTrue(testNumbers.contains(actualMax));
    }

    @Test
    public void testSumFunction() {
        long actualSum = NumberProcessor._sum(testNumbers);
        long expectedSum = testNumbers.stream().mapToLong(Integer::intValue).sum();
        Assert.assertEquals(expectedSum, actualSum);
    }

    @Test
    public void testProductFunction() {
        BigInteger actualProduct = NumberProcessor._mult(testNumbers);
        BigInteger expectedProduct = testNumbers.stream().map(BigInteger::valueOf).reduce(BigInteger.ONE, BigInteger::multiply);
        Assert.assertEquals(expectedProduct, actualProduct);
    }

    @Test
    public void testIOExceptionInReadNumbers() {
        String nonExistingFile = "non_existing_file.txt";
        try {
            NumberProcessor.readNumbersFromFile(nonExistingFile);
            Assert.fail("Expected an IOException to be thrown");
        } catch (IOException e) {
            // Expected exception, successful test
        }
    }

    @Test
    public void testSumPerformance() throws IOException {
        long expectedExecutionTime = 10;
        long actualExecutionTime = measureExecutionTime(() -> {
            try {
                NumberProcessor.measureSumPerformance("tests/numbers_10.txt");
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        Assert.assertTrue(actualExecutionTime <= expectedExecutionTime);
    }

    private long measureExecutionTime(Runnable task) {
        long startTime = System.currentTimeMillis();
        task.run();
        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }
}