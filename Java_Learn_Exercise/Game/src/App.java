
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        // Get player's score
        System.out.print("Enter player's score: ");
        int playerScore = scanner.nextInt();

        // Determine which level to load based on the player's progress
        if (playerScore >= 0 && playerScore < 50) {
            System.out.println("Loading Level 1");
        } else if (playerScore >= 100 && playerScore < 100) {
            System.out.println("Loading Level 2");
        } else if (playerScore >= 100) {
            System.out.println("Loading Level 3");
        } else {
            System.out.println("Invalid score. Unable to determine the level.");
        }

        scanner.close();
    }
}
