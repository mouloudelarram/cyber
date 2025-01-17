import subprocess

# Fonction pour tester un mot de passe
def try_password(password):
    # Lancer la commande Java avec le mot de passe courant
    result = subprocess.run(['java', 'PasswordChecker', '--password', password], capture_output=True, text=True)
    
    # Si l'application retourne "Correct password!", on a trouvé le mot de passe
    if "Correct" in result.stdout:
        print(f"Mot de passe trouvé : {password}")
        return True
    return False

# Fonction de brute force utilisant un dictionnaire
def brute_force_from_dictionary(dictionary_file):
    # Ouvrir le fichier dictionnaire
    with open(dictionary_file, 'r') as file:
        for line in file:
            # Nettoyer la ligne (enlever les espaces et les retours à la ligne)
            password = line.strip()
            
            print(f"Essai du mot de passe : {password}")
            
            # Tester le mot de passe
            if try_password(password):
                break  # Si le mot de passe est trouvé, on arrête

# Dictionnaire à utiliser (vous pouvez modifier le chemin ici)
#dictionary_file = 'dictionnaire.txt'
dictionary_file = '/home/vagrant/Desktop/cyber/SecLists/Passwords/Leaked-Databases/rockyou-75.txt'


# Lancer l'attaque brute force
brute_force_from_dictionary(dictionary_file)
