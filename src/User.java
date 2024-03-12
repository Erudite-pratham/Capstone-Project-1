import java.util.ArrayList;

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

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    void validatePassword() throws Exception {
        isPasswordLengthValid();
        containsMinThreeLowerCaseChar();
        containsMinThreeUpperCaseChar();
        containsUsername();
        minThreeSpecialCharacters();
        startsWithSpecialCharOrNumber();
        fiveConsecutiveSameCharacters();
        threeConsecutiveSameSpecialCharacters();
    }

    private void isPasswordLengthValid() throws Exception {
        if (!(password.length() >= 12 && password.length() <= 20)) {
            throw new PasswordLengthException();
        }
    }

    private void containsMinThreeLowerCaseChar() throws Exception {
        int lowerCount = 0;
        for (int i = 0; i < password.length(); i++) {
            char c = password.charAt(i);
            if (c >= 'a' && c <= 'z') {
                lowerCount++;
            }
            if (lowerCount == 3) {
                break;
            }
        }
        if (lowerCount < 3) {
            throw new PasswordLowerCaseException();
        }
    }

    private void containsMinThreeUpperCaseChar() throws Exception {
        int upperCount = 0;
        for (int i = 0; i < password.length(); i++) {
            char c = password.charAt(i);
            if (c >= 'A' && c <= 'Z') {
                upperCount++;
            }
            if (upperCount == 3) {
                break;
            }
        }
        if (upperCount < 3) {
            throw new PasswordUpperCaseException();
        }
    }

    private void containsUsername() throws Exception {
        String username = this.username.toLowerCase();
        String password = this.password.toLowerCase();
        if (password.contains(username)) {
            throw new UsernameInPasswordException();
        }
    }

    private void minThreeSpecialCharacters() throws Exception {
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

        if (count < 3) {
            throw new SpecialCharactersException();
        }
    }

    private void startsWithSpecialCharOrNumber() throws Exception {
        char firstChar = this.password.charAt(0);
        char secondChar = this.password.charAt(1);
        if (!(this.specialCharacters.contains(firstChar) || firstChar >= '0' && firstChar <= '9' && secondChar >= '0' && secondChar <= '9')) {
            throw new StartsWithSpecialOrNumberException();
        }
    }

    private void fiveConsecutiveSameCharacters() throws Exception {
        int count = 0;
        for (int i = 0; i < password.length() - 1; i++) {
            if (password.charAt(i) == password.charAt(i + 1)) {
                count++;
            } else {
                count = 0;
            }
            if (count == 4) {
                throw new FiveConsecutiveSameCharactersException();
            }
        }

    }

    private void threeConsecutiveSameSpecialCharacters() throws Exception {
        int count = 0;
        for (int i = 0; i < password.length() - 1; i++) {
            if (specialCharacters.contains(password.charAt(i)) && specialCharacters.contains(password.charAt(i + 1))) {
                if (password.charAt(i) == password.charAt(i + 1)) {
                    count++;
                }
            } else {
                count = 0;
            }
            if (count == 2) {
                throw new ThreeConsecutiveSameSpecialCharactersException();
            }
        }
    }
}
