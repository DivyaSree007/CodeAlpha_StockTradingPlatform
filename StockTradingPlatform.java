import java.util.ArrayList;
import java.util.Scanner;

public class StockTradingPlatform {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ArrayList<Stock> stocks = new ArrayList<>();

        stocks.add(new Stock("AAPL", "Apple", 150));
        stocks.add(new Stock("GOOG", "Google", 180));
        stocks.add(new Stock("TSLA", "Tesla", 220));
        stocks.add(new Stock("AMZN", "Amazon", 170));

        User user = new User("Student", 10000);

        int choice;

        do {

            System.out.println("\n===== STOCK TRADING PLATFORM =====");

            System.out.println("1. Display Market");
            System.out.println("2. Buy Stock");
            System.out.println("3. Sell Stock");
            System.out.println("4. View Portfolio");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.println("\n----- MARKET DATA -----");

                    for (Stock stock : stocks) {
                        stock.displayStock();
                    }
                    break;

                case 2:

                    System.out.print("Enter stock symbol: ");
                    String buySymbol = sc.next();

                    System.out.print("Enter quantity: ");
                    int buyQuantity = sc.nextInt();

                    for (Stock stock : stocks) {

                        if (stock.getSymbol().equalsIgnoreCase(buySymbol)) {

                            user.buyStock(stock, buyQuantity);
                            break;
                        }
                    }

                    break;

                case 3:

                    System.out.print("Enter stock symbol: ");
                    String sellSymbol = sc.next();

                    System.out.print("Enter quantity: ");
                    int sellQuantity = sc.nextInt();

                    for (Stock stock : stocks) {

                        if (stock.getSymbol().equalsIgnoreCase(sellSymbol)) {

                            user.sellStock(stock, sellQuantity);
                            break;
                        }
                    }

                    break;

                case 4:

                    user.displayPortfolio();
                    break;

                case 5:

                    System.out.println("Thank you for using the platform!");
                    break;

                default:

                    System.out.println("Invalid choice!");
            }

        } while (choice != 5);

        sc.close();
    }
}