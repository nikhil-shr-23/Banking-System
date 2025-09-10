// OOP Concept: Inheritance - BankAccount extends Account
public class BankAccount extends Account {
    
    public BankAccount(String name, String accountNumber, double initialBalance) {
        super(name, accountNumber, initialBalance);
    }
    
    // OOP Concept: Polymorphism - Method Overriding
    @Override
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit successful! New balance: " + String.format("%.2f", balance));
        } else {
            System.out.println("Invalid amount! Please enter a positive value.");
        }
    }
    
    // OOP Concept: Polymorphism - Method Overriding
    @Override
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
}
