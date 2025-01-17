import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

public class PasswordChecker {
    // Générer un sel aléatoire
    public static String generateSalt() {
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);
        return Base64.getEncoder().encodeToString(salt);
    }

    // Hacher le mot de passe avec un sel
    public static String hashPassword(String password, String salt) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        digest.update(salt.getBytes());
        byte[] hashedBytes = digest.digest(password.getBytes());
        return Base64.getEncoder().encodeToString(hashedBytes);
    }

    // Vérification du mot de passe haché avec le sel
    public static boolean checkPassword(String password, String salt, String hashedPassword) throws NoSuchAlgorithmException {
        String hashedInputPassword = hashPassword(password, salt);
        return hashedPassword.equals(hashedInputPassword);
    }

    public static void main(String[] args) throws NoSuchAlgorithmException {
        String password = "password123";
        String salt = generateSalt();
        String hashedPassword = hashPassword(password, salt);
        
        // Vérifier le mot de passe
        if (checkPassword("password123", salt, hashedPassword)) {
            System.out.println("Mot de passe correct");
        } else {
            System.out.println("Mot de passe incorrect");
        }
    }
}
