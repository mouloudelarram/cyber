import string
import subprocess

# Set the characters to try (numbers, lowercase and uppercase letters)
charset = string.ascii_lowercase + string.ascii_uppercase + string.digits

# Function to try a password
def try_password(password):
    # Use subprocess to call the Java program with the current password
    result = subprocess.run(['java', 'PasswordChecker', '--password', password], capture_output=True, text=True)
    
    # Check if the output contains the correct message
    if "Mauvais" not in result.stdout:  # Modify based on the program's output
        print(f"Password found: {password}")
        return True
    return False

# Brute force through all combinations of characters up to a given length
def brute_force(length):
    # Create all combinations of passwords of a certain length
    for password in itertools.product(charset, repeat=length):
        # Join tuple into string
        password_str = ''.join(password)
        print(f"Trying: {password_str}")
        if try_password(password_str):
            break

# Example: Try all 4-character combinations
import itertools
for i in range(100):
	brute_force(i)
#brute_force(5)
