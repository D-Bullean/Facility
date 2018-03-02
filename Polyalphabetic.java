/**
 * <p>
 * Cryptography - Polyalphabetic Cipher
 * </p>
 * A polyalphabetic cipher class contained an encryption method and decryption
 * method. This class takes a message to encrypt, currently only using some of
 * the ASCII table, and an array of integers as a key to tell how much each
 * character should be shifted. The key repeats after it is fully parsed from
 * the starting number
 *
 * @author Dylan Bull
 * @date 03/02/2018
 */
public class Polyalphabetic {

	public String encrypt(String plaintext, int shift[]) {
		System.out.println("\nStarting Poly Encryption...");
		String ciphertext = "";

		// Parses each character of the inputted string and checks to see if it is out
		// of the bounds or contains spaces
		for (int x = 0; x < plaintext.length(); x++) {
			char c = plaintext.charAt(x);
			if (c == ' ') {
				ciphertext += ' ';
			} else if (c > 'z' || c < 'A') {
				System.err.println("Invalid character at index:" + x + "(" + c + ")");
			} else
				// Shifting the ASCII character number by the shift amount given in the array
				ciphertext += (char) (c + shift[x % shift.length]);

		}
		System.out.println("Plaintext:" + plaintext);
		return "Ciphertext: " + ciphertext;
	}

	public String decrypt(String ciphertext, int shift[]) {
		System.out.println("\nStarting Poly Decryption...");
		String plaintext = "";
		// Parsing the ciphertext for each character and passing it through rules
		for (int x = 0; x < ciphertext.length(); x++) {
			char c = ciphertext.charAt(x);
			if (c == ' ') {
				plaintext += ' ';
			} else if (c > 'z' || c < 'A') {
				System.err.println("Invalide character at index:" + x + "(" + c + ")");
			} else
				// Reverses the shift order using the given key
				plaintext += (char) (c - shift[x % shift.length]);
		}
		System.out.println("Ciphertext:" + ciphertext);
		return "Plaintext: " + plaintext;

	}

}
