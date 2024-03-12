class InvalidPasswordException extends Exception {
    InvalidPasswordException(String message) {
        super(message);
    }
}

class PasswordLengthException extends InvalidPasswordException {
    PasswordLengthException() {
        super("Password must be between 12 and 20 characters long");
    }
}

class PasswordLowerCaseException extends InvalidPasswordException {
    PasswordLowerCaseException() {
        super("Password must contain minimum 3 lower case characters");
    }
}

class PasswordUpperCaseException extends InvalidPasswordException {
    PasswordUpperCaseException() {
        super("Password must contain minimum 3 upper case characters");
    }
}

class UsernameInPasswordException extends InvalidPasswordException {
    UsernameInPasswordException() {
        super("Password cannot contain the username");
    }
}

class SpecialCharactersException extends InvalidPasswordException {
    SpecialCharactersException() {
        super("Password must contain at least 3 special characters");
    }
}

class StartsWithSpecialOrNumberException extends InvalidPasswordException {
    StartsWithSpecialOrNumberException() {
        super("Password must start with a special character or a two-digit number");
    }
}

class FiveConsecutiveSameCharactersException extends InvalidPasswordException {
    FiveConsecutiveSameCharactersException() {
        super("Password cannot contain 5 consecutive identical characters or numbers");
    }
}

class ThreeConsecutiveSameSpecialCharactersException extends InvalidPasswordException {
    ThreeConsecutiveSameSpecialCharactersException() {
        super("Password cannot contain 3 consecutive identical special characters");
    }
}



