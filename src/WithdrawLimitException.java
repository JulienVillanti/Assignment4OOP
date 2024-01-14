public class WithdrawLimitException extends Exception {
    public WithdrawLimitException() {
        super("The amount you are trying to withdraw is greater than the limit! Please enter another amount.");
    }

    public WithdrawLimitException(String s) {
        super(s);
    }

    public String getMessage() {
        return super.getMessage();
    }
}
