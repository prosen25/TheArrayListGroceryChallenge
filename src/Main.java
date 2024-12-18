import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // Define the grocery list to be used for add and remove
        ArrayList<String> groceryList = new ArrayList<>();

        // Get the user input
        int choice = getUserChoice();

        while (true) {
            // User selected to close the application, so just print a message and do nothing.
            if (choice == 0) {
                System.out.println("Closing the application.");
                break;
            }
            // User selected to add item(s), so cal method to do that.
            if (choice == 1) {
                addGrocery(groceryList);
                choice = getUserChoice();
            }
            // User selected to remove item(s), so cal method to do that.
            if (choice == 2) {
                removeGrocery(groceryList);
                choice = getUserChoice();
            }
        }
    }

    public static int getUserChoice() {

        // Display the option to the user to enter one
        System.out.println("Available actions:");
        System.out.println("0 - to shutdown");
        System.out.println("1 - to add item(s) to the list (comma delimited list)");
        System.out.println("2 - to remove any items (comma delimited list");
        System.out.println("Enter a number for which action you want to do:");

        // Get the user input of choice
        Scanner scanner = new Scanner(System.in);
        int choice;
        while (true) {

            choice = scanner.nextInt();
            if (choice == 0 || choice == 1 || choice == 2) {
                break;
            } else {
                System.out.println("Invalid input. Please enter 0 or 1 or 2.");
            }
        }

        return choice;
    }

    public static void addGrocery(ArrayList<String> groceryList) {

        // Get the grocery list from user in comma delimited to add it
        System.out.println("Enter the grocery to add (comma delimited):");
        Scanner scanner = new Scanner(System.in);
        String[] rawGroceryList = scanner.nextLine().split(",");
        for (String grocery : rawGroceryList) {
            if (!groceryList.contains(grocery.trim())) {
                groceryList.add(grocery.trim());
            }
        }

        // Sort the grocery list
        groceryList.sort(Comparator.naturalOrder());

        // Print the sorted grocery list
        System.out.println(groceryList);
    }

    public static void removeGrocery(ArrayList<String> groceryList) {

        // Get the grocery list from user in comma delimited to remove it
        System.out.println("Enter the grocery to remove (comma delimited):");
        Scanner scanner = new Scanner(System.in);
        String[] rawGroceryList = scanner.nextLine().split(",");
        for (String grocery : rawGroceryList) {
            groceryList.remove(grocery.trim());
        }

        // Print the sorted grocery list
        System.out.println(groceryList);
    }
}