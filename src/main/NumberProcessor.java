package main;

import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class NumberProcessor {
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

    public static int _min(List<Integer> nums) {
        return Collections.min(nums);
    }

    public static int _max(List<Integer> nums) {
        return Collections.max(nums);
    }

    public static long _sum(List<Integer> nums) {
        long sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return sum;
    }

    public static BigInteger _mult(List<Integer> nums) {
        BigInteger prod = BigInteger.ONE;
        for (int num : nums) {
            prod = prod.multiply(BigInteger.valueOf(num));
            if (prod.equals(BigInteger.ZERO)) break;
        }
        return prod;
    }

    public static void main(String[] args) {
        try {
            List<Integer> nums = readNumbersFromFile("numbers_10.txt");
            System.out.println("Минимальное число: " + _min(nums));
            System.out.println("Максимальное число: " + _max(nums));
            System.out.println("Сумма чисел: " + _sum(nums));
            System.out.println("Произведение чисел: " + _mult(nums));
        } catch (IOException e) {
            System.out.println("Ошибка при чтении файла: " + e.getMessage());
        }
    }
}
