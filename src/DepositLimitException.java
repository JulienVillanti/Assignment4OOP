public class DepositLimitException extends BankAccountException{

    public DepositLimitException() {
        super("The amount you are trying to deposit is greater than the limit! Please enter another amount.");
    }

    public DepositLimitException(String s) {
        super(s);
    }

    public String getMessage() {
        return super.getMessage();
    }
}
