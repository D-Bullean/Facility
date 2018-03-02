
/**
*<p>Cryptography - Block Cipher
*Takes binary input in k-bit blocks and encrypts and decrypts based
*on 1:1 preset k-bit block mapping. 
*
*@author Taylor FloydMews
*@date 03/02/2018
*/

import java.util.ArrayList;;

public class blockCipher {
	public String encrypt(String m, int k) {
		System.out.println("\nStarting Block encryption...");
		ArrayList<String> blocks = new ArrayList<String>();
		// Separates message into 3-bit blocks
		for (int i = 0; i < m.length(); i += k) {
			blocks.add(m.substring(i, Math.min(i + k, m.length())));
		}
		System.out.println("Plaintext: " + blocks);

		String c = "";

		for (int i = 0; i < blocks.size(); i++) { // Traverses blocks arraylist
			String s = blocks.get(i);
			// mapping input/output handling & concatenation of final ciphertext
			switch (s) {
			case "000":
				c = c + "110";
				break;
			case "001":
				c = c + "111";
				break;
			case "010":
				c = c + "101";
				break;
			case "011":
				c = c + "100";
				break;
			case "100":
				c = c + "011";
				break;
			case "101":
				c = c + "010";
				break;
			case "110":
				c = c + "000";
				break;
			case "111":
				c = c + "001";
				break;
			default:
				System.out.println("No Mapping Available");
			}
		}
		System.out.println("Ciphertext: " + c);
		return m;
	}

	public String decrypt(String c, int k) {
		System.out.println("\nStarting Block Decryption...");
		ArrayList<String> blocks = new ArrayList<String>();
		// Separates message into 3-bit blocks
		for (int i = 0; i < c.length(); i += k) {
			blocks.add(c.substring(i, Math.min(i + k, c.length())));
		}
		System.out.println("Ciphertext: " + blocks);

		String m = "";

		for (int i = 0; i < blocks.size(); i++) { // Traverses blocks arraylist
			String s = blocks.get(i);
			// mapping input/output handling & concatenation of final ciphertext
			switch (s) {
			case "000":
				m = m + "110";
				break;
			case "001":
				m = m + "111";
				break;
			case "010":
				m = m + "101";
				break;
			case "011":
				m = m + "100";
				break;
			case "100":
				m = m + "011";
				break;
			case "101":
				m = m + "010";
				break;
			case "110":
				m = m + "000";
				break;
			case "111":
				m = m + "001";
				break;
			default:
				System.out.println("No Mapping Available");
			}
		}
		System.out.println("Plaintext: " + m);
		return c;
	}

}