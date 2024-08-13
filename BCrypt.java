import java.security.SecureRandom;
import org.mindrot.jbcrypt.BCrypt;

public class BCrypt {

    // Generate a salt with a default work factor
    public static String gensalt() {
        return BCrypt.gensalt();
    }

    // Generate a salt with a specified work factor
    public static String gensalt(int logRounds) {
        return BCrypt.gensalt(logRounds);
    }

    // Hash a password using a given salt
    public static String hashpw(String plainTextPassword, String salt) {
        return BCrypt.hashpw(plainTextPassword, salt);
    }

    // Check if a plain-text password matches the hashed password
    public static boolean checkpw(String plainTextPassword, String hashedPassword) {
        return BCrypt.checkpw(plainTextPassword, hashedPassword);
    }
}