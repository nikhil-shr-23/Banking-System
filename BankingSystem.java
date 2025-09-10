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

        // to learn - regex 
        String firstName = name.trim().split("\\s+")[0];
        

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
        
        BankAccount account = new BankAccount(name, accountNumber, initialBalance);
        
        System.out.println("\nAccount created successfully!");
        System.out.println("Hello " + title + " " + firstName + "!");
        
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
                    handleDeposit(account, scanner);
                    break;
                    
                case "2":
                    handleWithdraw(account, scanner);
                    break;
                    
                case "3":
                    System.out.println("\n--- Account Information ---");
                    account.checkBalance();
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
    
    private static void handleDeposit(BankAccount account, Scanner scanner) {
        System.out.print("\nEnter amount to deposit: ");
        double amount = getValidAmount(scanner);
        if (amount > 0) {
            account.deposit(amount);
        }
    }
    
    private static void handleWithdraw(BankAccount account, Scanner scanner) {
        System.out.print("\nEnter amount to withdraw: ");
        double amount = getValidAmount(scanner);
        if (amount > 0) {
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

}
