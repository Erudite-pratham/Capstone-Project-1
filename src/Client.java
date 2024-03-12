public class Client {

    public static void main(String[] args) {
        User user = new User();
        user.instructions();
        user.setCredentials();
        String result = user.validatePassword();
        System.out.println(result);
    }
}
