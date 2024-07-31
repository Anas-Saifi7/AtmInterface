
import java.util.Scanner;

 class BankAccount {
     private double AccountNumber;
     private double balance;
     private String AccountHolderName;
 // Constructor 
    public BankAccount(double AccountNumber, double initialBalance, String AccountHolderName) {
        this.balance = initialBalance;
        this.AccountNumber = AccountNumber;
        this.AccountHolderName = AccountHolderName;
        }

    public double getBalance() {
        return balance;
    }

    public   void  deposit(double amount) {
        if (amount > 0 && AccountHolderName == "Anas" && AccountNumber == 2231) {
            balance += amount;
            System.out.println("Successfully deposited :" + amount);
            System.out.println("Your CurrentBalance is : " + balance);
        }
    
        else {
            System.out.println("Deposit amount must be positive.");
            System.out.println("False Information ");
        }
    
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Successfully withdrew $" + amount);
            System.out.println("Your CurrentBalance is :" + balance);
            return true;
        }
        else if (amount > balance) {
            System.out.println("Insufficient balance.");
            return false;
        }
        else {
            System.out.println("Withdrawal amount must be positive.");
            return false;
        }
    }
}

class ATM {
    private BankAccount account;
    private int pinNumber;
    private Scanner scanner;
    
  // Constructor 
    public ATM(BankAccount account, int pinNumber) {
        this.account = account;
        this.pinNumber = pinNumber;
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        boolean function = false;
        while (!function) {
            displayMenu();
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    deposit();
                    break;
                case 3:
                    withdraw();
                    break;
                case 4:
                    function = true;
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void displayMenu() {
        System.out.println("\n Welcome to the Atm Machine:");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Quit");
        System.out.print("Enter your choice: ");
    }

    private void checkBalance() {
        System.out.println("Current Balance: " + account.getBalance());
    }

    private void deposit() {
        System.out.print("Enter deposit amount: ");
        double amount = scanner.nextDouble();
        account.deposit(amount);
    }

    private void withdraw() {
        System.out.print("Enter withdraw amount: ");
        double amount = scanner.nextDouble();
        account.withdraw(amount);
    }
}

public class AtmInterface {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(2231, 1000, "Anas");
        ATM atm = new ATM(account, 2432);
        atm.start();
    }
}