import org.mindrot.jbcrypt.BCrypt;

public class BCryptDemo {
    public static void main(String[] args) {
        String password = "password123";
        String hash = BCrypt.hashpw(password, BCrypt.gensalt());
        System.out.println("password = " + password);
        System.out.println("hash = " + hash);

        boolean answer = BCrypt.checkpw(password, hash);
        System.out.println("answer = " + answer);
        answer = BCrypt.checkpw("cats", hash);
        System.out.println("answer = " + answer);

    }
}
