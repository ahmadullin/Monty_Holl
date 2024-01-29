package org.example;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class MontyHallParadox {

    public static void main(String[] args) {
        int numTests = 1000; // Количество игр
        Map<Integer, String> results = new HashMap<>(); // Хранение результатов игр
        int wins = 0; // Количество побед
        int losses = 0; // Количество поражений

        for (int i = 1; i <= numTests; i++) {
            boolean win = playRound(); // Играем один раунд
            if (win) {
                wins++;
                results.put(i, "Win"); // Результат - победа
            } else {
                losses++;
                results.put(i, "Loss"); // Результат - поражение
            }
        }

        System.out.println("Wins: " + wins); // Выводим количество побед
        System.out.println("Losses: " + losses); // Выводим количество поражений

        System.out.println("Results:"); // Выводим детализированный список результатов
        for (Map.Entry<Integer, String> entry : results.entrySet()) {
            System.out.println("Step " + entry.getKey() + ": " + entry.getValue());
        }
    }

    private static boolean playRound() {
        Random rand = new Random();
        int carPosition = rand.nextInt(3); // Случайная позиция автомобиля (0, 1 или 2)
        int firstChoice = rand.nextInt(3); // Первоначальный выбор игрока (0, 1 или 2)

        // Монти открывает дверь с козой
        int revealedDoor;
        do {
            revealedDoor = rand.nextInt(3);
        } while (revealedDoor == carPosition || revealedDoor == firstChoice);

        // Меняем выбор на другую неоткрытую дверь
        int secondChoice;
        do {
            secondChoice = rand.nextInt(3);
        } while (secondChoice == firstChoice || secondChoice == revealedDoor);

        // Определяем, победил ли игрок со своим вторым выбором
        return secondChoice == carPosition;
    }
}