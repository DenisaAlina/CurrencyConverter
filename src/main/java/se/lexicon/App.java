package se.lexicon;
import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;



public class App 
{




        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            CurrencyConverter converter = new CurrencyConverter();
            int choice;

            do {
                displayMenu();
                choice = getUserChoice(scanner);

                switch (choice) {
                    case 1:
                        convertCurrency(scanner, converter, "SEK", "USD");
                        break;
                    case 2:
                        convertCurrency(scanner, converter, "USD", "SEK");
                        break;
                    case 3:
                        convertCurrency(scanner, converter, "SEK", "Euro");
                        break;
                    case 4:
                        convertCurrency(scanner, converter, "Euro", "SEK");
                        break;
                    case 0:
                        System.out.println("Exiting the program. Goodbye!");
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } while (choice != 0);

            scanner.close();
        }

        private static void displayMenu() {
            System.out.println("\nCurrency Converter App");
            System.out.println("1. Convert SEK to USD");
            System.out.println("2. Convert USD to SEK");
            System.out.println("3. Convert SEK to Euro");
            System.out.println("4. Convert Euro to SEK");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
        }

        private static int getUserChoice(Scanner scanner) {
            while (!scanner.hasNextInt()) {
                System.out.print("Invalid input. Enter your choice: ");
                scanner.next();
            }
            return scanner.nextInt();
        }

        private static void convertCurrency(Scanner scanner, CurrencyConverter converter, String fromCurrency, String toCurrency) {
            System.out.print("Enter amount in " + fromCurrency + ": ");
            double amount = getValidAmount(scanner);

            double convertedAmount = converter.convert(fromCurrency, toCurrency, amount);
            String formattedDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

            System.out.printf("Converted Amount: %.2f %s (as of %s)%n", convertedAmount, toCurrency, formattedDate);
        }

        private static double getValidAmount(Scanner scanner) {
            while (!scanner.hasNextDouble()) {
                System.out.print("Invalid amount. Please enter a valid amount: ");
                scanner.next();
            }
            double amount = scanner.nextDouble();
            while (amount < 0) {
                System.out.print("Amount cannot be negative. Enter a valid amount: ");
                amount = scanner.nextDouble();
            }
            return amount;
        }
    }
