import java.math.BigInteger;

public class Sender {
	private Package pack;
	RSA key;

	public Sender(RSA key) {
		System.out.println("Sender created...");
		System.out.println("Generate Message");
		BigInteger message = new BigInteger("70");
		System.out.println("Message:" + message);

		System.out.println("Hashing Message");
		DigitalSignature hasher = new DigitalSignature();
		BigInteger hashMessage = hasher.hash(message);
		System.out.println("Hashed Message:" + hashMessage);

		System.out.println("Sign H(m) with Senders Private Key");

	}
}
