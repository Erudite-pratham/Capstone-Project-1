import java.util.Scanner;

public class User {
    private String username;
    private String password;

    void instructions() {
        System.out.println("----------Password Instructions----------");
        int i = 0;
        System.out.println(++i + ". Password length has to be of minimum of 12 character");
        System.out.println(++i + ". Password length has to be of maximum of 20 character");
        System.out.println(++i + ". Password string must consist of Characters - Upper Case (A-Z)");
        System.out.println();
    }

    void setCredentials() {
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter username: ");
        this.username = scn.nextLine();
        System.out.print("Enter password: ");
        this.password = scn.nextLine();
    }

    boolean validatePassword() {
        if (validatePasswordMinLength() && validatePasswordMaxLength()) {
            return true;
        }

        return false;
    }

    private boolean validatePasswordMinLength() {
        return password.length() >= 12;
    }

    private boolean validatePasswordMaxLength() {
        return password.length() <= 20;
    }
}
