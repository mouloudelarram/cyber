import org.mindrot.jbcrypt.BCrypt;

public class PasswordChecker {
    // Méthode pour hacher un mot de passe
    public static String hashPassword(String password) {
        // Hachage du mot de passe avec un sel généré automatiquement par bcrypt
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

    // Méthode pour vérifier un mot de passe
    public static boolean checkPassword(String password, String hashedPassword) {
        // Vérification si le mot de passe saisi correspond au mot de passe haché
        return BCrypt.checkpw(password, hashedPassword);
    }

    public static void main(String[] args) {
        // Exemple d'utilisation
        String password = "password123";
        String hashedPassword = hashPassword(password);
        
        // Vérifier si le mot de passe saisi correspond au mot de passe haché
        if (checkPassword("password123", hashedPassword)) {
            System.out.println("Mot de passe correct");
        } else {
            System.out.println("Mot de passe incorrect");
        }
    }
}
