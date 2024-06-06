package main;

import java.io.IOException;
import java.util.List;

public class ExecutionTimeAnalyzer {
    public static void main(String[] args) {
        try {
            String[] testFiles = {
                    "tests/numbers_10.txt",
                    "tests/numbers_100.txt",
                    "tests/numbers_1000.txt",
                    "tests/numbers_10000.txt",
                    "tests/numbers_100000.txt",
                    "tests/numbers_1000000.txt"
            };

            // Массив для хранения времени выполнения
            long[] executionTimes = new long[testFiles.length];

            for (int i = 0; i < testFiles.length; i++) {
                long startTime = System.currentTimeMillis();
                List<Integer> nums = NumberProcessor.readNumbersFromFile(testFiles[i]);
                NumberProcessor._sum(nums); // Вызываем метод _sum для вычисления суммы чисел
                long endTime = System.currentTimeMillis();
                executionTimes[i] = endTime - startTime;
            }

            // Построение графика
            plotExecutionTimes(testFiles, executionTimes);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Метод для вывода времени выполнения
    private static void plotExecutionTimes(String[] files, long[] times) {
        // Вывод времени выполнения и количества чисел в файле
        for (int i = 0; i < files.length; i++) {
            System.out.println("File: " + files[i] + ", Execution Time: " + times[i] + " ms");
        }
    }
}
