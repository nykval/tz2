package main;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class TestDataGenerator {

    /**
     * Основной метод для генерации тестовых данных.
     * Генерирует файлы с различными количествами случайных чисел.
     * @param args аргументы командной строки (не используются)
     */
    public static void main(String[] args) {
        // Массив размеров данных для генерации
        int[] sizes = {10, 100, 1000, 10000, 100000, 1000000};
        Random rand = new Random();

        // Генерация данных для каждого размера
        for (int sz : sizes) {
            try (FileWriter fw = new FileWriter("numbers_" + sz + ".txt")) {
                // Запись случайных чисел в файл
                for (int i = 0; i < sz; i++) {
                    fw.write(rand.nextInt(1000000) + " ");
                }
            } catch (IOException e) {
                // Обработка ошибки ввода-вывода
                System.out.println("Ошибка при записи в файл: " + e.getMessage());
            }
        }
    }
}
