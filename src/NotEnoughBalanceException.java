public class NotEnoughBalanceException extends BankAccountException {
    public NotEnoughBalanceException() {
        super("There is not enough balance! Please enter a valid one.");
    }

    public NotEnoughBalanceException(String s) {
        super(s);
    }

    public String getMessage() {
        return super.getMessage();
    }
}
