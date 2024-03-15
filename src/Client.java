import java.util.Scanner;

public class Client {

    public static void main(String[] args) {
        User user = new User();

        Scanner scn = new Scanner(System.in);

        boolean exit = false;
        while (!exit) {
            System.out.print("Enter username: ");
            String username = scn.nextLine();
            if (username.isEmpty()) {
                System.out.println("Labhesh username cannot be empty 🥲");
                System.out.print("Please enter username: ");
                username = scn.nextLine();
            }
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
