
import java.util.*;
class Reservation {
    int pnr;
    String name;
    int trainNo;
    String trainName;
    String classType;
    String journeyDate;
    String from;
    String to;
    Reservation(int pnr, String name, int trainNo, String trainName,
                String classType, String journeyDate, String from, String to) {
        this.pnr = pnr;
        this.name = name;
        this.trainNo = trainNo;
        this.trainName = trainName;
        this.classType = classType;
        this.journeyDate = journeyDate;
        this.from = from;
        this.to = to;
    }

    public String toString() {
        return "\nPNR: " + pnr +
               "\nName: " + name +
               "\nTrain No: " + trainNo +
               "\nTrain Name: " + trainName +
               "\nClass: " + classType +
               "\nDate: " + journeyDate +
               "\nFrom: " + from +
               "\nTo: " + to;
    }
}

public class Task_1 {
    static Scanner sc = new Scanner(System.in);
    static HashMap<Integer, Reservation> database = new HashMap<>();
    static int pnrCounter = 1001;

    public static void main(String[] args) {

        // LOGIN
        System.out.println("===== LOGIN =====");
        System.out.print("Enter Username: ");
        String user = sc.next();
        System.out.print("Enter Password: ");
        String pass = sc.next();

        if (!user.equals("admin") || !pass.equals("admin")) {
            System.out.println("Invalid Login!");
            return;
        }

        System.out.println("Login Successful!\n");

        while (true) {
            System.out.println("\n===== ONLINE RESERVATION SYSTEM =====");
            System.out.println("1. Reservation");
            System.out.println("2. Cancellation");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    reserveTicket();
                    break;
                case 2:
                    cancelTicket();
                    break;
                case 3:
                    System.out.println("Thank You!");
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    // RESERVATION MODULE
    static void reserveTicket() {
        sc.nextLine();
        System.out.print("Enter Passenger Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Train Number: ");
        int trainNo = sc.nextInt();
        sc.nextLine();

        String trainName = "Express Train"; 

        System.out.print("Enter Class Type: ");
        String classType = sc.nextLine();

        System.out.print("Enter Journey Date: ");
        String date = sc.nextLine();

        System.out.print("From: ");
        String from = sc.nextLine();

        System.out.print("To: ");
        String to = sc.nextLine();

        int pnr = pnrCounter++;
        Reservation r = new Reservation(pnr, name, trainNo, trainName,
                                        classType, date, from, to);

        database.put(pnr, r);
        System.out.println("\nReservation Successful!");
        System.out.println("Your PNR Number: " + pnr);
    }

    // CANCELLATION MODULE
    static void cancelTicket() {
        System.out.print("Enter PNR Number: ");
        int pnr = sc.nextInt();

        if (!database.containsKey(pnr)) {
            System.out.println("PNR not found!");
            return;
        }

        System.out.println(database.get(pnr));
        System.out.print("\nConfirm cancellation (yes/no): ");
        String confirm = sc.next();

        if (confirm.equalsIgnoreCase("yes")) {
            database.remove(pnr);
            System.out.println("Ticket Cancelled Successfully!");
        } else {
            System.out.println("Cancellation Aborted!");
        }
    }
}