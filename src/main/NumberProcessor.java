package main;

import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Класс NumberProcessor содержит методы для обработки чисел.
 */
public class NumberProcessor {

    /**
     * Читает числа из файла и возвращает их в виде списка.
     * @param fileName имя файла, содержащего числа
     * @return список чисел
     * @throws IOException если возникает ошибка при чтении файла
     */
    public static List<Integer> readNumbersFromFile(String fileName) throws IOException {
        List<Integer> nums = new ArrayList<>();
        try (Scanner scan = new Scanner(new File(fileName))) {
            scan.useDelimiter("\\s+");
            while (scan.hasNextInt()) {
                nums.add(scan.nextInt());
            }
        }
        return nums;
    }

    /**
     * Находит минимальное значение в списке чисел.
     * @param nums список чисел
     * @return минимальное значение
     */
    public static int _min(List<Integer> nums) {
        return Collections.min(nums);
    }

    /**
     * Находит максимальное значение в списке чисел.
     * @param nums список чисел
     * @return максимальное значение
     */
    public static int _max(List<Integer> nums) {
        return Collections.max(nums);
    }

    /**
     * Вычисляет сумму всех чисел в списке.
     * @param nums список чисел
     * @return сумма чисел
     */
    public static long _sum(List<Integer> nums) {
        long sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return sum;
    }

    /**
     * Вычисляет произведение всех чисел в списке.
     * @param nums список чисел
     * @return произведение чисел
     */
    public static BigInteger _mult(List<Integer> nums) {
        BigInteger prod = BigInteger.ONE;
        for (int num : nums) {
            prod = prod.multiply(BigInteger.valueOf(num));
            if (prod.equals(BigInteger.ZERO)) break;
        }
        return prod;
    }

    /**
     * Измеряет время выполнения вычисления суммы чисел из файла.
     * @param fileName имя файла, содержащего числа
     * @throws IOException если возникает ошибка при чтении файла
     */
    public static void measureSumPerformance(String fileName) throws IOException {
        long startTime = System.currentTimeMillis(); // Засекаем время начала операции
        List<Integer> nums = readNumbersFromFile(fileName);
        _sum(nums); // Вызываем метод _sum для вычисления суммы чисел
        long endTime = System.currentTimeMillis(); // Засекаем время окончания операции
        long duration = endTime - startTime; // Вычисляем продолжительность операции
        System.out.println("Время выполнения measureSumPerformance для " + fileName + ": " + duration + " мс");
    }
}
