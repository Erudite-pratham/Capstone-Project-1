import java.util.Scanner;

public class Client {

    public static void main(String[] args) {
        User user = new User();

        Scanner scn = new Scanner(System.in);
        System.out.print("Enter username: ");
        String username = scn.nextLine();
        System.out.print("Enter password: ");
        String password = scn.nextLine();

        user.setUsername(username);
        user.setPassword(password);

        int count = 1;
        while (true) {
            try {
                user.validatePassword();
                System.out.println("Success");
                break;
            } catch (Exception error) {

                System.out.println(error.getMessage());

                if (count <= 3) {
                    System.out.print("Renter password: ");
                    password = scn.nextLine();
                    user.setPassword(password);
                } else {
                    break;
                }
                count++;

            }
        }

    }
}
