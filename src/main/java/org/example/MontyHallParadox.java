java
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class MontyHallParadox {

    public static void main(String[] args) {
        int numTests = 1000;
        Map<Integer, String> results = new HashMap<>();
        int wins = 0;
        int losses = 0;

        for (int i = 1; i <= numTests; i++) {
            boolean win = playRound();
            if (win) {
                wins++;
                results.put(i, "Win");
            } else {
                losses++;
                results.put(i, "Loss");
            }
        }

        System.out.println("Wins: " + wins);
        System.out.println("Losses: " + losses);

        System.out.println("Results:");
        for (Map.Entry<Integer, String> entry : results.entrySet()) {
            System.out.println("Step " + entry.getKey() + ": " + entry.getValue());
        }
    }

    private static boolean playRound() {
        Random rand = new Random();
        int carPosition = rand.nextInt(3); // 0, 1, or 2
        int firstChoice = rand.nextInt(3); // 0, 1, or 2

        // Monty opens a door with a goat behind it
        int revealedDoor;
        do {
            revealedDoor = rand.nextInt(3);
        } while (revealedDoor == carPosition || revealedDoor == firstChoice);

        // Switch the choice to the other unopened door
        int secondChoice;
        do {
            secondChoice = rand.nextInt(3);
        } while (secondChoice == firstChoice || secondChoice == revealedDoor);

        // Determine if the second choice is a win or loss
        return secondChoice == carPosition;
    }
}