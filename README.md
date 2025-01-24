# cyber

# README - Commandes utilisées pour l'analyse et la correction des programmes

Ce fichier répertorie les principales commandes utilisées pour analyser, décompiler, et sécuriser les programmes `p1` (client) et `p2` (serveur).

## 1. Commandes d'analyse

### a) Capturer le trafic réseau avec `tcpdump`
Permet de capturer tout le trafic réseau et de le sauvegarder dans un fichier `.pcap` pour analyse :

```bash
sudo tcpdump -i any -w capture.pcap
b) Décompiler le fichier JAR du client p1_mod.jar avec jadx
Utilisé pour extraire le code source du fichier .jar du client :

bash
Copier
Modifier
jadx -d p1_source p1_mod.jar
c) Casser un hash avec hashcat en utilisant une liste de mots (rockyou.txt)
Utilise une attaque par dictionnaire avec la liste de mots rockyou.txt pour tenter de cracker le hash :

bash
Copier
Modifier
hashcat -m 1400 -a 0 hash.txt /usr/share/wordlists/rockyou.txt --session new_session
d) Casser un hash avec hashcat en utilisant une attaque brute
Teste toutes les combinaisons possibles pour cracker le hash :

bash
Copier
Modifier
hashcat -m 1400 -a 3 hash.txt ?a?a?a?a?a?a?a?a
2. Commandes de génération du certificat SSL
a) Générer un certificat SSL avec keytool
Crée un certificat SSL auto-signé pour sécuriser les communications entre le serveur et le client :

bash
Copier
Modifier
keytool -genkey -keyalg RSA -alias server -keystore server.keystore -validity 365 -keysize 2048
3. Commandes de démarrage du serveur et du client
a) Démarrer le serveur avec SSL
Démarre le serveur p2 avec SSL en spécifiant le keystore et le mot de passe du certificat SSL :

bash
Copier
Modifier
java -Djavax.net.ssl.keyStore=server.keystore -Djavax.net.ssl.keyStorePassword=password P2
b) Démarrer le client
Démarre le client p1 pour établir une connexion avec le serveur :

bash
Copier
Modifier
java P1
