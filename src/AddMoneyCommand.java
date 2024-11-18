public class AddMoneyCommand implements Command {
    private final Purse purse;
    private final Purse.Denomination denomination;
    private final int amount;

    public AddMoneyCommand(Purse purse, Purse.Denomination denomination, int amount) {
        this.purse = purse;
        this.denomination = denomination;
        this.amount = amount;
    }

    @Override
    public void execute() {
        purse.add(denomination, amount);
    }
}
