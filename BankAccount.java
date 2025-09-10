// OOP Concept: Class Definition - blueprint for creating objects
public class BankAccount {
    // OOP Concept: Encapsulation - private fields to hide data from direct access
    private String name;
    private String accountNumber;
    private double balance;
    private String password;
    private String pin;
    
    // OOP Concept: Constructor - special method for object initialization
    public BankAccount(String name, String accountNumber, double initialBalance) {
        this.name = name;
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }
    
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit successful! New balance: " + String.format("%.2f", balance));
        } else {
            System.out.println("Invalid amount! Please enter a positive value.");
        }
    }
    
    public void withdraw(double amount) {
        if (amount > 0) {
            if (amount <= balance) {
                balance -= amount;
                System.out.println("Withdrawal successful! New balance: " + String.format("%.2f", balance));
            } else {
                System.out.println("Insufficient funds! Current balance: " + String.format("%.2f", balance));
            }
        } else {
            System.out.println("Invalid amount! Please enter a positive value.");
        }
    }
    
    public void checkBalance() {
        System.out.println("Account Holder: " + name);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Current Balance: " + String.format("%.2f", balance));
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
    
    // OOP Concept: Encapsulation - setter methods to control access to private fields
    public void setPassword(String password) {
        this.password = password;
    }
    
    public void setPin(String pin) {
        this.pin = pin;
    }
    
    // OOP Concept: Encapsulation - getter/verification methods for controlled access
    public boolean verifyPassword(String inputPassword) {
        return password != null && password.equals(inputPassword);
    }
    
    public boolean verifyPin(String inputPin) {
        return pin != null && pin.equals(inputPin);
    }
    
    public void resetPassword(String newPassword) {
        this.password = newPassword;
    }
}
