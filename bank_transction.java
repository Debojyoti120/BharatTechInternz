import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Account {
    private String accountNumber;
    private String accountHolder;
    private double balance;

    public Account(String accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("Amount deposited successfully. Updated balance: " + balance);
    }

    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Amount withdrawn successfully. Updated balance: " + balance);
        } else {
            System.out.println("Insufficient funds. Withdrawal unsuccessful.");
        }
    }
}

public class bank_transction {
    private Map<String, Account> accounts;

    public void BankManagementSystem() {
        this.accounts = new HashMap<>();
    }

    public void createAccount(String accountNumber, String accountHolder, double initialBalance) {
        if (!accounts.containsKey(accountNumber)) {
            Account account = new Account(accountNumber, accountHolder, initialBalance);
            accounts.put(accountNumber, account);
            System.out.println("Account created successfully for " + accountHolder + " with account number " + accountNumber);
        } else {
            System.out.println("Account number already exists.");
        }
    }

    public void transferMoney(String fromAccountNumber, String toAccountNumber, double amount) {
        if (accounts.containsKey(fromAccountNumber) && accounts.containsKey(toAccountNumber)) {
            Account fromAccount = accounts.get(fromAccountNumber);
            Account toAccount = accounts.get(toAccountNumber);

            if (fromAccount.getBalance() >= amount) {
                fromAccount.withdraw(amount);
                toAccount.deposit(amount);
                System.out.println("Amount transferred successfully from " + fromAccountNumber + " to " + toAccountNumber);
            } else {
                System.out.println("Insufficient funds for transfer from " + fromAccountNumber);
            }
        } else {
            System.out.println("One or both account numbers are invalid.");
        }
    }

    public double checkAmount(String accountNumber) {
        if (accounts.containsKey(accountNumber)) {
            return accounts.get(accountNumber).getBalance();
        } else {
            System.out.println("Invalid account number.");
            return -1; // Return -1 for an invalid account number
        }
    }

    public static void main(String[] args) {
        bank_transction bank = new bank_transction();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nBank Management System");
            System.out.println("1. Create Account");
            System.out.println("2. Transfer Money");
            System.out.println("3. Check Amount");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter account number: ");
                    String accNumber = scanner.nextLine();
                    System.out.print("Enter account holder name: ");
                    String accHolder = scanner.nextLine();
                    System.out.print("Enter initial balance: ");
                    double initialBalance = scanner.nextDouble();
                    bank.createAccount(accNumber, accHolder, initialBalance);
                    break;
                case 2:
                    System.out.print("Enter your account number: ");
                    String fromAcc = scanner.nextLine();
                    System.out.print("Enter recipient's account number: ");
                    String toAcc = scanner.nextLine();
                    System.out.print("Enter amount to transfer: ");
                    double transferAmount = scanner.nextDouble();
                    bank.transferMoney(fromAcc, toAcc, transferAmount);
                    break;
                case 3:
                    System.out.print("Enter account number to check balance: ");
                    String checkAcc = scanner.nextLine();
                    double balance = bank.checkAmount(checkAcc);
                    if (balance != -1) {
                        System.out.println("Current balance for account " + checkAcc + ": " + balance);
                    }
                    break;
                case 4:
                    System.out.println("Exiting the system. Thank you!");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
                    break;
            }
        }
    }
}
