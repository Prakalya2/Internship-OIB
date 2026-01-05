

import java.util.*;

public class Task_3 {

    static Scanner sc = new Scanner(System.in);
    static double balance = 5000;
    static ArrayList<String> history = new ArrayList<>();

    public static void main(String[] args) {

        // LOGIN
        System.out.println("===== ATM LOGIN =====");
        System.out.print("Enter User ID: ");
        String userId = sc.next();

        System.out.print("Enter PIN: ");
        int pin = sc.nextInt();

        if (!userId.equals("admin") || pin != 1234) {
            System.out.println("Invalid Credentials!");
            return;
        }

        System.out.println("Login Successful!");

        while (true) {
            System.out.println("\n===== ATM MENU =====");
            System.out.println("1. Transaction History");
            System.out.println("2. Withdraw");
            System.out.println("3. Deposit");
            System.out.println("4. Transfer");
            System.out.println("5. Quit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    showHistory();
                    break;

                case 2:
                    withdraw();
                    break;

                case 3:
                    deposit();
                    break;

                case 4:
                    transfer();
                    break;

                case 5:
                    System.out.println("Thank you for using ATM!");
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    static void showHistory() {
        System.out.println("\n--- Transaction History ---");
        if (history.isEmpty()) {
            System.out.println("No transactions found.");
        } else {
            for (String h : history) {
                System.out.println(h);
            }
        }
    }

    static void withdraw() {
        System.out.print("Enter amount to withdraw: ₹");
        double amount = sc.nextDouble();

        if (amount <= balance) {
            balance -= amount;
            history.add("Withdrawn: ₹" + amount);
            System.out.println("Withdrawal Successful!");
        } else {
            System.out.println("Insufficient Balance!");
        }
    }

    static void deposit() {
        System.out.print("Enter amount to deposit: ₹");
        double amount = sc.nextDouble();

        balance += amount;
        history.add("Deposited: ₹" + amount);
        System.out.println("Deposit Successful!");
    }

    static void transfer() {
        System.out.print("Enter amount to transfer: ₹");
        double amount = sc.nextDouble();

        if (amount <= balance) {
            balance -= amount;
            history.add("Transferred: ₹" + amount);
            System.out.println("Transfer Successful!");
        } else {
            System.out.println("Insufficient Balance!");
        }
    }
}
