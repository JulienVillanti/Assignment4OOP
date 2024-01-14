//Assignment4 - OOP -
//Written by Julien Villanti - 2390054

import java.util.Scanner;

class BankAccount {

    private String name; // your name
    private double balance; // current amount of money you save in the bank account
    private final static double depositLimit = 500;
    private final static double withdrawLimit = 500;

    public BankAccount(String name, double balance) {
        this.name = name;
        this.balance = balance;
    }

    public BankAccount(String name) {
        this(name, 0);
    }

    public static void main(String[] args) {

        Scanner kb = new Scanner(System.in);
        BankAccount ba1 = new BankAccount("Julien", 5000);
        System.out.println("Hello " + ba1.getName() + ". Here is your initial balance : " + ba1.getBalance() + "$.");

        while (true) {
            System.out.println("Please choose an option:");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            int choice = kb.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Please enter the amount you would like to deposit : ");
                    double depositAmount = kb.nextDouble();

                    try {
                        ba1.deposit(depositAmount);
                        System.out.println("Deposit successful. Your balance is now " + ba1.getBalance() + "$.");
                    } catch (BankAccountException e) {
                        String errorMessage = e.getMessage();
                        System.out.println(errorMessage);
                    }
                    break;

                case 2:
                    System.out.println("Please enter the amount you would like to withdraw from your account : ");
                    double withdrawAmount = kb.nextDouble();

                    try {

                        ba1.withdraw(withdrawAmount);
                        System.out.println("Withdraw successful. Your balance is now " + ba1.getBalance() + "$.");
                    } catch (BankAccountException e) {
                        String errorMessage = e.getMessage();
                        System.out.println(errorMessage);
                        System.out.println("Please enter another amount: ");
                        try {
                            withdrawAmount = kb.nextDouble();
                            ba1.withdraw(withdrawAmount);
                            System.out.println("Withdraw successful. Your balance is now " + ba1.getBalance() + "$.");
                        } catch (BankAccountException e1) {
                            String errorMessage1 = e1.getMessage();
                            System.out.println(errorMessage1);
                        }
                    }
                    break;

                case 3:
                    System.out.println("Thank you for using our service, Goodbye!");
                    return;

                default:
                    System.out.println("Please enter a valid choice");
            }
        }
    }

    public double getBalance() {
        return balance;
    }

    public String getName() {
        return name;
    }

    public String toString() {
        return "Name: " + name + "\n" + "balance: " + balance;
    }

    public void deposit(double depositAmount) throws BankAccountException {
        if (depositAmount < 0) {
            throw new InvalidAmountException("You cannot deposit a negative amount.");
        }
        if (depositAmount > depositLimit) {
            throw new DepositLimitException("The amount you want to deposit is bigger than the amount allowed, please change your amount.");
        }
        balance = balance + depositAmount;
    }


    public void withdraw(double withdrawAmount) throws BankAccountException {
        if (withdrawAmount < 0) {
            throw new InvalidAmountException("You cannot withdraw a negative amount.");
        }
        if (withdrawAmount > withdrawLimit) {
            throw new DepositLimitException("The amount you want to withdraw is bigger than the amount allowed, please modify it.");
        }
        if (withdrawAmount > balance) {
            throw new NotEnoughBalanceException("You do not have enough money to withdraw that amount.");
        }
        balance = balance - withdrawAmount;

    }


}





