import java.math.BigInteger;

public class Substitution {

	public BigInteger encrypt(BigInteger message, BigInteger key) {
		String alphabet = "0123456789";
		String ciphertext = "";
		String m = message.toString();
		String k = key.toString();
		for (int x = 0; x < m.length(); x++) {
			for (int y = 0; y < alphabet.length(); y++) {
				if (m.charAt(x) == alphabet.charAt(y)) {
					ciphertext += k.charAt(y);
				}
			}
		}
		BigInteger cipher = new BigInteger(ciphertext);
		return cipher;
	}

	public BigInteger decrypt(BigInteger cipher, BigInteger key) {
		String alphabet = "0123456789";
		String plaintext = "";
		String c = cipher.toString();
		String k = key.toString();
		for (int x = 0; x < c.length(); x++) {
			for (int y = 0; y < k.length(); y++) {
				if (c.charAt(x) == k.charAt(y)) {
					plaintext += alphabet.charAt(y);
				}
			}
		}
		BigInteger plain = new BigInteger(plaintext);
		return plain;
	}

}