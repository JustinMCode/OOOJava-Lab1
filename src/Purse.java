import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Purse {

    // A record that will hold the denominations
    public record Denomination(String name, double amount, Form form, String img) {
        // Defined Enum for Form.
        public enum Form {
            BILL, COIN
        }
    }

    // Define bill denominations
    private final Denomination hundredBill = new Denomination("Hundred Dollar Bill", 100.00, Denomination.Form.BILL, "hundred_note.png");
    private final Denomination fiftyBill = new Denomination("Fifty Dollar Bill", 50, Denomination.Form.BILL, "fifty_note.png");
    private final Denomination twentyBill = new Denomination("Twenty Dollar Bill", 20.00, Denomination.Form.BILL, "twenty_note.png");
    private final Denomination tenBill = new Denomination("Ten Dollar Bill", 10.00, Denomination.Form.BILL, "ten_note.png");
    private final Denomination fiveBill = new Denomination("Five Dollar Bill", 5.00, Denomination.Form.BILL, "five_note.png");
    private final Denomination oneBill = new Denomination("One Dollar Bill", 1.00, Denomination.Form.BILL, "one_note.png");

    // Define coin denominations
    private final Denomination quarterCoin = new Denomination("Quarter", 0.25, Denomination.Form.COIN, "quarter.png");
    private final Denomination dimeCoin = new Denomination("Dime", 0.10, Denomination.Form.COIN, "dime.png");
    private final Denomination nickelCoin = new Denomination("Nickel", 0.05, Denomination.Form.COIN, "nickel.png");
    private final Denomination pennyCoin = new Denomination("Penny", 0.01, Denomination.Form.COIN, "penny.png");

    // HashMap that will represent the money in a purse
    private final HashMap<Denomination, Integer> cash = new HashMap<>();

    // Method that adds a number of particular denominations to cash HashMap
    public void add(Denomination d, int amount) {
        if (cash.containsKey(d)) {
            cash.put(d, cash.get(d) + amount); // If denomination exist add x amount
        } else {
            cash.put(d, amount); // If denomination does not exist than add starting amount
        }
    }

    // Removes an amount of a certain denomination and returns the amount left in purse
    public double remove(Denomination d, int amount) {
        // Finds the denomination and removes x amount of them
        if (cash.containsKey(d)) {
            cash.put(d, cash.get(d) - amount);
        }

        // Returns a double of the total amount left in the purse
        return getValue();
    }

    // Returns the total amount of money in the purse
    public double getValue() {
        double totalAmount = 0.0;

        // Cycles through the cash HashMap and generates the total amount of money
        for (HashMap.Entry<Denomination, Integer> entry : cash.entrySet()) {
            Denomination d = entry.getKey();
            int quantity = entry.getValue();

            // Calculate value of denomination and add to total
            totalAmount += d.amount * quantity;
        }

        // Round the total amount to two decimal places
        totalAmount = Math.round(totalAmount * 100.0) / 100.0;

        return totalAmount;
    }

    // Returns a string representation of the Purse and its contents
    public String toString() {

        // Initialize new StringBuilder
        StringBuilder sb = new StringBuilder();

        // Gets double representation of amount in purse
        double amt = getValue();

        // Adds a first statement to the StringBuilder
        sb.append("Your purse contains ").append(amt).append(" in").append("\n");

        // Stream the entries of the cash map, sort them by Denomination amount in descending order
        cash.entrySet().stream()
                .sorted((entry1, entry2) -> Double.compare(entry2.getKey().amount(), entry1.getKey().amount()))
                .forEach(entry -> {
                    Denomination d = entry.getKey();
                    String quantity = Integer.toString(entry.getValue()); // Converts int quantity to string

                    // Append sorted entries to the StringBuilder
                    sb.append(quantity).append(" ").append(d.name()).append(" ").append("\n");
                });

        return sb.toString();
    }

    // Store all denominations in a list for easy iteration over
    private final List<Denomination> allDenomination = List.of(
            hundredBill, fiftyBill, twentyBill, tenBill, fiveBill, oneBill,
            quarterCoin, dimeCoin, nickelCoin, pennyCoin
    );

    // Returns all denominations
    public List<Denomination> getAllDenomination() {
        return allDenomination;
    }

    public Map<Purse.Denomination, Integer> getCash() {
        return cash;
    }


}
