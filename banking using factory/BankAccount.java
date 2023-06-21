import java.util.Scanner;

interface Account {
    void signUp();
    void signIn();
    void forgotCredentials();
    void updateCredentials();
    void performOperation();
}

class BankAccount implements Account {
    static Scanner scanner = new Scanner(System.in);
    private String username;
    private String password;
    private int accountPin;
    private boolean loggedIn;

    @Override
    public void signUp() {
        if (loggedIn) {
            System.out.println("You are already signed up!");
            return;
        }

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter username: ");
        username = scanner.nextLine();
        System.out.print("Enter password: ");
        password = scanner.nextLine();
        System.out.print("Enter account pin: ");
        accountPin = scanner.nextInt();
        loggedIn = true;
        System.out.println("Account created successfully!");
    }

    @Override
    public void signIn() {
        if (loggedIn) {
            System.out.println("You are already signed in!");
            return;
        }

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter username: ");
        String inputUsername = scanner.nextLine();
        System.out.print("Enter password: ");
        String inputPassword = scanner.nextLine();

        if (inputUsername.equals(username) && inputPassword.equals(password)) {
            loggedIn = true;
            System.out.println("Login successful!");
        } else {
            System.out.println("Invalid credentials!");
        }
    }

    @Override
    public void forgotCredentials() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose an option:");
        System.out.println("1. Forgot username");
        System.out.println("2. Forgot password");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                forgotUsername();
                break;
            case 2:
                forgotPassword();
                break;
            default:
                System.out.println("Invalid choice!");
        }
    }

    private void forgotUsername() {
        System.out.println("Generating OTP for username recovery...");
        int otp = generateOTP();
        System.out.println("OTP: " + otp);

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the OTP: ");
        int inputOtp = scanner.nextInt();

        if (inputOtp == otp) {
            System.out.println("Your username is: " + username);
        } else {
            System.out.println("Invalid OTP!");
        }
    }

    private void forgotPassword() {
        System.out.println("Generating OTP for password recovery...");
        int otp = generateOTP();
        System.out.println("OTP: " + otp);

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the OTP: ");
        int inputOtp = scanner.nextInt();

        if (inputOtp == otp) {
            System.out.println("Your password is: " + password);
        } else {
            System.out.println("Invalid OTP!");
        }
    }

    @Override
    public void updateCredentials() {
        if (!loggedIn) {
            System.out.println("You need to sign in first!");
            return;
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose an option:");
        System.out.println("1. Update username");
        System.out.println("2. Update password");
        System.out.println("3. Update account pin");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                updateUsername();
                break;
            case 2:
                updatePassword();
                break;
            case 3:
                updateAccountPin();
                break;
            default:
                System.out.println("Invalid choice!");
        }
    }

    private void updateUsername() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Generating OTP for username update...");
        int otp = generateOTP();
        System.out.println("OTP: " + otp);

        System.out.print("Enter the OTP: ");
        int inputOtp = scanner.nextInt();

        if (inputOtp == otp) {
            scanner.nextLine(); // Consume the newline character
            System.out.print("Enter the new username: ");
            username = scanner.nextLine();
            System.out.println("Username updated successfully!");
        } else {
            System.out.println("Invalid OTP!");
        }
    }

    private void updatePassword() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Generating OTP for password update...");
        int otp = generateOTP();
        System.out.println("OTP: " + otp);

        System.out.print("Enter the OTP: ");
        int inputOtp = scanner.nextInt();

        if (inputOtp == otp) {
            scanner.nextLine(); // Consume the newline character
            System.out.print("Enter the new password: ");
            password = scanner.nextLine();
            System.out.println("Password updated successfully!");
        } else {
            System.out.println("Invalid OTP!");
        }
    }

    private void updateAccountPin() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Generating OTP for account pin update...");
        int otp = generateOTP();
        System.out.println("OTP: " + otp);

        System.out.print("Enter the OTP: ");
        int inputOtp = scanner.nextInt();

        if (inputOtp == otp) {
            System.out.print("Enter the new account pin: ");
            accountPin = scanner.nextInt();
            System.out.println("Account pin updated successfully!");
        } else {
            System.out.println("Invalid OTP!");
        }
    }

    @Override
    public void performOperation() {
        if (!loggedIn) {
            System.out.println("You need to sign in first!");
            return;
        }

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter account pin: ");
        int inputPin = scanner.nextInt();

        if (inputPin == accountPin) {
            System.out.println("Choose an option:");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. View Balance");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Performing deposit operation...");
                    // Implement deposit operation logic
                    break;
                case 2:
                    System.out.println("Performing withdraw operation...");
                    // Implement withdraw operation logic
                    break;
                case 3:
                    System.out.println("Performing view balance operation...");
                    // Implement view balance operation logic
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } else {
            System.out.println("Invalid account pin!");
        }
    }

    private int generateOTP() {
        // Generate and return a random OTP
        return (int) (Math.random() * 10000);
    }
}

