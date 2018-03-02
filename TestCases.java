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

		int[] shifts = { 1, 2, 5 };
		// Shift Cipher Testing
		System.out.println(_shift.encrypt("Hello World", 53));
		System.out.println(_shift.decrypt("}JQQT <TWQI", 53));
		// Substituition Cipher Testing
		System.out.println(_sub.encrypt("ABCDEFGHIJKLM"));
		System.out.println(_sub.decrypt("qwertyuiopasd"));
		// Polyalphabetic Cipher Testing
		System.out.println(_poly.encrypt("Hello World", shifts));
		System.out.println(_poly.decrypt("Igqmq Xqwmf", shifts));
		// RSA Cipher Testing
		BigInteger message = new BigInteger("4");
		BigInteger m = _rsa.encrypt(message);
		BigInteger n = _rsa.decrypt(_rsa.encrypt(message));
		System.out.println(m.toString());
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

		//
	}
}
