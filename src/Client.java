import java.util.Scanner;

public class Client {

    public static void main(String[] args) {
        User user = new User();

        Scanner scn = new Scanner(System.in);

        int flag = 0;
        boolean exit = false;
        while (!exit) {
            if (flag == 0) {
                System.out.print("Enter username: ");
            } else if (flag == 1) {
                System.out.println("Username cannot be empty");
                System.out.print("Please enter username: ");
            } else {
                System.out.print("Username cannot contain space: ");
            }
            String username = scn.nextLine();
            if (username.isEmpty()) {
                flag = 1;
                continue;
            }
            if (username.contains(" ")) {
                flag = 2;
                continue;
            }
            flag = 0;
            user.setUsername(username);

            int count = 1;
            while (true) {
                System.out.print("Enter password: ");
                String password = scn.nextLine();
                user.setPassword(password);
                try {
                    user.validatePassword();
                    System.out.println("Success");
                    exit = true;
                    break;
                } catch (Exception error) {
                    System.out.println("Error: " + error.getMessage());
                    System.out.println("Your last username is " + user.getUsername() + " and password is " + user.getPassword());
                    if (count == 3) {
                        System.out.print("Do you want to continue Yes/No: ");
                        String yesOrNo = scn.nextLine().toLowerCase();
                        if (yesOrNo.equals("n") || yesOrNo.equals("no")) {
                            exit = true;
                            break;
                        } else if (!yesOrNo.equals("y") && !yesOrNo.equals("yes")) {
                            exit = true;
                            break;
                        }
                        System.out.println("Your last username is " + user.getUsername() + " and password is " + user.getPassword());
                    }
                }
                if (count == 6) {
                    break;
                }
                count++;

            }
        }
    }
}
