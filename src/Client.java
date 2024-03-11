public class Client {

    public static void main(String[] args) {
        User user = new User();
        user.instructions();
        user.setCredentials();

        boolean result = user.validatePassword();

        if (result) {
            System.out.println("Valid password");
        } else {
            System.out.println("Invalid password");
        }
    }
}
