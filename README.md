# Password Validator

This Java program is designed to validate passwords based on a set of criteria. It ensures that passwords meet specific
requirements regarding length, character types, and uniqueness. If a password fails any of the checks, the program
prompts the user to re-enter the password up to three times before exiting.

## Installation

1. Clone the repository: `git clone https://github.com/your-username/password-validator.git`
2. Compile the Java files: `javac User.java Client.java`

## Usage

Run the program using the following command:

```shell
java Client
```

Follow the prompts to enter a username and password. The program will validate the password according to the specified
criteria. If the password is invalid, the user will be prompted to re-enter it.

## Password Criteria

- **Length**: Password must be between 12 and 20 characters long.
- **Lowercase Characters**: Password must contain at least three lowercase letters.
- **Uppercase Characters**: Password must contain at least three uppercase letters.
- **Special Characters**: Password must contain at least three special characters from the following
  list: `!@#$%&*()-_~`.
- **Username Check**: Password must not contain the username.
- **Starting Character**: Password must start with a special character or a number.
- **Consecutive Characters**: Password must not contain five consecutive identical characters or three consecutive
  identical special characters.

## Functions

1. `isPasswordLengthValid()`: Checks if the password length is valid.
2. `containsMinThreeLowerCaseChar()`: Checks if the password contains at least three lowercase characters.
3. `containsMinThreeUpperCaseChar()`: Checks if the password contains at least three uppercase characters.
4. `containsUsername()`: Checks if the password contains the username.
5. `minThreeSpecialCharacters()`: Checks if the password contains at least three special characters.
6. `startsWithSpecialCharOrNumber()`: Checks if the password starts with a special character or a number.
7. `fiveConsecutiveSameCharacters()`: Checks if the password contains five consecutive identical characters.
8. `threeConsecutiveSameSpecialCharacters()`: Checks if the password contains three consecutive identical special
   characters.