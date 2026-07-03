import java.util.Scanner;

class BankAccount {
    private double balance;

       public BankAccount(double initialBalance) {
        if (initialBalance >= 0) {
            this.balance = initialBalance;
        } else {
            this.balance = 0.0;
        }
    }

    public double getBalance() {
        return balance;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }
}
class ATM {
    
    private final BankAccount userAccount;
    private final Scanner scanner;

    public ATM(BankAccount account) {
        this.userAccount = account;
        this.scanner = new Scanner(System.in);
    }

  
    public void startInterface() {
        int choice;
        do {
            System.out.println("\n======= ATM MENU =======");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Exit");
            System.out.print("Please select an option (1-4): ");
           
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                handleSelection(choice);
            } else {
                System.out.println("Error: Invalid input type. Please enter a number.");
                scanner.next(); 
                choice = -1;
            }
        } while (choice != 4);
    }

    private void handleSelection(int choice) {
        switch (choice) {
            case 1:
                checkBalance();
                break;
            case 2:
                System.out.print("Enter deposit amount: $");
                double depositAmount = getValidAmountInput();
                if (depositAmount > 0) deposit(depositAmount);
                break;
            case 3:
                System.out.print("Enter withdrawal amount: $");
                double withdrawAmount = getValidAmountInput();
                if (withdrawAmount > 0) withdraw(withdrawAmount);
                break;
            case 4:
                System.out.println("Thank you for using the ATM. Goodbye!");
                break;
            default:
                System.out.println("Error: Invalid option. Please select 1, 2, 3, or 4.");
        }
    }

    private double getValidAmountInput() {
        if (scanner.hasNextDouble()) {
            double amount = scanner.nextDouble();
            if (amount <= 0) {
                System.out.println("Transaction Failed: Amount must be greater than zero.");
                return -1;
            }
            return amount;
        } else {
            System.out.println("Transaction Failed: Invalid currency format.");
            scanner.next(); 
            return -1;
        }
    }

    public void checkBalance() {
        System.out.printf("Your current balance is: $%.2f%n", userAccount.getBalance());
    }

    public void deposit(double amount) {
        double newBalance = userAccount.getBalance() + amount;
        userAccount.setBalance(newBalance);
        System.out.printf("Success: $%.2f deposited successfully.%n", amount);
        System.out.printf("Updated balance: $%.2f%n", newBalance);
    }

    public void withdraw(double amount) {
        if (amount > userAccount.getBalance()) {
            System.out.println("Transaction Failed: Insufficient funds available.");
        } else {
            double newBalance = userAccount.getBalance() - amount;
            userAccount.setBalance(newBalance);
            System.out.printf("Success: Please collect your cash of $%.2f.%n", amount);
            System.out.printf("Remaining balance: $%.2f%n", newBalance);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(1000.00);
        
        ATM atmMachine = new ATM(account);
        
        atmMachine.startInterface();
    }
}
