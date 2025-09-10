import java.util.Scanner;
import java.util.Random;


public class BankingSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("== Welcome to Nikhil Sharma & Co ==");
        System.out.println();
        
        System.out.print("Enter your name? ");
        String name = scanner.nextLine();


        //Gender Selection herer
        String genderChoice;
        while (true) {
            System.out.println("Select your gender:");
            System.out.println("M");
            System.out.println("F");
            System.out.println("N-B");
            System.out.print("Choose: ");
            genderChoice = scanner.nextLine().trim().toUpperCase();
            if (genderChoice.equals("M") || genderChoice.equals("F") || genderChoice.equals("N-B") || genderChoice.equals("NB") || genderChoice.equals("N")) {
                break;
            }
            System.out.println("Please enter M, F, or N-B.");
        }


        //Else ifs for choosing Geneder
        String title;
        if (genderChoice.equals("M")) {
            title = "Mr";
        } else if (genderChoice.equals("F")) {
            title = "Ms";
        } else {
            title = "Mx";
        }

        // regex to remove 
        String firstName = name.trim().split("\\S+")[0];
        

        //here we are generating random account number for user -> task 1)
        Random random = new Random();
        int rando100 = random.nextInt(100);
        String accountNumber = Integer.toString(rando100);
        System.out.println("Aapka Account Number hai: " + accountNumber);
        
        System.out.print("Enter initial balance: ");
        double initialBalance = 0;
        
        while (true) {
            try {
                initialBalance = Double.parseDouble(scanner.nextLine());
                if (initialBalance < 0) {
                    System.out.print("non negative number please");
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.print("Invalid number ");
            }
        }
        
        // OOP Concept: Object Instantiation - creating an instance of BankAccount class
        BankAccount account = new BankAccount(name, accountNumber, initialBalance);
        
        String password = createPassword(scanner);
        // OOP Concept: Encapsulation - using setter method to set private field
        account.setPassword(password);
        
        String pin = createPin(scanner);
        // OOP Concept: Encapsulation - using setter method to set private field
        account.setPin(pin);
        
        System.out.println("\nAccount created successfully!");
        System.out.println("Hello " + title + " " + firstName + "!");
        System.out.println("Password and PIN set successfully!");
        
        boolean running = true;
        while (running) {
            System.out.println("\n=== Banking Menu ===");
            System.out.println("1. Deposit Money");
            System.out.println("2. Withdraw Money");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Choose an option (1-4): ");
            
            String choice = scanner.nextLine().trim();
            
            switch (choice) {
                case "1":
                    if (verifyPasswordOrPin(account, scanner)) {
                        handleDeposit(account, scanner);
                    }
                    break;
                    
                case "2":
                    if (verifyPasswordOrPin(account, scanner)) {
                        handleWithdraw(account, scanner);
                    }
                    break;
                    
                case "3":
                    if (verifyPasswordOrPin(account, scanner)) {
                        System.out.println("\n--- Account Information ---");
                        account.checkBalance();
                    }
                    break;
                    
                case "4":
                    System.out.println("\nThank you jiii for using our system!");
                    System.out.println("Have a great day, " + name + "!");
                    running = false;
                    break;
                    
                default:
                    System.out.println("Invalid option! Please choose 1, 2, 3, or 4.");
            }
        }
        
        scanner.close();
    }
    
    // OOP Concept: Encapsulation - private method that handles deposit operation
    private static void handleDeposit(BankAccount account, Scanner scanner) {
        System.out.print("\nEnter amount to deposit: ");
        double amount = getValidAmount(scanner);
        if (amount > 0) {
            // OOP Concept: Method Invocation - calling object's method
            account.deposit(amount);
        }
    }
    
    // OOP Concept: Encapsulation - private method that handles withdrawal operation
    private static void handleWithdraw(BankAccount account, Scanner scanner) {
        System.out.print("\nEnter amount to withdraw: ");
        double amount = getValidAmount(scanner);
        if (amount > 0) {
            // OOP Concept: Method Invocation - calling object's method
            account.withdraw(amount);
        }
    }
    
    private static double getValidAmount(Scanner scanner) {
        while (true) {
            try {
                double amount = Double.parseDouble(scanner.nextLine());
                if (amount < 0) {
                    System.out.print("Please enter a positive amount: ");
                } else {
                    return amount;
                }
            } catch (NumberFormatException e) {
                System.out.print("Invalidddd Please enter a valid number: ");
            }
        }
    }
    
    private static String createPassword(Scanner scanner) {
        while (true) {
            System.out.print("Create a password (min 7 chars, must include letters, numbers, special chars): ");
            String password = scanner.nextLine();
            if (isValidPassword(password)) {
                return password;
            }
            System.out.println("Password must be at least 7 characters and contain letters, numbers, and special characters.");
        }
    }
    
    private static boolean isValidPassword(String password) {
        if (password.length() < 7) return false;
        boolean hasLetter = false, hasNumber = false, hasSpecial = false;
        for (char c : password.toCharArray()) {
            if (Character.isLetter(c)) hasLetter = true;
            else if (Character.isDigit(c)) hasNumber = true;
            else hasSpecial = true;
        }
        return hasLetter && hasNumber && hasSpecial;
    }
    
    private static String createPin(Scanner scanner) {
        while (true) {
            System.out.print("Create a 4-digit PIN: ");
            String pin = scanner.nextLine();
            if (pin.matches("\\d{4}")) {
                return pin;
            }
            System.out.println("PIN must be exactly 4 digits.");
        }
    }
    
    // OOP Concept: Method Overloading - same method name with different parameters
    private static boolean verifyPasswordOrPin(BankAccount account, Scanner scanner) {
        int attempts = 0;
        while (attempts < 3) {
            System.out.print("Enter your password or PIN: ");
            String input = scanner.nextLine();
            // OOP Concept: Encapsulation - using private methods to verify credentials
            if (account.verifyPassword(input) || account.verifyPin(input)) {
                return true;
            }
            attempts++;
            if (attempts < 3) {
                System.out.println("Incorrect password/PIN. " + (3 - attempts) + " attempts remaining.");
            }
        }
        System.out.println("Too many failed attempts. Password reset required.");
        resetPassword(account, scanner);
        return false;
    }
    
    private static void resetPassword(BankAccount account, Scanner scanner) {
        System.out.println("Password reset:");
        String newPassword = createPassword(scanner);
        account.resetPassword(newPassword);
        System.out.println("Password reset successfully!");
    }

}
