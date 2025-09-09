public class BankAccount {
    private String name;
    private String accountNumber;
    private double balance;
    
    public BankAccount(String name, String accountNumber, double initialBalance) {
        this.name = name;
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }
    
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit successful! New balance: $" + String.format("%.2f", balance));
        } else {
            System.out.println("Invalid amount! Please enter a positive value.");
        }
    }
    
    public void withdraw(double amount) {
        if (amount > 0) {
            if (amount <= balance) {
                balance -= amount;
                System.out.println("Withdrawal successful! New balance: $" + String.format("%.2f", balance));
            } else {
                System.out.println("Insufficient funds! Current balance: $" + String.format("%.2f", balance));
            }
        } else {
            System.out.println("Invalid amount! Please enter a positive value.");
        }
    }
    
    public void checkBalance() {
        System.out.println("Account Holder: " + name);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Current Balance: $" + String.format("%.2f", balance));
    }
    
    public String getName() {
        return name;
    }
    
    public String getAccountNumber() {
        return accountNumber;
    }
    
    public double getBalance() {
        return balance;
    }
}
