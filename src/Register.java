import java.util.Scanner;

public class Register {

    // Takes an amount and returns a Purse containing that amount in the fewest number of bills and coins
    public static Purse makeChange(double amt) {
        // Create a new purse instance
        Purse purse = new Purse();

        // Tolerance for small amounts
        double tolerance = 0.005;

        // Checks if amt is within the thresh-hold value of .009 - 0.001 and if so, return 1 penny and set amt to 0
        if (amt < 0.01 && amt >= tolerance) {
            Purse.Denomination penny = purse.getAllDenomination().getLast();
            purse.add(penny, 1);
            amt = 0;
        }

        // Iterates through denomination list, calculating minimum number of bills / coins that can fit inside the amt
        for (Purse.Denomination d: purse.getAllDenomination()) {
            int count = 0;

            /*
             Checks if current denomination can be used (Starting from the biggest denomination to smallest)
             if so calculate how many can fit into amt and add to purse.
             */
            if (d.amount() <= amt && amt >= tolerance) {
                do {
                    amt -= d.amount();
                    count++;
                } while(d.amount() <= amt && amt >= tolerance);

                // Add denomination and number of bills / coins to the purse
                purse.add(d, count);
            }
        }

        // Clean up small value in amt bc I dunno tbh.. sounds right.
        amt = 0;

        // Return the purse object
        return purse;
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
        Purse purse = makeChange(amt);

        // Output the purse object
        System.out.print(purse);

    }
}
