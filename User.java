import java.util.HashMap;

public class User {
    private String name;
    private double balance;

    private HashMap<String, Integer> portfolio;

    public User(String name, double balance) {
        this.name = name;
        this.balance = balance;
        portfolio = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }

    public void buyStock(Stock stock, int quantity) {

        double totalCost = stock.getPrice() * quantity;

        if (totalCost > balance) {
            System.out.println("Insufficient balance!");
            return;
        }

        balance = balance - totalCost;

        portfolio.put(
            stock.getSymbol(),
            portfolio.getOrDefault(stock.getSymbol(), 0) + quantity
        );

        System.out.println(
            "Bought " + quantity + " shares of "
            + stock.getSymbol()
        );
    }

    public void sellStock(Stock stock, int quantity) {

        int owned = portfolio.getOrDefault(
            stock.getSymbol(), 0
        );

        if (owned < quantity) {
            System.out.println("You don't own enough shares!");
            return;
        }

        double totalAmount = stock.getPrice() * quantity;

        balance = balance + totalAmount;

        portfolio.put(
            stock.getSymbol(),
            owned - quantity
        );

        System.out.println(
            "Sold " + quantity + " shares of "
            + stock.getSymbol()
        );
    }

    public void displayPortfolio() {

        System.out.println("\n----- PORTFOLIO -----");

        System.out.println("User: " + name);
        System.out.println("Balance: ₹" + balance);

        System.out.println("Stocks:");

        for (String symbol : portfolio.keySet()) {

            int quantity = portfolio.get(symbol);

            System.out.println(
                symbol + " : " + quantity + " shares"
            );
        }
    }
}
