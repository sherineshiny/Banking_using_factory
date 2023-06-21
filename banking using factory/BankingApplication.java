import java.util.Scanner;
public class BankingApplication {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        
        Account account = null;
        String accountType = "Bank";

        while (true) {
            System.out.println("Choose an option:");
            System.out.println("1. Sign up");
            System.out.println("2. Sign in");
            System.out.println("3. Forgot account credentials");
            System.out.println("4. Update account credentials");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    if (account != null) {
                        System.out.println("You are already signed up!");
                    } else {
                        account = AccountFactory.getAccount(accountType);
                        account.signUp();
                    }
                    break;
                case 2:
                    if (account == null) {
                        System.out.println("You need to sign up first!");
                    } else {
                        account.signIn();
                    }
                    break;
                case 3:
                    if (account == null) {
                        System.out.println("You need to sign up first!");
                    } else {
                        account.forgotCredentials();
                    }
                    break;
                case 4:
                    if (account == null) {
                        System.out.println("You need to sign up first!");
                    } else {
                        account.updateCredentials();
                    }
                    break;
                case 5:
                    System.out.println("Exiting the application...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
