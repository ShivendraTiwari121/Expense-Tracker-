import java.util.Scanner;

public class CurrencyConvertor {
    // Exchange rates from USD to other currencies
    public static final double USD_TO_EUR = 0.85;
    
    public static final double USD_TO_INR = 74.15;
    

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Currency Converter!");

        System.out.print("Enter the amount in USD: ");
        double amountInUSD = scanner.nextDouble();

        System.out.println("Choose the currency to convert to:");
        System.out.println("1. EUR (Euros)");
        
        System.out.println("2. INR (Indian Rupees)");
        
        int choice = scanner.nextInt();
        double convertedAmount = 0;

        switch (choice) {
            case 1:
                convertedAmount = convertUSDToCurrency(amountInUSD, USD_TO_EUR);
                System.out.printf("%.2f USD is %.2f EUR\n", amountInUSD, convertedAmount);
                break;
    
            case 2:
                convertedAmount = convertUSDToCurrency(amountInUSD, USD_TO_INR);
                System.out.printf("%.2f USD is %.2f INR\n", amountInUSD, convertedAmount);
                break;
            default:
                System.out.println("Invalid choice. Please choose a valid currency option.");
        }

        scanner.close();
    }

    public static double convertUSDToCurrency(double amountInUSD, double exchangeRate) {
        return amountInUSD * exchangeRate;
    }
}

