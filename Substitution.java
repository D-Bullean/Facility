/**
 * <p>
 * Cryptography - Substitution Cipher (Substitution Cipher)
 * </p>
 * This Substitution cipher again contains two methods for encrypting and decrypting.
 * It takes ASCII character inputs right now, but can be later changed to work with more.
 * These characters are mapped to a predetermined key and are encrypted this way.
 * @author Dylan Bull
 * @date 03/02/2018
 */
import java.math.BigInteger;

public class Substitution {

	public String encrypt(String plaintext) {
		System.out.println("\nStarting Substitution Encryption...");
		String ciphertext = "";
		String key = "qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM";
		// Parsing input to get each character
		for (int x = 0; x < plaintext.length(); x++) {
			char c = plaintext.charAt(x);
			if (c == ' ') {
				ciphertext += ' ';
			} else if (c > 'z' || c < 'A') {
				System.err.println("Invalid character at index:" + x + "(" + c + ")");
			} else {
				// Modifying the index of the character input to work with the key mapping
				int index = (int) (c % 65);
				ciphertext += key.charAt(index);
			}
		}
		System.out.println("Plaintext: " + plaintext);
		return "Ciphertext: " + ciphertext;
	}

	public String decrypt(String ciphertext) {
		System.out.println("\nStarting Substitution Decryption...");
		String plaintext = "";
		String key = "qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM";
		// Parse the ciphertext to get each character which will be manipulated
		for (int x = 0; x < ciphertext.length(); x++) {
			char c = ciphertext.charAt(x);
			if (c == ' ') {
				plaintext += ' ';
			} else if (c > 'z' || c < 'A') {
				System.err.println("Invalid character at index:" + x + "(" + c + ")");
			} else {
				// Modifying the index of the character input to work with the key mapping
				int index = x + 65;
				plaintext += (char) index;
			}
		}
		System.out.println("Ciphertext: " + ciphertext);
		return "Plaintext: " + plaintext;
	}

}