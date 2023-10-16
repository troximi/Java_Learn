import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        // Getting customer's age and item's age rating
        System.out.print("Enter customer's age: ");
        int customerAge = scanner.nextInt();

        System.out.print("Enter item's age rating: ");
        int itemAgeRating = scanner.nextInt();

        // Check if the customer can purchase the item
        if (customerAge >= itemAgeRating) {
            System.out.println("Customer is allowed to purchase the item.");
        } else {
            System.out.println("Customer is not allowed to purchase the item due to age restrictions.");
        }

        scanner.close();
    }

}
