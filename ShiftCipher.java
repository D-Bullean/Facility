/**
 * <p>
 * Cryptography - Shift Cipher (Caesar Cipher)
 * </p>
 * A simple shift cipher class that has an encryption and decryption method.
 * Both of these methods will take inputted strings and then parse them. The
 * methods also takes a shift amount which will be the key of the system.
 *
 * @author Dylan Bull
 * @date 03/02/2018
 */
public class ShiftCipher {
	public String encrypt(String plaintext, int shift) {
		System.out.println("\nStarting Shift Encryption...");
		String ciphertext = "";
		// Parses the plaintext for each character then takes the index and shifts it
		// accordingly
		for (int x = 0; x < plaintext.length(); x++) {
			char c = plaintext.charAt(x);
			if (c == ' ') {
				ciphertext += ' ';
			} else if (c + shift >= 128) {
				ciphertext += (char) (((c + shift) % 128) + 48);
			} else
				ciphertext += (char) (c + shift);

		}
		System.out.println("Plaintext: " + plaintext);
		return "Ciphertext: " + ciphertext;

	}

	public String decrypt(String ciphertext, int shift) {
		System.out.println("\nStarting Shift Decryption...");
		String plaintext = "";
		// Parse the ciphertext and reverse the shift on the index of the given
		// character
		for (int x = 0; x < ciphertext.length(); x++) {
			char c = ciphertext.charAt(x);
			if (c == ' ') {
				plaintext += ' ';
			} else if (c - shift <= 48) {
				plaintext += (char) (((c - shift) + 128) - 48);
			} else
				plaintext += (char) (c - shift);

		}

		System.out.println("Ciphertext: " + ciphertext);
		return "Plaintext: " + plaintext;
	}
}
