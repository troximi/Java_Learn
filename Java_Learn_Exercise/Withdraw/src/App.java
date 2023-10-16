import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Simulate a customer's account balance
        double accountBalance = 5000.0; // Assuming $5000.0 in the account

        // Get the withdrawal amount from the customer
        System.out.print("Enter the withdrawal amount: $");
        double withdrawalAmount = scanner.nextDouble();

        // Check if there are sufficient funds for withdrawal
        if (withdrawalAmount > 0) {
            if (withdrawalAmount <= accountBalance) {
                accountBalance -= withdrawalAmount; // Update the account balance
                System.out.println("Withdrawal successful. New balance: $" + accountBalance);
            } else {
                System.out.println("Insufficient funds. Please enter a smaller amount.");
            }
        } else {
            System.out.println("Invalid withdrawal amount. Please enter a positive amount.");
        }

        scanner.close();
    }
}
