import java.math.BigInteger;

public class TestCases {

	public static void main(String[] args) {
		ShiftCipher _shift = new ShiftCipher();
		Substitution _sub = new Substitution();
		Polyalphabetic _poly = new Polyalphabetic();
		RSA _rsa = new RSA();
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
		System.out.println("\t--Plaintext:" + _message);
		System.out.println("\t--Ciphertext:" + encryptShift);
		System.out.println("Decrypt Test:");

		// Substituition Cipher Testing
		System.out.println(_sub.encrypt("ABCDEFGHIJKLM"));
		System.out.println(_sub.decrypt("qwertyuiopasd"));
		// Polyalphabetic Cipher Testing
		System.out.println(_poly.encrypt("Hello World", shifts));
		System.out.println(_poly.decrypt("Igqmq Xqwmf", shifts));
		// RSA Cipher Testing
		BigInteger message = new BigInteger("2309490");
		_rsa.init();
		BigInteger encrypted = _rsa.privEncrypt(message);
		System.out.println(encrypted.toString());
		// System.out.println(m.toString());
		// Block Cipher Testing *currently only works with 3 as a key size*
		_block.encrypt("010110001111", 3);
		_block.decrypt("101000111001", 3);
		// Chain Block Cipher testing *supports 3 right now*
		_cbc.encrypt("010110001111", "010", 3);
		_cbc.decrypt("110110001000", "010", 3);
		// MAC testing
		MAC_package pack = new MAC_package();
		pack = _mac.encrypt(message, message);
		System.out.println("\nMessage Authenticated:" + _mac.verify(message, pack));
		// CA Testing
		System.out.println(_ca.authorize("8675309"));

		System.out.println("Testing Network");
		RSA_Keys key = new RSA_Keys();
		Sender amy = new Sender(key, 0);
		Receiver bob = new Receiver();
		Network net = new Network();

		net.deliverPacketToReceiver(amy.getPacket());
		net.hackedPacket(0);
		bob.receive(net, key.receiver);

	}
}
