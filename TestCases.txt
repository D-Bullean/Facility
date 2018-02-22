import java.math.BigInteger;

public class TestCases {

	public static void main(String[] args) {
		BigInteger message = new BigInteger("123123");
		BigInteger cipher = new BigInteger("876876");
		BigInteger key = new BigInteger("9876543210");
		Substitution _sub = new Substitution();
		Polyalphabetic _poly = new Polyalphabetic();
		System.out.println(_sub.encrypt(message, key));
		System.out.println(_sub.decrypt(cipher, key));
		_poly.encrypt("ke", "helloworld");
		_poly.decrypt("ke", "rivpyayvvh");
	}
}
