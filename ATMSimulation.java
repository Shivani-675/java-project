import java.util.*;

public class ATMSimulation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Initial balance, PIN, and other setup
        double balance = 1000.00;
        int pin = 1234;
        boolean authenticated = false;

        // Authentication
        System.out.println("Welcome to the ATM!");
        System.out.print("Enter your PIN: ");
        int enteredPin = scanner.nextInt();

        if (enteredPin == pin) {
            authenticated = true;
        } else {
            System.out.println("Incorrect PIN. Exiting...");
            return;
        }

        // Menu-driven system
        while (authenticated) {
            System.out.println("\n--- ATM Menu ---");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    // Check balance
                    System.out.printf("Your balance is: $%.2f\n", balance);
                    break;

                case 2:
                    // Deposit money
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    if (depositAmount > 0) {
                        balance += depositAmount;
                        System.out.printf("$%.2f deposited. Your new balance is $%.2f\n", depositAmount, balance);
                    } else {
                        System.out.println("Invalid deposit amount.");
                    }
                    break;

                case 3:
                    // Withdraw money
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    if (withdrawAmount > 0 && withdrawAmount <= balance) {
                        balance -= withdrawAmount;
                        System.out.printf("$%.2f withdrawn. Your new balance is $%.2f\n", withdrawAmount, balance);
                    } else if (withdrawAmount > balance) {
                        System.out.println("Insufficient funds.");
                    } else {
                        System.out.println("Invalid withdrawal amount.");
                    }
                    break;

                case 4:
                    // Exit
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    authenticated = false;
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }
}