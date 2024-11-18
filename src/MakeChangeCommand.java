public class MakeChangeCommand implements Command {
    private final Register register;
    private final double amount;

    public MakeChangeCommand(Register register, double amount) {
        this.register = register;
        this.amount = amount;
    }

    @Override
    public void execute() {
        Purse newPurse = register.makeChange(amount);
        register.setPurse(newPurse);
    }
}
