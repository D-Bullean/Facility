
/**
*<p>Cryptography - Cipher Block Chaining
*Takes binary input in k-bit blocks and encrypts and decrypts based 
*on XOR with previous block.
*
*@author Taylor FloydMews
*@date 03/02/2018
*/

import java.math.BigInteger;
import java.util.ArrayList;;

public class CBC {
	public String encrypt(String m, String iv, int k) {
		System.out.println("\nStarting CBC encryption...");
		ArrayList<String> blocks = new ArrayList<String>();
		// Separates message into 3-bit blocks
		for (int i = 0; i < m.length(); i += k) {
			blocks.add(m.substring(i, Math.min(i + k, m.length())));
		}
		System.out.println("Plaintext: " + blocks);
		String c = "";
		String s = "";
		for (int i = 0; i < blocks.size(); i++) { // Traverses blocks arraylist
			BigInteger bi1 = new BigInteger(blocks.get(i), 2);
			if (i == 0) { // XORs first block with initialization vector
				BigInteger bi2 = new BigInteger(iv, 2);
				s = bi1.xor(bi2).toString(2);
				s = String.format("%03d", new Integer(s));
			} else { // XORs current block with previous mapped block
				BigInteger bi2 = new BigInteger(s, 2);
				s = bi1.xor(bi2).toString(2);
				s = String.format("%03d", new Integer(s));
			}
			switch (s) { // mapping input/output handling
			case "000":
				s = "110";
				break;
			case "001":
				s = "111";
				break;
			case "010":
				s = "101";
				break;
			case "011":
				s = "100";
				break;
			case "100":
				s = "011";
				break;
			case "101":
				s = "010";
				break;
			case "110":
				s = "000";
				break;
			case "111":
				s = "001";
				break;
			default:
				System.out.println("No Mapping Available");
			}
			c = c + s; // Concatenates final ciphertext
		} 
		System.out.println("Ciphertext: " + c);
		return m;
	}

	public String decrypt(String c, String iv, int k) {
		System.out.println("\nStarting CBC decryption...");
		ArrayList<String> blocks = new ArrayList<String>();
		// Separates message into 3-bit blocks
		for (int i = 0; i < c.length(); i += k) {
			blocks.add(c.substring(i, Math.min(i + k, c.length())));
		}
		System.out.println("Ciphertext: " + blocks);
		String m = "";
		String s = "";
		for (int i = 0; i < blocks.size(); i++) { // Traverses blocks arraylist
			s = blocks.get(i);
			switch (s) { // mapping input/output handling
			case "000":
				s = "110";
				break;
			case "001":
				s = "111";
				break;
			case "010":
				s = "101";
				break;
			case "011":
				s = "100";
				break;
			case "100":
				s = "011";
				break;
			case "101":
				s = "010";
				break;
			case "110":
				s = "000";
				break;
			case "111":
				s = "001";
				break;
			default:
				System.out.println("No Mapping Available");
			}
			if (i == 0) { // XORs first block with initialization vector
				BigInteger bi1 = new BigInteger(s, 2);
				BigInteger bi2 = new BigInteger(iv, 2);
				s = bi1.xor(bi2).toString(2);
				s = String.format("%03d", new Integer(s));
			} else { // XORs current mapped block with previous block
				BigInteger bi1 = new BigInteger(s, 2);
				BigInteger bi2 = new BigInteger(blocks.get(i - 1), 2);
				s = bi1.xor(bi2).toString(2);
				s = String.format("%03d", new Integer(s));
			}
			m = m + s; // Concatenates final ciphertext
		}
		System.out.println("Plaintext: " + m);
		return c;
	}

}