import java.math.BigInteger;
import java.util.ArrayList;

public class CA {
	private ArrayList<String> authorized_users = new ArrayList<String>();
	private BigInteger key;
	private RSA Ca = new RSA();

	CA() {
		key = BigInteger.ZERO;
	}

	public boolean authorize(String id) {
		authorized_users.add(id);
		return true;
	}

	public String certify(String id, BigInteger publicKey) {
		System.out.println("\nStarting CA...");

		String certification = "";
		if (authorized_users.contains(id)) {
			key = Ca.privEncrypt(publicKey);
			System.out.println("This is " + id + " public key:" + publicKey + "\n" + key);
			certification += Math.pow(publicKey.intValue(), key.doubleValue() % 5);
		} else {
			System.out.println(id + " is not authorized");

		}
		return certification;
	}
}
