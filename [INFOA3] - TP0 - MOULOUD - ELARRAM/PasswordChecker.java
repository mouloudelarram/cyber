/*
 * Decompiled with CFR 0.152.
 */
public class PasswordChecker {
    private static final String WEAK_PASSWORD = "password123";

    public static void main(String[] stringArray) {
        String string = null;
        for (int i = 0; i < stringArray.length; ++i) {
            if (!stringArray[i].equals("--password") || i + 1 >= stringArray.length) continue;
            string = stringArray[i + 1];
            break;
        }
        if (string == null) {
            System.out.println("Erreur: Veuillez fournir un mot de passe avec --password");
            System.out.println("Usage: java PasswordChecker --password <votre_mot_de_passe>");
            System.exit(1);
        }
        if (PasswordChecker.checkPassword(string)) {
            System.out.println("Correct");
        } else {
            System.out.println("Mauvais");
        }
    }

    private static boolean checkPassword(String string) {
        return WEAK_PASSWORD.equals(string);
    }
}
