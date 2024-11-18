import java.util.Scanner;

public class Register {

    private Purse purse;

    // Singleton pattern for Register instance
    private static final Register instance = new Register();

    private Register() {
        this.purse = new Purse();
    }

    public static Register getInstance() {
        return instance;
    }

    // Takes an amount and returns a Purse containing that amount in the fewest number of bills and coins
    public Purse makeChange(double amt) {
        // Create a new purse instance
        Purse newPurse = new Purse();

        // Tolerance for small amounts
        double tolerance = 0.004;

        // Checks if amt is within the thresh-hold value of .009 - 0.001 and if so, return 1 penny and set amt to 0
        if (amt < 0.01 && amt >= tolerance) {
            Purse.Denomination penny = purse.getAllDenomination().getLast();
            newPurse.add(penny, 1);
            amt = 0;
        }

        // Iterates through denomination list, calculating minimum number of bills / coins that can fit inside the amt
        for (Purse.Denomination d : purse.getAllDenomination()) {
            int count = 0;
            /*
             Checks if current denomination can be used (Starting from the biggest denomination to smallest)
             if so calculate how many can fit into amt and add to purse.
             */
            if (d.amount() <= amt && amt >= tolerance) {
                while (d.amount() <= amt && amt >= tolerance) {
                    amt -= d.amount();
                    count++;
                }

                // Add denomination and number of bills / coins to the purse
                newPurse.add(d, count);
            }
        }

        // Final check to ensure any remaining small amount is accounted for
        if (amt < 0.01 && amt >= tolerance) {
            Purse.Denomination penny = purse.getAllDenomination().getLast();
            newPurse.add(penny, 1);
            amt = 0;
        }

        // Update the purse
        this.purse = newPurse;

        return purse;
    }

    // Returns the current purse
    public Purse getPurse() {
        return purse;
    }

    // Sets the current purse
    public void setPurse(Purse purse) {
        this.purse = purse;
    }

    /*
      Takes an amount inputted by user, finds the lowest number of bills to pay the amount and
      puts it into a purse, outputting the results
     */
    public static void main(String[] args) {

        // Output prompt
        System.out.print("Please enter the amount you would like to add: ");

        // Gets user input for variable amt
        Scanner sc = new Scanner(System.in);
        double amt = sc.nextDouble();

        // Calculate results of makeChange, returning the Purse object
        Purse purse = instance.makeChange(amt);

        // Output the purse object
        System.out.print(purse);
    }
}
