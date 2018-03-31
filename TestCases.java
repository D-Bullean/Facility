
/**
*<p>Cryptography - Test Case
*
*Test case class containing several cases for encryption facility
*Along with the newly added network, receiver, and sender classes
*
*@author Dylan Bull
*@date 03/30/2018
*/

import java.math.BigInteger;

public class TestCases {

	public static void main(String[] args) {
		ShiftCipher _shift = new ShiftCipher();
		Substitution _sub = new Substitution();
		Polyalphabetic _poly = new Polyalphabetic();
		RSA _rsa = new RSA();
		_rsa.init();
		blockCipher _block = new blockCipher();
		CBC _cbc = new CBC();
		MAC _mac = new MAC();
		CA _ca = new CA();

		int[] shifts = { 1, 2, 5 };
		// Shift Cipher Testing
		BigInteger _message = new BigInteger("100");
		BigInteger keys = new BigInteger("5");
		System.out.println("----Shift Cipher----\nEncrypt Test:");
		BigInteger encryptShift = _shift.encrypt(_message, keys);
		System.out.println("\t--Plain:" + _message + "\n\t--Cipher:" + encryptShift);
		System.out.println("Decrypt Test:");
		BigInteger decryptShift = _shift.decrypt(encryptShift, keys);
		System.out.println("\t--Plain:" + decryptShift + "\n\t--Cipher:" + encryptShift);

		// Substitution testing
		System.out.println("\n----Substitution test----");
		String subEncrypt = _sub.encrypt("abcdef");
		System.out.println("\t--Plaintext:" + _message + "\n\t--Ciphertext:" + subEncrypt);
		String subDecrypt = _sub.decrypt(subEncrypt);
		System.out.println("\t--Cipher:" + subEncrypt + "\n\t--Plain:" + subDecrypt);

		// RSA Testing
		System.out.println("\n----RSA Testing----");
		_rsa.init();
		BigInteger encryptRSA = _rsa.privEncrypt(_message);
		BigInteger pubEncryptRSA = _rsa.pubEncrypt(_message);
		BigInteger decryptRSA = _rsa.privDecrypt(encryptRSA);
		BigInteger pubDecryptRSA = _rsa.pubDecrypt(encryptRSA);
		System.out.println("Private\n\t--Encrypt:" + encryptRSA + "\n\t--Decrypt:" + decryptRSA);
		System.out.println("Public\n\t--Encrypt:" + pubEncryptRSA + "\n\t--Decrypt:" + pubDecryptRSA);

		// Network Testing

		System.out.println("--------Testing Network--------");
		RSA_Keys key = new RSA_Keys();
		Network net = new Network();
		Receiver bob = new Receiver();
		Sender amy = new Sender(key, 1);

		net.deliverPacketToReceiver(amy.getPacket());

		// Integer below is shift in message
		net.hackedPacket(0);
		bob.receive(net, key, 1);

	}
}
