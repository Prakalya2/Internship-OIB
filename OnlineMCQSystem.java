import java.util.*;
import java.io.*;

class User {
    private String username;
    private String password;
    private String profile;

    User(String username, String password) {
        this.username = username;
        this.password = password;
        this.profile = "Default Profile";
    }

    public boolean login(String user, String pass) {
        return username.equals(user) && password.equals(pass);
    }

    public void updateProfile(String newProfile) {
        profile = newProfile;
        System.out.println("Profile updated!");
    }

    public void updatePassword(String newPassword) {
        password = newPassword;
        System.out.println("Password updated!");
    }
}

class MCQ {
    private String question;
    private String[] options;
    private int answer;

    MCQ(String question, String[] options, int answer) {
        this.question = question;
        this.options = options;
        this.answer = answer;
    }

    public boolean attempt(int choice) {
        return choice == answer;
    }

    public void display() {
        System.out.println(question);
        for (int i = 0; i < options.length; i++) {
            System.out.println((i + 1) + ". " + options[i]);
        }
    }
}

public class OnlineMCQSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        User user = new User("intern", "1234");
        System.out.print("Enter Username: ");
        String uname = sc.next();
        System.out.print("Enter Password: ");
        String pass = sc.next();

        if (user.login(uname, pass)) {
            System.out.println("Login Successful!");

            System.out.print("Update Profile? (yes/no): ");
            if (sc.next().equalsIgnoreCase("yes")) {
                sc.nextLine(); // consume newline
                System.out.print("Enter new profile info: ");
                String profile = sc.nextLine();
                user.updateProfile(profile);
            }

            System.out.print("Update Password? (yes/no): ");
            if (sc.next().equalsIgnoreCase("yes")) {
                System.out.print("Enter new password: ");
                String newPass = sc.next();
                user.updatePassword(newPass);
            }

            // Sample MCQs
            MCQ[] questions = {
                new MCQ("What is Java?", new String[]{"Programming Language","Animal","City","Game"}, 1),
                new MCQ("Which company developed Java?", new String[]{"Microsoft","Sun Microsystems","Google","Apple"}, 2)
            };

            long startTime = System.currentTimeMillis();
            long timeLimit = 60 * 1000; // 1 minute timer

            for (MCQ q : questions) {
                q.display();
                System.out.print("Enter your choice: ");
                int choice = sc.nextInt();
                if (q.attempt(choice)) {
                    System.out.println("Correct!\n");
                } else {
                    System.out.println("Wrong!\n");
                }

                // Check timer
                if (System.currentTimeMillis() - startTime > timeLimit) {
                    System.out.println("Time is up! Auto-submitting answers...");
                    break;
                }
            }

            System.out.println("Session Closed. Logout Successful.");
        } else {
            System.out.println("Invalid credentials!");
        }

        sc.close();
    }
}
