import java.math.BigInteger;
import java.util.ArrayList;

public class CA {
	private ArrayList<String> authorized_users = new ArrayList<String>();

	public boolean authorize(String id) {
		authorized_users.add(id);
		return true;
	}

	public String certify(String id, String publicKey) {
		System.out.println("\nStarting CA...");
		BigInteger CaKey = new BigInteger("1000");
		String certification = "";
		if (authorized_users.contains(id)) {
			System.out.println("This is " + id + " public key:" + publicKey + "\n" + CaKey);
			certification += Math.pow(Integer.parseInt(publicKey), CaKey.doubleValue() % 5);
		} else {
			System.out.println(id + " is not authorized");

		}
		return certification;
	}
}
