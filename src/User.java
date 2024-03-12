import java.util.ArrayList;
import java.util.Scanner;

public class User {
    private final ArrayList<Character> specialCharacters = new ArrayList<>();
    private String username;
    private String password;

    User() {
        specialCharacters.add('!');
        specialCharacters.add('@');
        specialCharacters.add('#');
        specialCharacters.add('$');
        specialCharacters.add('%');
        specialCharacters.add('&');
        specialCharacters.add('*');
        specialCharacters.add('(');
        specialCharacters.add(')');
        specialCharacters.add('_');
        specialCharacters.add('-');
        specialCharacters.add('~');
    }

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

    String validatePassword() {

        if (!validatePasswordLength()) {
            return "Password must be between 12 and 20 characters long";
        }

        if (!validatePasswordCase()) {
            return "Password must contain both upper and lower case characters";
        }
        if (!validatePasswordNoUsername()) {
            return "Password cannot contain the username";
        }
        if (!validatePasswordThreeSpecialCharacters()) {
            return "Password must contain at least 3 special characters";
        }

        if (!validatePasswordStartsWithSpecialOrNumber()) {
            return "Password must start with a special character or a two-digit number";
        }

        return "Password meets all requirements";
    }

    private boolean validatePasswordLength() {
        return password.length() >= 12 && password.length() <= 20;
    }

    private boolean validatePasswordCase() {
        int upperCount = 0, lowerCount = 0;
        for (int i = 0; i < password.length(); i++) {
            char c = password.charAt(i);
            if (c >= 'A' && c <= 'Z') {
                upperCount++;
            }
            if (c >= 'a' && c <= 'z') {
                lowerCount++;
            }
            if (upperCount >= 3 && lowerCount >= 3) {
                return true;
            }
        }
        return false;
    }

    private boolean validatePasswordNoUsername() {
        String username = this.username.toLowerCase();
        String password = this.password.toLowerCase();
        return !password.contains(username);
    }


    private boolean validatePasswordThreeSpecialCharacters() {
        int count = 0;
        for (int i = 0; i < this.password.length(); i++) {
            char c = this.password.charAt(i);
            if (specialCharacters.contains(c)) {
                count++;
            }
            if (count == 3) {
                break;
            }
        }
        return count == 3;
    }

    private boolean validatePasswordStartsWithSpecialOrNumber() {
        char firstChar = this.password.charAt(0);
        char secondChar = this.password.charAt(1);
        if (this.specialCharacters.contains(firstChar)) {
            return true;
        } else if (firstChar >= '0' && firstChar <= '9' && secondChar >= '0' && secondChar <= '9') {
            return true;
        } else {
            return false;
        }
    }

}
