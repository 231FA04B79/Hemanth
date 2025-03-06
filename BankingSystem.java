import java.util.ArrayList;
import java.util.List;

// Interface for Account
interface Account {
    void deposit(double amount);
    void withdraw(double amount);
    double calculateInterest();
    double getBalance();
    String getAccountType();
}

// Base class for the Bank
class Bank {
    private List<Account> accounts; // List to hold accounts

    public Bank() {
        accounts = new ArrayList<>();
    }

    // Method to add a new account
    public void addAccount(Account account) {
        accounts.add(account);
        System.out.println(account.getAccountType() + " added.");
    }

    // Method to display all account balances
    public void displayAllBalances() {
        for (Account account : accounts) {
            System.out.println(account.getAccountType() + " Balance: " + account.getBalance());
        }
    }
}

// SavingsAccount class implementing Account interface
class SavingsAccount implements Account {
    private double balance;
    private double interestRate; // Interest rate for the savings account

    public SavingsAccount(double initialBalance, double interestRate) {
        this.balance = initialBalance;
        this.interestRate = interestRate;
    }

    @Override
    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: " + amount + " to Savings Account");
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdrew: " + amount + " from Savings Account");
        } else {
            System.out.println("Insufficient funds in Savings Account");
        }
    }

    @Override
    public double calculateInterest() {
        return balance * interestRate;
    }

    @Override
    public double getBalance() {
        return balance;
    }

    @Override
    public String getAccountType() {
        return "Savings Account";
    }
}

// CurrentAccount class implementing Account interface
class CurrentAccount implements Account {
    private double balance;
    private double overdraftLimit; // Overdraft limit for current account

    public CurrentAccount(double initialBalance, double overdraftLimit) {
        this.balance = initialBalance;
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: " + amount + " to Current Account");
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= balance + overdraftLimit) {
            balance -= amount;
            System.out.println("Withdrew: " + amount + " from Current Account");
        } else {
            System.out.println("Insufficient funds in Current Account");
        }
    }

    @Override
    public double calculateInterest() {
        // Current accounts typically do not earn interest, return 0
        return 0;
    }

    @Override
    public double getBalance() {
        return balance;
    }

    @Override
    public String getAccountType() {
        return "Current Account";
    }
}

// Main class to demonstrate the banking system
public class BankingSystem {
    public static void main(String[] args) {
        Bank bank = new Bank(); // Create bank

        // Create accounts
        SavingsAccount savings = new SavingsAccount(1000, 0.05); // 5% interest
        CurrentAccount current = new CurrentAccount(500, 200); // 200 overdraft limit

        // Add accounts to the bank
        bank.addAccount(savings);
        bank.addAccount(current);

        // Perform some operations
        savings.deposit(200);
        savings.withdraw(100);
        System.out.println("Interest earned on Savings Account: " + savings.calculateInterest());

        current.deposit(300);
        current.withdraw(700);
        System.out.println("Balance after withdrawal in Current Account: " + current.getBalance());

        // Display all balances
        bank.displayAllBalances();
    }
}
