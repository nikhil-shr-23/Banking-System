
public abstract class Account {
    // encaps
    protected String name;
    protected String accountNumber;
    protected double balance;
    protected String password;
    protected String pin;
    
    public Account(String name, String accountNumber, double initialBalance) {
        this.name = name;
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }
    
    public abstract void deposit(double amount);
    public abstract void withdraw(double amount);
    
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
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    public void setPin(String pin) {
        this.pin = pin;
    }
    
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
