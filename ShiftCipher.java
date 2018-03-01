public class ShiftCipher {
	public String encrypt(String plaintext, int shift) {
		System.out.println("Starting Encryption...");
		String ciphertext = "";
		if (shift > 122)
			shift = shift % 122;

		for (int x = 0; x < plaintext.length(); x++) {
			char c = plaintext.charAt(x);
			if (c == ' ') {
				ciphertext += ' ';
			} else if (c > 'z') {
				c = (char) (c & 'z');
				c = (char) (c + shift);
				ciphertext += c;
			} else {
				c = (char) (c + shift);
				ciphertext += c;
			}

		}
		System.out.println("Plaintext: " + plaintext);
		return "Ciphertext: " + ciphertext;

	}

	public String decrypt(String ciphertext, int shift) {
		System.out.println("Starting Decryption...");
		String plaintext = "";
		if (shift > 122)
			shift = (shift & 122);

		for (int x = 0; x < ciphertext.length(); x++) {
			char c = ciphertext.charAt(x);
			if (c == ' ') {
				plaintext += ' ';
			} else if (c > 'z') {
				System.out.println("Error this shouldn't be generated from encryption!");
			} else {
				c = (char) (c - shift);
				plaintext += c;
			}
		}

		System.out.println("Ciphertext: " + ciphertext);
		return "Plaintext: " + plaintext;
	}
}
