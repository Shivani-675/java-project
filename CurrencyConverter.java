import java.util.Scanner;

public class CurrencyConverter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Display available currencies
        System.out.println("Welcome to the Currency Converter!");
        System.out.println("Available currencies:");
        System.out.println("1. USD (US Dollar)");
        System.out.println("2. EUR (Euro)");
        System.out.println("3. GBP (British Pound)");
        System.out.println("4. INR (Indian Rupee)");

        // Get the input currency
        System.out.print("Enter the number for the currency you want to convert from (1-4): ");
        int fromCurrency = scanner.nextInt();

        // Get the output currency
        System.out.print("Enter the number for the currency you want to convert to (1-4): ");
        int toCurrency = scanner.nextInt();

        // Get the amount to convert
        System.out.print("Enter the amount to convert: ");
        double amount = scanner.nextDouble();

        // Conversion rates (relative to 1 USD)
        double[] rates = {1.0, 0.85, 0.75, 74.0}; // USD, EUR, GBP, INR

        // Convert the amount
        if (fromCurrency >= 1 && fromCurrency <= 4 && toCurrency >= 1 && toCurrency <= 4) {
            double amountInUSD = amount / rates[fromCurrency - 1];
            double convertedAmount = amountInUSD * rates[toCurrency - 1];

            System.out.printf("Converted amount: %.2f%n", convertedAmount);
        } else {
            System.out.println("Invalid currency selection. Please try again.");
        }

        // Close the scanner
        scanner.close();
    }
}
